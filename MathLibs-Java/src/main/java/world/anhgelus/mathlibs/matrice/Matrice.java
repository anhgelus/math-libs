package world.anhgelus.mathlibs.matrice;

import world.anhgelus.mathlibs.matrice.specials.ColumnMatrice;
import world.anhgelus.mathlibs.matrice.specials.SquareMatrice;

public class Matrice {
    public final int lines;
    public final int columns;
    protected final double[] matrices;

    public Matrice(int columns, int lines) {
        this.lines = lines;
        this.columns = columns;
        matrices = new double[lines * columns];
    }

    public Matrice set(int column, int line, double value) throws MatriceException {
        var index = isIndexValid(column, line);
        matrices[index] = value;
        return this;
    }

    public double get(int column, int line) throws MatriceException {
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

    protected int isIndexValid(int column, int line) throws MatriceException {
        var index = line * columns + column;
        if (index >= matrices.length) {
            throw new MatriceException("Index out of bounds");
        }
        return index;
    }

    /* TRANSFORMATIONS */

    public SquareMatrice toSquareMatrice() throws MatriceException {
        if (isSquare()) {
            return new SquareMatrice(lines);
        }
        throw new MatriceException("Matrice is not square");
    }

    public ColumnMatrice toColumnMatrice() throws MatriceException {
        if (isColumn()) {
            return new ColumnMatrice(columns);
        }
        throw new MatriceException("Matrice is not a column");
    }

    public Matrice toLineMatrice() throws MatriceException {
        if (isLine()) {
            return new Matrice(1, lines);
        }
        throw new MatriceException("Matrice is not a line");
    }

    /* OPERATORS */

    /**
     * Add a matrice
     * @param a matrice to add
     * @return the new matrice
     * @throws MatriceException if the matrices are not the same size
     */
    public Matrice add(Matrice a) throws MatriceException {
        return MatriceUtils.add(this, a);
    }

    /**
     * Subtract a matrice
     * @param a matrice to subtract
     * @return the new matrice
     * @throws MatriceException if the matrices are not the same size
     */
    public Matrice sub(Matrice a) throws MatriceException {
        return MatriceUtils.sub(this, a);
    }

    /**
     * Multiply a matrice
     * @param a matrice to multiply
     * @return the new matrice
     * @throws MatriceException if the matrices can't be multiplied
     */
    public Matrice mul(Matrice a) throws MatriceException {
        return MatriceUtils.mul(this, a);
    }
}
