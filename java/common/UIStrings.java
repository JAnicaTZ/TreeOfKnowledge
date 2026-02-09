package common;

import javax.swing.JLabel;

public final class UIStrings {

        private UIStrings() {
        }

        // Action commands
        public static final String CLEAR = "CLEAR";
        public static final String EVALUATE = "EVALUATE";
        public static final String MINIMIZE = "MINIMIZE";

        // Titles
        public static final String TITLE_SIMPLE = "SIMPLE TREE – Propositional Logic Calculator (Beginner Mode)";
        public static final String TITLE_MINIMIZATION = "Propositional Logic Calculator (Advanced Mode) - MINIMAL NORMAL FORMS (DNs/CNFs)";

        // Tree panel descriptions
        public static final JLabel FORMULA_INFO_HTML = new JLabel("""
                        <html>
                        <div style='text-align:center'>
                        Formula recursively decomposed<br>into primitive connectives<br>{¬ (NOT), ∧ (AND), ∨ (OR)}.<br>
                        </div>
                        </html>
                        """);

        public static final JLabel NNF_INFO_HTML = new JLabel("""
                        <html>
                        <div style='text-align:center'>
                        Transformation via<br> De Morgan's laws into<br>Negation Normal Form (NNF)<br>
                        with negations pushed<br>to the atomic level.
                        </div>
                        </html>
                        """);

        // Buttons
        public static final String BTN_CLEAR = "CLEAR";
        public static final String BTN_RUN = "RUN";
}
