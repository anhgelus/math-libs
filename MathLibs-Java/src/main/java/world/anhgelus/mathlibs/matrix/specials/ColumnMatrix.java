package world.anhgelus.mathlibs.matrix.specials;

import world.anhgelus.mathlibs.matrix.Matrix;

public class ColumnMatrix extends Matrix {
    public ColumnMatrix(int columns) {
        super(columns, 1);
    }

    public Matrix toGeneralMatrix() {
        return new Matrix(columns, 1);
    }

    public double mul(ColumnMatrix a) {
        var result = 0.0;
        for (int i = 0; i < columns; i++) {
            result += super.matrices[i] * a.matrices[i];
        }
        return result;
    }
}
