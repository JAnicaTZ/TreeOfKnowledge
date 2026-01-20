package propMinimization;

/**
 * Base class for all propositional formulas (AST nodes).
 *
 * <p>This project represents formulas as a tree (Abstract Syntax Tree). Each concrete subclass
 * implements:
 *
 * <ul>
 *   <li>String rendering (pretty printing),
 *   <li>tree rendering for Swing {@code JTree} visualization,
 *   <li>structural transformations (e.g., pushing negations down),
 *   <li>optional conversion to normal forms (DNF/CNF) where applicable.
 * </ul>
 *
 * <p>The core idea: build a formula tree once, then reuse it for: visualization, normalization,
 * evaluation over valuations, and highlighting satisfying assignments.
 */
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION (CNF/DNF)

public abstract class Formula implements Cloneable {
  public abstract String toString();

  public abstract DefaultMutableTreeNode prikazFormule();

  public Object clone() {
    Object klon = null;
    try {
      klon = super.clone();
    } catch (CloneNotSupportedException e) {
      System.err.println("Kloniranje nije moguce!");
    }
    return klon;
  }

  public abstract Formula eliminiramNegacije(); // || deMorgan()!!
}
