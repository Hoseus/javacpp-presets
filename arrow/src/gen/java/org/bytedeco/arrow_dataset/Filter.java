// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class Filter extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Filter(Pointer p) { super(p); }

  public Filter(FilterType.type type) { super((Pointer)null); allocate(type); }
  private native void allocate(FilterType.type type);
  public Filter(@Cast("arrow::dataset::FilterType::type") int type) { super((Pointer)null); allocate(type); }
  private native void allocate(@Cast("arrow::dataset::FilterType::type") int type);

  public native FilterType.type type();
}