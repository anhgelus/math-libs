package world.anhgelus.mathlibs.matrix.specials;

import world.anhgelus.mathlibs.matrix.MatrixException;

public class IdentityMatrix extends SquareMatrix {
    public IdentityMatrix(int order) {
        super(order);
        for (int i = 0; i < order; i++) {
            try {
                super.set(i, i, 1);
            } catch (MatrixException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
