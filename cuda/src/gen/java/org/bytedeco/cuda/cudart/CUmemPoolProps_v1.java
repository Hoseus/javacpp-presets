// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.cudart;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cuda.global.cudart.*;


/**
 * Specifies the properties of allocations made from the pool.
 */
@Properties(inherit = org.bytedeco.cuda.presets.cudart.class)
public class CUmemPoolProps_v1 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CUmemPoolProps_v1() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CUmemPoolProps_v1(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CUmemPoolProps_v1(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CUmemPoolProps_v1 position(long position) {
        return (CUmemPoolProps_v1)super.position(position);
    }
    @Override public CUmemPoolProps_v1 getPointer(long i) {
        return new CUmemPoolProps_v1((Pointer)this).offsetAddress(i);
    }

    /** Allocation type. Currently must be specified as CU_MEM_ALLOCATION_TYPE_PINNED */
    public native @Cast("CUmemAllocationType") int allocType(); public native CUmemPoolProps_v1 allocType(int setter);
    /** Handle types that will be supported by allocations from the pool. */
    public native @Cast("CUmemAllocationHandleType") int handleTypes(); public native CUmemPoolProps_v1 handleTypes(int setter);
    /** Location where allocations should reside. */
    public native @ByRef @Cast("CUmemLocation*") CUmemLocation_v1 location(); public native CUmemPoolProps_v1 location(CUmemLocation_v1 setter);
    /**
     * Windows-specific LPSECURITYATTRIBUTES required when
     * ::CU_MEM_HANDLE_TYPE_WIN32 is specified.  This security attribute defines
     * the scope of which exported allocations may be tranferred to other
     * processes.  In all other cases, this field is required to be zero.
     */
    public native Pointer win32SecurityAttributes(); public native CUmemPoolProps_v1 win32SecurityAttributes(Pointer setter);
    /** reserved for future use, must be 0 */
    public native @Cast("unsigned char") byte reserved(int i); public native CUmemPoolProps_v1 reserved(int i, byte setter);
    @MemberGetter public native @Cast("unsigned char*") BytePointer reserved();
}