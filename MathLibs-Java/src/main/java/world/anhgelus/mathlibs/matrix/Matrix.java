package world.anhgelus.mathlibs.matrix;

import world.anhgelus.mathlibs.matrix.specials.ColumnMatrix;
import world.anhgelus.mathlibs.matrix.specials.SquareMatrix;

public class Matrix {
    public final int lines;
    public final int columns;
    protected final double[] matrices;

    public Matrix(int columns, int lines) {
        this.lines = lines;
        this.columns = columns;
        matrices = new double[lines * columns];
    }

    public Matrix set(int column, int line, double value) throws MatrixException {
        var index = isIndexValid(column, line);
        matrices[index] = value;
        return this;
    }

    public double get(int column, int line) throws MatrixException {
        var index = isIndexValid(column, line);
        return matrices[index];
    }

    /* CHECKERS */

    public boolean isSquare() {
        return lines == columns;
    }

    public boolean isColumn() {
        return lines == 1;
    }

    public boolean isLine() {
        return columns == 1;
    }

    protected int isIndexValid(int column, int line) throws MatrixException {
        var index = line * columns + column;
        if (index >= matrices.length) {
            throw new MatrixException("Index out of bounds");
        }
        return index;
    }

    /* TRANSFORMATIONS */

    public SquareMatrix toSquareMatrice() throws MatrixException {
        if (isSquare()) {
            return new SquareMatrix(lines);
        }
        throw new MatrixException("Matrice is not square");
    }

    public ColumnMatrix toColumnMatrice() throws MatrixException {
        if (isColumn()) {
            return new ColumnMatrix(columns);
        }
        throw new MatrixException("Matrice is not a column");
    }

    public Matrix toLineMatrice() throws MatrixException {
        if (isLine()) {
            return new Matrix(1, lines);
        }
        throw new MatrixException("Matrice is not a line");
    }

    /* OPERATORS */

    /**
     * Add a matrice
     * @param a matrice to add
     * @return the new matrice
     * @throws MatrixException if the matrices are not the same size
     */
    public Matrix add(Matrix a) throws MatrixException {
        return MatrixUtils.add(this, a);
    }

    /**
     * Subtract a matrice
     * @param a matrice to subtract
     * @return the new matrice
     * @throws MatrixException if the matrices are not the same size
     */
    public Matrix sub(Matrix a) throws MatrixException {
        return MatrixUtils.sub(this, a);
    }

    /**
     * Multiply a matrice
     * @param a matrice to multiply
     * @return the new matrice
     * @throws MatrixException if the matrices can't be multiplied
     */
    public Matrix mul(Matrix a) throws MatrixException {
        return MatrixUtils.mul(this, a);
    }
}
