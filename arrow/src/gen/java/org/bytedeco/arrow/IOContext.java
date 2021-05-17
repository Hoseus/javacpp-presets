// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** EXPERIMENTAL: options provider for IO tasks
 * 
 *  Includes an Executor (which will be used to execute asynchronous reads),
 *  a MemoryPool (which will be used to allocate buffers when zero copy reads
 *  are not possible), and an external id (in case the executor receives tasks from
 *  multiple sources and must distinguish tasks associated with this IOContext). */
@Namespace("arrow::io") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class IOContext extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IOContext(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IOContext(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public IOContext position(long position) {
        return (IOContext)super.position(position);
    }
    @Override public IOContext getPointer(long i) {
        return new IOContext((Pointer)this).offsetAddress(i);
    }

  // No specified executor: will use a global IO thread pool
  public IOContext() { super((Pointer)null); allocate(); }
  private native void allocate();

  public IOContext(@ByVal StopToken stop_token) { super((Pointer)null); allocate(stop_token); }
  private native void allocate(@ByVal StopToken stop_token);

  public IOContext(MemoryPool pool, @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token) { super((Pointer)null); allocate(pool, stop_token); }
  private native void allocate(MemoryPool pool, @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token);
  public IOContext(MemoryPool pool) { super((Pointer)null); allocate(pool); }
  private native void allocate(MemoryPool pool);

  public IOContext(MemoryPool pool, Executor executor,
                       @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token,
                       @Cast("int64_t") long external_id/*=-1*/) { super((Pointer)null); allocate(pool, executor, stop_token, external_id); }
  private native void allocate(MemoryPool pool, Executor executor,
                       @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token,
                       @Cast("int64_t") long external_id/*=-1*/);
  public IOContext(MemoryPool pool, Executor executor) { super((Pointer)null); allocate(pool, executor); }
  private native void allocate(MemoryPool pool, Executor executor);

  public IOContext(Executor executor,
                       @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token,
                       @Cast("int64_t") long external_id/*=-1*/) { super((Pointer)null); allocate(executor, stop_token, external_id); }
  private native void allocate(Executor executor,
                       @ByVal(nullValue = "arrow::StopToken::Unstoppable()") StopToken stop_token,
                       @Cast("int64_t") long external_id/*=-1*/);
  public IOContext(Executor executor) { super((Pointer)null); allocate(executor); }
  private native void allocate(Executor executor);

  public native MemoryPool pool();

  public native Executor executor();

  // An application-specific ID, forwarded to executor task submissions
  public native @Cast("int64_t") long external_id();

  public native @ByVal StopToken stop_token();
}