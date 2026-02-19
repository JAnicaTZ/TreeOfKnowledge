package propCommon;

import java.util.List;

public class PropAnalysisResult {
    public final String input; // canonical input string
    public final Formula ast; // parsed AST
    public final List<Character> vars; // used vars in stable order

    // Optional: intermediate forms (keep null if not computed)
    public final Formula nnfAst; // after pushing negations (NNF-ish)
    public final NormalFormFormula normalForm; // if you have a specific NF object

    // Normal forms (computed as needed)
    public final List<List<AtomicFormula>> dnf; // disjunctive normal form clauses
    public final List<List<AtomicFormula>> cnf; // optional if you compute

    public PropAnalysisResult(
            String input,
            Formula ast,
            List<Character> vars,
            Formula nnfAst,
            NormalFormFormula normalForm,
            List<List<AtomicFormula>> dnf,
            List<List<AtomicFormula>> cnf) {
        this.input = input;
        this.ast = ast;
        this.vars = vars;
        this.nnfAst = nnfAst;
        this.normalForm = normalForm;
        this.dnf = dnf;
        this.cnf = cnf;
    }

    // public Formula getKorijenStabla() {
    // return ast;
    // }
    // private static void expandAllNodes(JTree tree) {
    // // ponekad rowCount raste dok expandamo, zato while
    // int row = 0;
    // while (row < tree.getRowCount()) {
    // tree.expandRow(row);
    // row++;
    // }
    // }

    public List<Character> getKoristeneVarijable() {
        return vars;
    }

    public Formula getAst() {
        return ast;
    }

    public Formula getNnfAst() {
        return nnfAst;
    }

    public List<List<AtomicFormula>> getDnf() {
        return dnf;
    }
}
