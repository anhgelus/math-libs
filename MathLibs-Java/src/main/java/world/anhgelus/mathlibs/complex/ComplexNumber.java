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
}
