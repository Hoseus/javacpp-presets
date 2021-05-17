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
 // namespace functional

// ============================================================================

/** Options for the {@code TripletMarginLoss} module.
 * 
 *  Example:
 *  <pre>{@code
 *  TripletMarginLoss model(TripletMarginLossOptions().margin(3).p(2).eps(1e-06).swap(false));
 *  }</pre> */
@Namespace("torch::nn") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class TripletMarginLossOptions extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public TripletMarginLossOptions() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TripletMarginLossOptions(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TripletMarginLossOptions(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TripletMarginLossOptions position(long position) {
        return (TripletMarginLossOptions)super.position(position);
    }
    @Override public TripletMarginLossOptions getPointer(long i) {
        return new TripletMarginLossOptions((Pointer)this).offsetAddress(i);
    }

  public native @ByRef @NoException DoublePointer margin();
  public native @ByRef @NoException DoublePointer p();
  public native @ByRef @NoException DoublePointer eps();
  public native @Cast("bool*") @ByRef @NoException BoolPointer swap();
  public native @Cast("torch::nn::TripletMarginLossOptions::reduction_t*") @ByRef @NoException Pointer reduction();
}