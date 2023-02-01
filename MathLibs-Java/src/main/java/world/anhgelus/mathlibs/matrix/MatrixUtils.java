package world.anhgelus.mathlibs.matrix;

public class MatrixUtils {
    /**
     * Addition two matrices
     * @param a matrix to add
     * @param b matrix to add
     * @return the result of the addition
     * @throws MatrixException if the matrices are not the same size
     */
    public static Matrix add(Matrix a, Matrix b) throws MatrixException {
        if (a.lines != b.lines || a.columns != b.columns) {
            throw new MatrixException("Matrices must have the same dimensions");
        }
        var result = new Matrix(a.columns, a.lines);
        for (int i = 0; i < (a.lines * a.columns); i++) {
            final int columnsA = i % a.columns, columnsB = i % b.columns; // Get the column of the current index
            final int linesA = (i - columnsA) / a.columns, linesB = (i - columnsB) / a.columns; // Get the line of the current index
            result.set(columnsA, linesA, a.get(columnsA, linesA) + b.get(columnsB, linesB));
        }
        return result;
    }

    /**
     * Subtract two matrices
     * @param a matrix to subtract
     * @param b matrix to subtract
     * @return the result of the subtraction
     * @throws MatrixException if the matrices are not the same size
     */
    public static Matrix sub(Matrix a, Matrix b) throws MatrixException {
        if (a.lines != b.lines || a.columns != b.columns) {
            throw new MatrixException("Matrices must have the same dimensions");
        }
        var result = new Matrix(a.columns, a.lines);
        for (int i = 0; i < (a.lines * a.columns); i++) {
            final int columnsA = i % a.columns, columnsB = i % b.columns; // Get the column of the current index
            final int linesA = (i - columnsA) / a.columns, linesB = (i - columnsB) / a.columns; // Get the line of the current index
            result.set(columnsA, linesA, a.get(columnsA, linesA) - b.get(columnsB, linesB));
        }
        return result;
    }

    /**
     * Multiply two matrices
     * @param a matrix to multiply
     * @param b matrix to multiply
     * @return the result of the multiplication
     * @throws MatrixException if the matrices can't be multiplied
     */
    public static Matrix mul(Matrix a, Matrix b) throws MatrixException {
        if (a.columns != b.lines) {
            throw new MatrixException("Cannot multiply this two matrices");
        }
        var result = new Matrix(b.columns, a.lines);
        for (int i = 0; i < (a.lines * b.columns); i++) {
            final int columnsA = i % a.columns, columnsB = i % b.columns; // Get the column of the current index
            final int linesA = (i - columnsA) / a.columns, linesB = (i - columnsB) / b.columns; // Get the line of the current index
            double value = 0;
            for (int j = 0; j < a.columns; j++) {
                value += a.get(j, linesA) * b.get(columnsB, j);
            }
            result.set(columnsB, linesA, value);
        }
        return result;
    }
}
