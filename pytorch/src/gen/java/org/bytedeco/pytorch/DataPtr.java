// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


// A DataPtr is a unique pointer (with an attached deleter and some
// context for the deleter) to some memory, which also records what
// device is for its data.
//
// nullptr DataPtrs can still have a nontrivial device; this allows
// us to treat zero-size allocations uniformly with non-zero allocations.
//
@Namespace("c10") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class DataPtr extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DataPtr(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DataPtr(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DataPtr position(long position) {
        return (DataPtr)super.position(position);
    }
    @Override public DataPtr getPointer(long i) {
        return new DataPtr((Pointer)this).offsetAddress(i);
    }

  // Choice of CPU here is arbitrary; if there's an "undefined" device
  // we could use that too
  public DataPtr() { super((Pointer)null); allocate(); }
  private native void allocate();
  public DataPtr(Pointer data, @ByVal Device device) { super((Pointer)null); allocate(data, device); }
  private native void allocate(Pointer data, @ByVal Device device);
  public DataPtr(Pointer data, Pointer ctx, Deleter ctx_deleter, @ByVal Device device) { super((Pointer)null); allocate(data, ctx, ctx_deleter, device); }
  private native void allocate(Pointer data, Pointer ctx, Deleter ctx_deleter, @ByVal Device device);
  public native @Name("operator ->") Pointer access();
  public native void clear();
  public native Pointer get();
  public native Pointer get_context();
  public native Pointer release_context();
  
  public native @Cast("bool") @Name("operator bool") boolean asBoolean();
  public native Deleter get_deleter();
  /**
   * Compare the deleter in a DataPtr to expected_deleter.
   * If it matches, replace the deleter with new_deleter
   * and return true; otherwise, does nothing and returns
   * false.
   *
   * In general, it is not safe to unconditionally set the
   * deleter on a DataPtr, because you don't know what
   * the deleter is, and thus will have a hard time properly
   * disposing of the deleter without storing the original
   * deleter (this is difficult to do, because DeleterFnPtr
   * is not a closure, and because the context on DataPtr is
   * only a single word, you generally don't have enough
   * space to store both the original deleter and its context).
   * However, in some cases, you know /exactly/ what the deleter
   * is, and you have a new deleter that manually wraps
   * the old one.  In this case, you can safely swap the deleter
   * after asserting that the deleters line up.
   *
   * What are the requirements on new_deleter?  It must still
   * properly dispose of the void* pointer passed in as its argument,
   * where void* is whatever the context of the original deleter
   * is.  So in general, you expect the new deleter to look something
   * like this:
   *
   *      [](void* ptr) {
   *        some_new_stuff(ptr);
   *        get_orig_allocator()->raw_deleter(ptr);
   *      }
   *
   * Note that it won't work to close over the original
   * allocator; you don't have enough space to do that!  Also,
   * it's unsafe to assume that the passed in pointer in
   * question is the memory pointer in question; it might not
   * be; be sure to read the source code of the Allocator
   * in question to confirm this.
   */
  public native @Cast("bool") boolean compare_exchange_deleter(Deleter expected_deleter, Deleter new_deleter);
  public native @ByVal Device device();
  // Unsafely mutates the device on a DataPtr.  Under normal use,
  // you should never actually need to call this function.
  // We need this for the implementation of the hack detailed
  // in Note [Masquerading as CUDA]
  public native void unsafe_set_device(@ByVal Device device);
}