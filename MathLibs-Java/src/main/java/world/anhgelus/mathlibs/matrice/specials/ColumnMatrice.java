package world.anhgelus.mathlibs.matrice.specials;

import world.anhgelus.mathlibs.matrice.Matrice;

public class ColumnMatrice extends Matrice {
    public ColumnMatrice(int columns) {
        super(columns, 1);
    }

    public Matrice toGeneralMatrice() {
        return new Matrice(columns, 1);
    }

    public double mul(ColumnMatrice a) {
        var result = 0.0;
        for (int i = 0; i < columns; i++) {
            result += super.matrices[i] * a.matrices[i];
        }
        return result;
    }
}
