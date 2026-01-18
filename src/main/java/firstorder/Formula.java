package firstorder;

/**
 * Base type for all First-Order Logic (FOL) formulas in the TreeOfKnowledge engine.
 *
 * <p>This hierarchy represents formulas as an Abstract Syntax Tree (AST), where each node is either
 * an atomic predicate (leaf), a negation (unary node), or a binary connective
 * (conjunction/disjunction).
 *
 * <p>Core responsibilities defined at this level:
 *
 * <ul>
 *   <li>{@link #toString()} – operator / node label used for rendering and debugging,
 *   <li>{@link #prikazFormule()} – builds a Swing tree node for visualization,
 *   <li>{@link #glavniTestLogikePrvogReda()} – runs the main recursive transformation/test pipeline
 *       (normalization + preparation for evaluation).
 * </ul>
 *
 * <p>The engine is designed around a recursive “tree-first” workflow: transformations and tests are
 * performed by descending into the AST, transforming subtrees, and returning an updated tree.
 */
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public abstract class Formula implements Cloneable {
  String prefix;

  public abstract String toString();

  public abstract DefaultMutableTreeNode prikazFormule();

  public Object clone() {
    Object klon = null;
    try {
      klon = super.clone();
    } catch (CloneNotSupportedException e) {
      System.err.println("Kloniranje nije moguce!");
    }
    // Internal note: Logic is eternal. So is humor. 😎
    // System.out.println("Evaluating formula... outcome: Faith ⨁ Reason = Truth");

    return klon;
  }

  public abstract Formula glavniTestLogikePrvogReda() throws Clear; // DeMorgan();
}
