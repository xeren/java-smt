/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensmt;

public final class opensmt_logic {
  public final static opensmt_logic qf_uf = new opensmt_logic("qf_uf");
  public final static opensmt_logic qf_cuf = new opensmt_logic("qf_cuf");
  public final static opensmt_logic qf_bv = new opensmt_logic("qf_bv");
  public final static opensmt_logic qf_rdl = new opensmt_logic("qf_rdl");
  public final static opensmt_logic qf_idl = new opensmt_logic("qf_idl");
  public final static opensmt_logic qf_lra = new opensmt_logic("qf_lra");
  public final static opensmt_logic qf_lia = new opensmt_logic("qf_lia");
  public final static opensmt_logic qf_ufrdl = new opensmt_logic("qf_ufrdl");
  public final static opensmt_logic qf_ufidl = new opensmt_logic("qf_ufidl");
  public final static opensmt_logic qf_uflra = new opensmt_logic("qf_uflra");
  public final static opensmt_logic qf_uflia = new opensmt_logic("qf_uflia");
  public final static opensmt_logic qf_ax = new opensmt_logic("qf_ax");
  public final static opensmt_logic qf_alra = new opensmt_logic("qf_alra");
  public final static opensmt_logic qf_alia = new opensmt_logic("qf_alia");
  public final static opensmt_logic qf_auflra = new opensmt_logic("qf_auflra");
  public final static opensmt_logic qf_auflia = new opensmt_logic("qf_auflia");
  public final static opensmt_logic qf_bool = new opensmt_logic("qf_bool");
  public final static opensmt_logic qf_ct = new opensmt_logic("qf_ct");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static opensmt_logic swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + opensmt_logic.class + " with value " + swigValue);
  }

  private opensmt_logic(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private opensmt_logic(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private opensmt_logic(String swigName, opensmt_logic swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static opensmt_logic[] swigValues = { qf_uf, qf_cuf, qf_bv, qf_rdl, qf_idl, qf_lra, qf_lia, qf_ufrdl, qf_ufidl, qf_uflra, qf_uflia, qf_ax, qf_alra, qf_alia, qf_auflra, qf_auflia, qf_bool, qf_ct };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

