package world.anhgelus.mathlibs.fraction;

public class FractionUtils {
    /**
     * Add fraction
     * @param a The first fraction
     * @param b The second fraction
     * @return The result of the addition
     */
    public static Fraction add(Fraction a, Fraction b) {
        final int newDenominator = a.denominator * b.denominator;
        final int newNumerator = a.numerator * b.denominator + b.numerator * a.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    /**
     * Sub fraction
     * @param a The first fraction
     * @param b The second fraction
     * @return The result of the subtraction
     */
    public static Fraction sub(Fraction a, Fraction b) {
        final int newDenominator = a.denominator * b.denominator;
        final int newNumerator = a.numerator * b.denominator - b.numerator * a.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    /**
     * Multiply fraction
     * @param a The first fraction
     * @param b The second fraction
     * @return The result of the multiplication
     */
    public static Fraction mul(Fraction a, Fraction b) {
        final int newDenominator = a.denominator * b.denominator;
        final int newNumerator = a.numerator * b.numerator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    /**
     * Divide fraction
     * @param a The first fraction
     * @param b The second fraction
     * @return The result of the division
     */
    public static Fraction div(Fraction a, Fraction b) {
        return mul(a, b.invert());
    }
}
