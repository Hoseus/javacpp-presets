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


@Namespace("torch::nn") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class ParameterDict extends ParameterDictImplModuleHolder {
    static { Loader.load(); }

    
      public ParameterDict() { super((Pointer)null); allocate(); }
      private native void allocate(); public ParameterDict(@ByVal @Cast("std::nullptr_t*") PointerPointer arg0) { super((Pointer)null); allocate(arg0); }
    private native void allocate(@ByVal @Cast("std::nullptr_t*") PointerPointer arg0); public ParameterDict(@SharedPtr @Cast({"", "std::shared_ptr<torch::nn::ParameterDictImpl>"}) ParameterDictImpl module) { super((Pointer)null); allocate(module); }
    private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<torch::nn::ParameterDictImpl>"}) ParameterDictImpl module);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ParameterDict(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ParameterDict(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ParameterDict position(long position) {
        return (ParameterDict)super.position(position);
    }
    @Override public ParameterDict getPointer(long i) {
        return new ParameterDict((Pointer)this).offsetAddress(i);
    }

  }