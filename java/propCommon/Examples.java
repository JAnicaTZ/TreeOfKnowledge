package propCommon;

/**
 * Library of example formulas for the minimization module.
 *
 * <p>
 * Provides predefined propositional formulas used for demonstration, testing,
 * and regression of
 * CNF/DNF conversion and minimization algorithms.
 */

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — Propositional MINIMIZATION
// (CNF/DNF)

public class Examples {

        public static String primjer0() { // tautologija
                return " "
                                + UIStrings.NEGACIJA_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "Q)"
                                + UIStrings.IMPLIES_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.OR_CHAR
                                + "Q)";
        }

        public static String primjer1() { // 21 - moj Primjer 6.2. str.27
                return " (P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "Q)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + "Q)"
                                + UIStrings.OR_CHAR
                                + "(Q"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + "R)";
        }

        public static String primjer2() { // 25 - moj Primjer 8.1. str.33
                return " (P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)";
        }

        public static String primjer3() { // 33&4 - moj Primjer 8.2. odnosno 7.3. str.33 odn. 30
                return " (P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)";
        }

        public static String primjer4() { // 41 - moj Primjer 8.3. str.34
                return " (P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)";
        }

        public static String primjer5() { // 45 - moj Primjer 8.4. str.35
                return " (P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "Q)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + "Q)"
                                + UIStrings.OR_CHAR
                                + "(Q"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(Q"
                                + UIStrings.AND_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(R"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(R"
                                + UIStrings.AND_CHAR
                                + "S)";
        }

        public static String primjer6() { // 51 - moj Primjer 8.5. str.36
                return " (P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + "R)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "R)";
        }

        public static String primjer7() { // 61 - moj Primjer 8.6. str.37
                return " (P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + "(P"
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)"
                                + UIStrings.OR_CHAR
                                + '('
                                + UIStrings.NEGACIJA_CHAR
                                + 'P'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'Q'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + 'R'
                                + UIStrings.AND_CHAR
                                + UIStrings.NEGACIJA_CHAR
                                + "S)";
        }
}
