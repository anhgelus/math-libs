package world.anhgelus.mathlibs.matrice.specials;

import world.anhgelus.mathlibs.matrice.Matrice;

public class LineMatrice extends Matrice {
    public LineMatrice(int lines) {
        super(1, lines);
    }

    public Matrice toGeneralMatrice() {
        return new Matrice(1, lines);
    }
}
