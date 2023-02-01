package world.anhgelus.mathlibs.matrix.specials;

import world.anhgelus.mathlibs.matrix.Matrix;

public class LineMatrix extends Matrix {
    public LineMatrix(int lines) {
        super(1, lines);
    }

    public Matrix toGeneralMatrix() {
        return new Matrix(1, lines);
    }
}
