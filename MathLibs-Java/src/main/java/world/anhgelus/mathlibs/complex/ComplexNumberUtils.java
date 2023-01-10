package world.anhgelus.mathlibs.complex;

public class ComplexNumberUtils {
    /**
     * Addition of Complex Number
     * @param a Complex Number to add
     * @param b Complex Number to add
     * @return Result of the addition
     */
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real + b.real, a.imaginary.number + b.imaginary.number);
    }

    /**
     * Subtraction of Complex Number
     * @param a Complex Number to subtract
     * @param b Complex Number to subtract
     * @return Result of the subtraction
     */
    public static ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real - b.real, a.imaginary.number - b.imaginary.number);
    }

    /**
     * Multiplication of Complex Number
     * @param a Complex Number to multiply
     * @param b Complex Number to multiply
     * @return Result of the multiplication
     */
    public static ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
        /*
        * (a+ci)(b+di)
        * <=> a(b+di) + ci(b+di)
        * <=> ab + adi + bci - cd
        * <=> ab - cd + (ad + bc)i
        */
        return new ComplexNumber(a.real * b.real - a.imaginary.number * b.imaginary.number,
                        a.real * b.imaginary.number + a.imaginary.number * b.real);
    }

    /**
     * Division of Complex Number
     * @param a Complex Number to divide
     * @param b Complex Number to divide
     * @return Result of the division
     */
    public static ComplexNumber div(ComplexNumber a, ComplexNumber b) {
        /*
        * (a+ci)/(b+di)
        * <=> (a+ci)(b-di)/(b+di)(b-di)
        * <=> ab-adi+cib+cd/(b^2+d^2)
        */
        final double denominator = b.real * b.real + b.imaginary.number * b.imaginary.number;
        final ComplexNumber intermediate = mul(a, new ComplexNumber(b.real, -b.imaginary.number));
        return new ComplexNumber(intermediate.real / denominator,
                        intermediate.imaginary.number / denominator);
    }
}
