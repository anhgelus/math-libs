package world.anhgelus.mathlibs.matrice.specials;

import world.anhgelus.mathlibs.matrice.Matrice;
import world.anhgelus.mathlibs.matrice.MatriceException;

public class IdentityMatrice extends Matrice {
    public IdentityMatrice(int order) {
        super(order, order);
        for (int i = 0; i < order; i++) {
            try {
                super.set(i, i, 1);
            } catch (MatriceException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
