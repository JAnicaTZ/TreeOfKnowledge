package propCommon;

public class PropParseException extends Exception {

    public PropParseException(String message) {
        super(message);
    }

    // --- SPECIFIČNI TIPOVI ---

    public static class FaktorExpected extends PropParseException {
        public FaktorExpected() {
            super("Factor expected");
            System.out.println("Factor expected at index " + FormulaTreeParser.i + ": "
                    + FormulaTreeParser.formula.substring(FormulaTreeParser.i));
        }
    }

    public static class Pocetak extends PropParseException {
        public Pocetak() {
            super("Invalid start of formula");
            System.out.println("Invalid start of formula at index " + FormulaTreeParser.i + ": "
                    + FormulaTreeParser.formula.substring(FormulaTreeParser.i));
        }
    }

    public static class ZatvoriZagradu extends PropParseException {
        public ZatvoriZagradu() {
            super("Missing closing parenthesis");
            System.out.println("Missing closing parenthesis at index " + FormulaTreeParser.i + ": "
                    + FormulaTreeParser.formula.substring(FormulaTreeParser.i));
        }
    }
}
