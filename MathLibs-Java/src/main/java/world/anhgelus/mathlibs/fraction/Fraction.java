package world.anhgelus.mathlibs.fraction;

import world.anhgelus.mathlibs.util.PGCD;

public class Fraction {

    private int pgcdResult = -1;

    public final int numerator;
    public final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Reduce the fraction
     * @return reduced fraction
     */
    public Fraction reduce() {
        final int pgcd = calculatePgcd();
        return new Fraction(numerator / pgcd, denominator / pgcd);
    }

    /**
     * Invert the fraction
     * @return The inverted fraction
     */
    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    /**
     * Calculate the pgcd of the fraction
     * @return The pgcd of the fraction
     */
    protected int calculatePgcd() {
        if (pgcdResult == -1) {
            return pgcdResult = PGCD.pgcd(numerator, denominator);
        }
        return pgcdResult;
    }

    /* CHECKS */

    /**
     * Check if fraction is an integer
     * @return true if fraction is an integer; else false
     */
    public boolean isInteger() {
        return denominator == 1;
    }

    /* CONVERSIONS */

    /**
     * Convert fraction into double
     * @return double
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Convert fraction into integer
     * @return Converted integer
     * @throws FractionException If fraction is not an integer
     */
    public int toInteger() throws FractionException {
        if (!isInteger()) {
            throw new FractionException("Fraction is not an integer");
        }
        return numerator;
    }

    /* OPERATIONS */

    /**
     * Add fraction
     * @param other The fraction to add
     * @return The result of the addition
     */
    public Fraction add(Fraction other) {
        return StaticFraction.add(this, other);
    }

    /**
     * Sub fraction
     * @param other The fraction to sub
     * @return The result of the subtraction
     */
    public Fraction sub(Fraction other) {
        return StaticFraction.sub(this, other);
    }

    /**
     * Multiply fraction
     * @param other The fraction to multiply
     * @return The result of the multiplication
     */
    public Fraction mul(Fraction other) {
        return StaticFraction.mul(this, other);
    }

    /**
     * Divide fraction
     * @param other The fraction to divide
     * @return The result of the division
     */
    public Fraction div(Fraction other) {
        return StaticFraction.div(this, other);
    }
}
