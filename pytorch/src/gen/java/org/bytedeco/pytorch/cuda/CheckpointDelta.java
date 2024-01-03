// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch.cuda;

import org.bytedeco.pytorch.*;
import org.bytedeco.pytorch.functions.*;
import org.bytedeco.pytorch.Error;
import org.bytedeco.pytorch.global.torch.DeviceType;
import org.bytedeco.pytorch.global.torch.ScalarType;
import org.bytedeco.pytorch.global.torch.MemoryFormat;
import org.bytedeco.pytorch.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.pytorch.*;
import static org.bytedeco.pytorch.global.torch.*;

import static org.bytedeco.pytorch.global.torch_cuda.*;


// returns the pointers freed in the pool
// and the pointers allocated. Note: a pointer
// may appear in both freed and allocated
@Namespace("c10::cuda::CUDACachingAllocator") @Properties(inherit = org.bytedeco.pytorch.presets.torch_cuda.class)
public class CheckpointDelta extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CheckpointDelta() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CheckpointDelta(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CheckpointDelta(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CheckpointDelta position(long position) {
        return (CheckpointDelta)super.position(position);
    }
    @Override public CheckpointDelta getPointer(long i) {
        return new CheckpointDelta((Pointer)this).offsetAddress(i);
    }

  @MemberGetter public native @Cast("void**") @StdVector PointerPointer ptrs_freed();
  @MemberGetter public native @ByRef DataPtrVector dataptrs_allocd();
}