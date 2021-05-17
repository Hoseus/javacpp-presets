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

@NoOffset @Name("c10::optional<std::vector<at::Tensor> >") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class TensorVectorOptional extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorVectorOptional(Pointer p) { super(p); }
    public TensorVectorOptional(@StdMove TensorVector value) { this(); put(value); }
    public TensorVectorOptional()       { allocate();  }
    private native void allocate();
    public native @Name("operator =") @ByRef TensorVectorOptional put(@ByRef TensorVectorOptional x);


    @Name("value") public native @StdMove TensorVector get();
    @ValueSetter public native TensorVectorOptional put(@StdMove TensorVector value);
}
