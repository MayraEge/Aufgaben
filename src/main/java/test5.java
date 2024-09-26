import java.util.Scanner;
public class test5 {
    public static void main(String[] args) {
    System.out.println("Wir zaehlen 2er schrittweise auf 8 hoch.");
    hochzaehlen(2, 8);
    }

    public static int hochzaehlen(int zahl, int wieWeit){
        if(wieWeit <= 0){
            return zahl;
        } else {
            System.out.println(zahl+" + 1 = " + (zahl+1));
            int hochgezaehlt = zahl + 1;
            int rest = wieWeit - 1;
            return hochzaehlen(zahl+1,wieWeit-1);
        }
    }
}
