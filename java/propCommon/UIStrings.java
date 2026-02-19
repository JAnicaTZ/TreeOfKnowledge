package propCommon;

import java.util.List;
import java.util.Set;

public final class UIStrings {
        private UIStrings() {
        }

        public static final char P_CHAR = 'P';
        public static final char Q_CHAR = 'Q';
        public static final char R_CHAR = 'R';
        public static final char S_CHAR = 'S';

        // public static final char LIJEVA_ZAGRADA = '(';// '\u0028';
        // public static final char DESNA_ZAGRADA = ')';// '\u0029';
        public static final char LIJEVA_ZAGRADA = '\u0028';
        public static final char DESNA_ZAGRADA = '\u0029';
        /*
         * =========================
         * LOGIC SYMBOLS (UNICODE)
         * =========================
         */

        // Propositional operators
        public static final char NEGACIJA_CHAR = '\u00AC'; // ¬
        public static final char AND_CHAR = '\u2227'; // ∧
        public static final char OR_CHAR = '\u2228'; // ∨
        public static final char IMPLIES_CHAR = '\u21D2'; // →
        public static final char EQUIV_CHAR = '\u21D4'; // ↔
        // public static final char IMPLIES_CHAR = '\u2192'; // →
        // public static final char EQUIV_CHAR = '\u2194'; // ↔

        private static final Set<Character> BIN_OPS = Set.of(
                        UIStrings.AND_CHAR,
                        UIStrings.OR_CHAR,
                        UIStrings.IMPLIES_CHAR,
                        UIStrings.EQUIV_CHAR);

        private static final Set<Character> MINIMIZATION_CHARACTERS = Set.of(
                        UIStrings.P_CHAR,
                        UIStrings.Q_CHAR,
                        UIStrings.R_CHAR,
                        UIStrings.S_CHAR);

        public static final Set<Character> PROP_VARS = Set.of(
                        P_CHAR, Q_CHAR, R_CHAR, S_CHAR);
        public static final List<Character> PROP_VARS_ORDER = List.of(P_CHAR, Q_CHAR, R_CHAR, S_CHAR);

        public static final Set<Character> ALL_VARIABLE_CHARS = Set.of(
                        UIStrings.P_CHAR, UIStrings.Q_CHAR, UIStrings.R_CHAR, UIStrings.S_CHAR
        // kasnije lako proširiš
        );

        // Sva dopuštena “slova/znakovi” za unos propozicijske formule
        public static final Set<Character> PROP_INPUT_CHARS = Set.of(
                        NEGACIJA_CHAR,
                        LIJEVA_ZAGRADA,
                        P_CHAR, Q_CHAR, R_CHAR, S_CHAR);

        public static boolean isBinaryOp(char c) {
                return BIN_OPS.contains(c);
        }

        public static boolean isMinVar(char c) {
                return MINIMIZATION_CHARACTERS.contains(c);
        }

        public static boolean isBracket(char c) {
                return c == LIJEVA_ZAGRADA || c == DESNA_ZAGRADA;
        }

        // Quantifiers (First Order Logic)
        public static final char FORALL_CHAR = '\u2200'; // ∀
        public static final char EXISTS_CHAR = '\u2203'; // ∃

        // Parentheses & structure
        public static final char LPAREN_CHAR = '(';
        public static final char RPAREN_CHAR = ')';

        /*
         * =========================
         * UI / ACTION STRINGS
         * =========================
         */

        public static final class Action {
                private Action() {
                }

                public static final String CLEAR = "CLEAR";
                public static final String RUN = "RUN";
                public static final String EVALUATE = "EVALUATE";
                public static final String MINIMIZE = "MINIMIZE";
        }

        public static final class Btn {
                private Btn() {
                }

                public static final String CLEAR = "CLEAR";
                public static final String RUN = "RUN";
        }

        // ----- Window titles -----
        public static final class Title {
                private Title() {
                }

                public static final String TITLE_SIMPLE = "SIMPLE TREE – Propositional Logic Calculator (Beginner Mode)";
                public static final String TITLE_MINIMIZATION = "Propositional Logic Calculator (Advanced Mode) - MINIMAL NORMAL FORMS (DNs/CNFs)";
        }

        public static final class Html {
                private Html() {
                }

                public static final String FORMULA_INFO_HTML = """
                                <html><div style='text-align:center'>
                                Formula recursively decomposed<br>
                                into primitive connectives<br>
                                {¬ (NOT), ∧ (AND), ∨ (OR)}.<br>
                                </div></html>
                                """;

                public static final String NNF_INFO_HTML = """
                                <html><div style='text-align:center'>
                                Transformation via<br>
                                De Morgan's laws into<br>
                                Negation Normal Form (NNF)<br>
                                with negations pushed<br>
                                to the atomic level.
                                </div></html>
                                """;
        }

}
