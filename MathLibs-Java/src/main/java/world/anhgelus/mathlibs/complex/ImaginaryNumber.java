package world.anhgelus.mathlibs.complex;

public class ImaginaryNumber {
    public final double number;

    public ImaginaryNumber(double imaginary) {
        this.number = imaginary;
    }

    public boolean isNull() {
        return number == 0;
    }

    public String toString() {
        return number + "i";
    }
}
