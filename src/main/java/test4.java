import java.util.Scanner;
public class test4 {
    public static void main(String[] args) {
        String[] original = {"Apfel"};
        String[] veraendert = wortUmschreiben(original);

        System.out.println("Original: " + original);
        System.out.println("Veraendert: " + veraendert);
    }
    public static String[] wortUmschreiben(String[] wort){
        wort[0]= wort[0] + "Banane";
        return wort;
    }
}
