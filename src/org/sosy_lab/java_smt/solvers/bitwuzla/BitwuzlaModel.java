package org.sosy_lab.java_smt.solvers.bitwuzla;


import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.sosy_lab.java_smt.basicimpl.AbstractModel;

public class BitwuzlaModel extends AbstractModel<Long, Long, Long> {
  private final long pBitwuzla;
  private final BitwuzlaTheoremProver prover;
  private final BitwuzlaFormulaCreator creator;
  private final ImmutableList<Long> assertedTerms;

  protected BitwuzlaModel(
      long pBitwuzla,
      BitwuzlaTheoremProver prover,
      BitwuzlaFormulaCreator creator,
      Collection<Long> assertedTerms) {
    super(prover, creator);
    this.pBitwuzla = pBitwuzla;
    this.prover = prover;
    this.creator = creator;
    this.assertedTerms = ImmutableList.copyOf(assertedTerms);
  }

  private void printModel() {
    System.out.println("(");
    for (int i = 0; i < assertedTerms.size(); ++i) {
      long sort = bitwuzlaJNI.bitwuzla_term_get_sort(assertedTerms.get(i));
      System.out.print(
          "  (define-fun " + bitwuzlaJNI.bitwuzla_term_get_symbol(assertedTerms.get(i)) + " (");
      if (bitwuzlaJNI.bitwuzla_sort_is_fun(sort)) {
        long value = bitwuzlaJNI.bitwuzla_get_value(pBitwuzla, assertedTerms.get(i));
        long[] size = new long[1];
        long children = bitwuzlaJNI.bitwuzla_term_get_children(value, size);
        assert size[0] == 2;
        int j = 0;
        while (bitwuzlaJNI.bitwuzla_term_get_kind(
                bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 1))
            == BitwuzlaKind.BITWUZLA_KIND_LAMBDA.swigValue()) {
          assert bitwuzlaJNI.bitwuzla_term_is_var(
              bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0));
          System.out.print(
              (j > 0 ? " " : "")
                  + bitwuzlaJNI.bitwuzla_term_to_string(
                      bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0))
                  + " "
                  + bitwuzlaJNI.bitwuzla_sort_to_string(
                      bitwuzlaJNI.bitwuzla_term_get_sort(
                          bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0)))
                  + " ");
          value = bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 1);
          children = bitwuzlaJNI.bitwuzla_term_get_children(value, size);
          j += 1;
        }
        assert bitwuzlaJNI.bitwuzla_term_is_var(bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0));
        System.out.print(
            (j > 0 ? " " : "")
                + bitwuzlaJNI.bitwuzla_term_to_string(
                    bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0))
                + " "
                + bitwuzlaJNI.bitwuzla_sort_to_string(
                    bitwuzlaJNI.bitwuzla_term_get_sort(
                        bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 0)))
                + ") ");
        System.out.print(
            bitwuzlaJNI.bitwuzla_sort_to_string(bitwuzlaJNI.bitwuzla_sort_fun_get_codomain(sort))
                + " ");
        System.out.println(
            bitwuzlaJNI.bitwuzla_term_to_string(
                bitwuzlaJNI.BitwuzlaTermArray_getitem(children, 1)));
      } else {
        System.out.println(
            ") "
                + bitwuzlaJNI.bitwuzla_sort_to_string(sort)
                + " "
                + bitwuzlaJNI.bitwuzla_term_to_string(
                    bitwuzlaJNI.bitwuzla_get_value(pBitwuzla, assertedTerms.get(i))));
      }
    }
    System.out.println(")");
  }

  /** Build a list of assignments that stays valid after closing the model. */
  @Override
  public ImmutableList<ValueAssignment> asList() {
    Preconditions.checkState(!isClosed());
    // Preconditions.checkState(!prover.isClosed(), "cannot use model after prover is closed");
    ImmutableSet.Builder<ValueAssignment> variablesBuilder = ImmutableSet.builder();

    for (long term : assertedTerms) {
      variablesBuilder.add(getSimpleAssignment(term));
    }

    return null;
  }

  private ValueAssignment getSimpleAssignment(long pTerm) {
    List<Object> argumentInterpretation = new ArrayList<>();
    long pValueTerm = bitwuzlaJNI.bitwuzla_get_value(pBitwuzla, pTerm);
    return new ValueAssignment(
        creator.encapsulateWithTypeOf(pTerm),
        creator.encapsulateWithTypeOf(pValueTerm),
        creator.encapsulateBoolean(
            bitwuzlaJNI.bitwuzla_mk_term2(
                BitwuzlaKind.BITWUZLA_KIND_EQUAL.swigValue(), pTerm, pValueTerm)),
        bitwuzlaJNI.bitwuzla_term_get_symbol(pTerm),
        creator.convertValue(pTerm, pValueTerm),
        argumentInterpretation);
  }

  /**
   * Simplify the given formula and replace all symbols with their model values. If a symbol is not
   * set in the model and evaluation aborts, return <code>null</code>.
   *
   * @param formula
   */
  @Override
  protected @Nullable Long evalImpl(Long formula) {
    return null;
  }
}
