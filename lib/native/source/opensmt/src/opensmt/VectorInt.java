/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensmt;

public class VectorInt extends java.util.AbstractList<Integer> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VectorInt(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VectorInt obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(VectorInt obj) {
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
        OsmtNativeJNI.delete_VectorInt(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VectorInt(int[] initialElements) {
    this();
    reserve(initialElements.length);

    for (int element : initialElements) {
      add(element);
    }
  }

  public VectorInt(Iterable<Integer> initialElements) {
    this();
    for (int element : initialElements) {
      add(element);
    }
  }

  public Integer get(int index) {
    return doGet(index);
  }

  public Integer set(int index, Integer e) {
    return doSet(index, e);
  }

  public boolean add(Integer e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, Integer e) {
    modCount++;
    doAdd(index, e);
  }

  public Integer remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public VectorInt() {
    this(OsmtNativeJNI.new_VectorInt__SWIG_0(), true);
  }

  public VectorInt(VectorInt other) {
    this(OsmtNativeJNI.new_VectorInt__SWIG_1(VectorInt.getCPtr(other), other), true);
  }

  public long capacity() {
    return OsmtNativeJNI.VectorInt_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    OsmtNativeJNI.VectorInt_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return OsmtNativeJNI.VectorInt_isEmpty(swigCPtr, this);
  }

  public void clear() {
    OsmtNativeJNI.VectorInt_clear(swigCPtr, this);
  }

  public VectorInt(int count, int value) {
    this(OsmtNativeJNI.new_VectorInt__SWIG_2(count, value), true);
  }

  private int doSize() {
    return OsmtNativeJNI.VectorInt_doSize(swigCPtr, this);
  }

  private void doAdd(int x) {
    OsmtNativeJNI.VectorInt_doAdd__SWIG_0(swigCPtr, this, x);
  }

  private void doAdd(int index, int x) {
    OsmtNativeJNI.VectorInt_doAdd__SWIG_1(swigCPtr, this, index, x);
  }

  private int doRemove(int index) {
    return OsmtNativeJNI.VectorInt_doRemove(swigCPtr, this, index);
  }

  private int doGet(int index) {
    return OsmtNativeJNI.VectorInt_doGet(swigCPtr, this, index);
  }

  private int doSet(int index, int val) {
    return OsmtNativeJNI.VectorInt_doSet(swigCPtr, this, index, val);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    OsmtNativeJNI.VectorInt_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
