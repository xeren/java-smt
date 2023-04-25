/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensmt;

public class Logic {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Logic(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Logic obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(Logic obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        OsmtNativeJNI.delete_Logic(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public PTRef mkAnd(PTRef a1, PTRef a2) {
    return new PTRef(OsmtNativeJNI.Logic_mkAnd(swigCPtr, this, PTRef.getCPtr(a1), a1, PTRef.getCPtr(a2), a2), true);
  }

  public PTRef mkOr(PTRef a1, PTRef a2) {
    return new PTRef(OsmtNativeJNI.Logic_mkOr(swigCPtr, this, PTRef.getCPtr(a1), a1, PTRef.getCPtr(a2), a2), true);
  }

  public PTRef mkXor(PTRef a1, PTRef a2) {
    return new PTRef(OsmtNativeJNI.Logic_mkXor(swigCPtr, this, PTRef.getCPtr(a1), a1, PTRef.getCPtr(a2), a2), true);
  }

  public PTRef mkImpl(PTRef a1, PTRef a2) {
    return new PTRef(OsmtNativeJNI.Logic_mkImpl(swigCPtr, this, PTRef.getCPtr(a1), a1, PTRef.getCPtr(a2), a2), true);
  }

  public PTRef mkNot(PTRef arg0) {
    return new PTRef(OsmtNativeJNI.Logic_mkNot(swigCPtr, this, PTRef.getCPtr(arg0), arg0), true);
  }

  public PTRef mkIte(PTRef c, PTRef t, PTRef e) {
    return new PTRef(OsmtNativeJNI.Logic_mkIte(swigCPtr, this, PTRef.getCPtr(c), c, PTRef.getCPtr(t), t, PTRef.getCPtr(e), e), true);
  }

  public PTRef mkEq(PTRef a1, PTRef a2) {
    return new PTRef(OsmtNativeJNI.Logic_mkEq(swigCPtr, this, PTRef.getCPtr(a1), a1, PTRef.getCPtr(a2), a2), true);
  }

  public PTRef mkBoolVar(String name) {
    return new PTRef(OsmtNativeJNI.Logic_mkBoolVar(swigCPtr, this, name), true);
  }

  public PTRef getTerm_true() {
    return new PTRef(OsmtNativeJNI.Logic_getTerm_true(swigCPtr, this), true);
  }

  public PTRef getTerm_false() {
    return new PTRef(OsmtNativeJNI.Logic_getTerm_false(swigCPtr, this), true);
  }

  public String pp(PTRef tr) {
    return OsmtNativeJNI.Logic_pp(swigCPtr, this, PTRef.getCPtr(tr), tr);
  }

}
