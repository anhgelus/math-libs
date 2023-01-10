package world.anhgelus.mathlibs.complex;

public class ComplexNumber {
    public final double real;
    public final ImaginaryNumber imaginary;

    /**
     * ComplexNumber(5,-2.5) for 5-2.5i for example (with i^2 = -1)
     * @param real real part of the number
     * @param imaginary imaginary part of the number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = new ImaginaryNumber(imaginary);
    }

    /**
     * ComplexNumber(5,-2.5) for 5-2.5i for example (with i^2 = -1)
     * @param real real part of the number
     * @param imaginary imaginary part of the number
     */
    public ComplexNumber(double real, ImaginaryNumber imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /* CHECKERS */
    public boolean isReal() {
        return !imaginary.isNull();
    }

    public boolean isImaginary() {
        return real == 0;
    }

    /* CONVERSIONS */
    public double toReal() throws ComplexNumberException {
        if (!isReal()) {
            throw new ComplexNumberException("This number is not real");
        }
        return real;
    }

    /* OPERATIONS */

    /**
     * Add a complex number
     * @param a complex number to add
     * @return the result of the addition
     */
    public ComplexNumber add(ComplexNumber a) {
        return ComplexNumberUtils.add(this, a);
    }

    /**
     * Subtract a complex number
     * @param a complex number to subtract
     * @return the result of the subtraction
     */
    public ComplexNumber sub(ComplexNumber a) {
        return ComplexNumberUtils.sub(this, a);
    }

    /**
     * Multiply a complex number
     * @param a complex number to multiply
     * @return the result of the multiplication
     */
    public ComplexNumber mul(ComplexNumber a) {
        return ComplexNumberUtils.mul(this, a);
    }

    /**
     * Divide a complex number
     * @param a complex number to divide
     * @return the result of the division
     */
    public ComplexNumber div(ComplexNumber a) {
        return ComplexNumberUtils.div(this, a);
    }
}
