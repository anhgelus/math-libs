package world.anhgelus.mathlibs.matrice;

public class MatriceUtils {
    /**
     * Addition two matrices
     * @param a matrice to add
     * @param b matrice to add
     * @return the result of the addition
     * @throws MatriceException if the matrices are not the same size
     */
    public static Matrice add(Matrice a, Matrice b) throws MatriceException {
        if (a.lines != b.lines || a.columns != b.columns) {
            throw new MatriceException("Matrices must have the same dimensions");
        }
        var result = new Matrice(a.columns, a.lines);
        for (int i = 0; i < (a.lines * a.columns); i++) {
            final int columnsA = i % a.columns, columnsB = i % b.columns; // Get the column of the current index
            final int linesA = (i - columnsA) / a.columns, linesB = (i - columnsB) / a.columns; // Get the line of the current index
            result.set(columnsA, linesA, a.get(columnsA, linesA) + b.get(columnsB, linesB));
        }
        return result;
    }

    /**
     * Subtract two matrices
     * @param a matrice to subtract
     * @param b matrice to subtract
     * @return the result of the subtraction
     * @throws MatriceException if the matrices are not the same size
     */
    public static Matrice sub(Matrice a, Matrice b) throws MatriceException {
        if (a.lines != b.lines || a.columns != b.columns) {
            throw new MatriceException("Matrices must have the same dimensions");
        }
        var result = new Matrice(a.columns, a.lines);
        for (int i = 0; i < (a.lines * a.columns); i++) {
            final int columnsA = i % a.columns, columnsB = i % b.columns; // Get the column of the current index
            final int linesA = (i - columnsA) / a.columns, linesB = (i - columnsB) / a.columns; // Get the line of the current index
            result.set(columnsA, linesA, a.get(columnsA, linesA) - b.get(columnsB, linesB));
        }
        return result;
    }

    /**
     * Multiply two matrices
     * @param a matrice to multiply
     * @param b matrice to multiply
     * @return the result of the multiplication
     * @throws MatriceException if the matrices can't be multiplied
     */
    public static Matrice mul(Matrice a, Matrice b) throws MatriceException {
        if (a.columns != b.lines) {
            throw new MatriceException("Cannot multiply this two matrices");
        }
        var result = new Matrice(b.columns, a.lines);
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
