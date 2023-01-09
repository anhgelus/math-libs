package world.anhgelus.mathlibs.util;

public class PGCD {
    public static int pgcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return pgcd(b, a % b);
    }
}
