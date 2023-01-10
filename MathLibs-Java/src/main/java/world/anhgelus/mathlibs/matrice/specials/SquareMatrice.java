package world.anhgelus.mathlibs.matrice.specials;

import world.anhgelus.mathlibs.matrice.Matrice;

public class SquareMatrice extends Matrice {
    public final int order;
    public SquareMatrice(int order) {
        super(order, order);
        this.order = order;
    }

    public IdentityMatrice getIdentityMatrice() {
        return new IdentityMatrice(lines);
    }

    public Matrice toGeneralMatrice() {
        return new Matrice(order, order);
    }
}
