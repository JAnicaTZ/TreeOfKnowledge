package firstorder;

/**
 * Atomic predicate node (leaf) in the FOL formula tree.
 *
 * <p>Represents an atomic formula with:
 *
 * <ul>
 *   <li>a polarity (positive / negated literal),
 *   <li>a predicate “body” stored in a compact string form (e.g. Pxy),
 *   <li>a quantifier prefix encoded as a compact string (e.g. ∀x∃y...).
 * </ul>
 *
 * <p>This class performs the engine's crucial “finite-domain expansion” step in {@link
 * #glavniTest(int)}: depending on the leading quantifier in the prefix, it expands the formula into
 * a conjunction (for ∀) or a disjunction (for ∃) over concrete domain elements (e.g., a,b,c,d),
 * recursively continuing until the prefix is exhausted.
 *
 * <p>The helper {@link #reducirajPrefix(String, String)} reduces/simplifies the prefix with respect
 * to the variables actually occurring in the atomic predicate, preventing irrelevant quantifiers
 * from bloating the expansion.
 */
import java.util.*; // List, ArrayList, Map, HashMap
import javax.swing.tree.DefaultMutableTreeNode;

// © JAnica Tesla Zrinski — TreeOfKnowledge.eu — FIRST-ORDER Logic (FOL) engine

public class AtomarnaFormula extends FormulaUNF {
  boolean istinitost;
  String propozicionalnaVarijabla;

  public String toString() {
    String istinitostString;
    if (istinitost == false)
      istinitostString = "  " + (new Character(Calc.NEGACIJA_CHAR)).toString();
    else istinitostString = "  " + "  ";
    String prefixString = "";
    switch (prefix.length()) {
      case 0:
        prefixString = "";
        break;
      case 2:
        prefixString = "    " + prefix;
        break;
      case 4:
        prefixString = prefix;
        break;
    }
    return prefixString + istinitostString + propozicionalnaVarijabla;
  }

  public DefaultMutableTreeNode prikazFormule() {
    return new DefaultMutableTreeNode(this);
  }

  public AtomarnaFormula(String prefix, String propozicionalnaVarijabla) {
    this.prefix = prefix;
    this.propozicionalnaVarijabla = propozicionalnaVarijabla;
    istinitost = true;
  }

  public AtomarnaFormula(String prefix, boolean istinitost, String propozicionalnaVarijabla) {
    this.prefix = prefix;
    this.istinitost = istinitost;
    this.propozicionalnaVarijabla = propozicionalnaVarijabla;
  }

  public Formula glavniTestLogikePrvogReda() throws Clear {
    if (prefix.length() == 0) throw new Clear();
    for (int i = 1; i < propozicionalnaVarijabla.length(); i++) {
      if ((prefix.indexOf(propozicionalnaVarijabla.substring(i, i + 1))) < 0) throw new Clear();
    }
    prefix = reducirajPrefix(prefix, propozicionalnaVarijabla);
    return this;
  }

  public static String reducirajPrefix(String prefix, String propozicionalnaVarijabla) {
    String praviPrefix = new String();
    for (int i = 0; i < prefix.length(); i = i + 2) {
      if ((praviPrefix.indexOf(prefix.substring(i, i + 2))) < 0)
        praviPrefix += prefix.substring(i, i + 2);
    }
    prefix = praviPrefix;
    String reduciraniPrefix = new String();
    for (int i = 0; i < prefix.length(); i = i + 2) {
      if (propozicionalnaVarijabla.indexOf(prefix.charAt(i + 1)) >= 0)
        reduciraniPrefix += prefix.substring(i, i + 2);
    }
    return reduciraniPrefix;
  }

  public List konjuktivnaForma() {
    List konjuktivnaForma = new ArrayList();
    Map mapa = new TreeMap();
    mapa.put(propozicionalnaVarijabla, new Boolean(istinitost));
    konjuktivnaForma.add(mapa);
    return konjuktivnaForma;
  }

  public Formula glavniTest(int brojElemenataNosaca) {
    if (!prefix.equals("")) {
      switch (brojElemenataNosaca) {
        case 1:
          for (int i = 1; i < propozicionalnaVarijabla.length(); i++) {
            propozicionalnaVarijabla =
                propozicionalnaVarijabla.replace(propozicionalnaVarijabla.charAt(i), 'a');
          }
          break;
        case 2:
          if (prefix.charAt(0) == Calc.ZASVAKI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.ZASVAKI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.ZASVAKI_CHAR) + 2);
            FormulaUNF konjukcija =
                new Konjukcija(
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b')));
            return konjukcija.glavniTest(brojElemenataNosaca);
          }
          if (prefix.charAt(0) == Calc.POSTOJI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.POSTOJI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.POSTOJI_CHAR) + 2);
            FormulaUNF disjunkcija =
                new Disjunkcija(
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b')));
            return disjunkcija.glavniTest(brojElemenataNosaca);
          }
          break;
        case 3:
          if (prefix.charAt(0) == Calc.ZASVAKI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.ZASVAKI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.ZASVAKI_CHAR) + 2);
            FormulaUNF konjukcija =
                new Konjukcija(
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                    new Konjukcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'c'))));
            return konjukcija.glavniTest(brojElemenataNosaca);
          }
          if (prefix.charAt(0) == Calc.POSTOJI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.POSTOJI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.POSTOJI_CHAR) + 2);
            FormulaUNF disjunkcija =
                new Disjunkcija(
                    new AtomarnaFormula(
                        prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                    new Disjunkcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'c'))));
            return disjunkcija.glavniTest(brojElemenataNosaca);
          }
          break;
        case 4:
          if (prefix.charAt(0) == Calc.ZASVAKI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.ZASVAKI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.ZASVAKI_CHAR) + 2);
            FormulaUNF konjukcija =
                new Konjukcija(
                    new Konjukcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b'))),
                    new Konjukcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'c')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'd'))));
            return konjukcija.glavniTest(brojElemenataNosaca);
          }
          if (prefix.charAt(0) == Calc.POSTOJI_CHAR) {
            char varijabla = prefix.charAt(prefix.indexOf(Calc.POSTOJI_CHAR) + 1);
            prefix = prefix.substring(prefix.indexOf(Calc.POSTOJI_CHAR) + 2);
            FormulaUNF disjunkcija =
                new Disjunkcija(
                    new Disjunkcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'a')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'b'))),
                    new Disjunkcija(
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'c')),
                        new AtomarnaFormula(
                            prefix, istinitost, propozicionalnaVarijabla.replace(varijabla, 'd'))));
            return disjunkcija.glavniTest(brojElemenataNosaca);
          }
          break;
      }
    }
    return this;
  }
}
