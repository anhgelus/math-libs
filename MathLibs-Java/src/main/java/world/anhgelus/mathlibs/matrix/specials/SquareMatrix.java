package world.anhgelus.mathlibs.matrix.specials;

import world.anhgelus.mathlibs.matrix.Matrix;

public class SquareMatrix extends Matrix {
    public final int order;
    public SquareMatrix(int order) {
        super(order, order);
        this.order = order;
    }

    public IdentityMatrix getIdentityMatrix() {
        return new IdentityMatrix(lines);
    }

    public Matrix toGeneralMatrix() {
        return new Matrix(order, order);
    }
}
