package firstorder;

/**
 * Base class for formulas participating in the engine's normal-form workflow.
 *
 * <p>Classes extending {@code FormulaUNF} support:
 * <ul>
 *   <li>Extraction of a conjunction-oriented list representation via {@link #konjuktivnaForma()},</li>
 *   <li>A domain-bounded semantic test via {@link #glavniTest(int)}.</li>
 * </ul>
 *
 * <p>The parameter {@code brojElemenataNosaca} represents the size of the finite carrier/domain
 * used by the calculator (e.g., 2 elements, 4 elements). Concrete nodes decide how to expand
 * quantifiers and combine subtree results under this domain size.
 */

import java.util.List;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public abstract class FormulaUNF extends Formula{
  public abstract List konjuktivnaForma();
  public abstract Formula glavniTest(int brojElemenataNosaca); // brojKonstanti || brojElemenataDomene
}
