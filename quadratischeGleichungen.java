import java.util.Scanner;
public class quadratischeGleichungen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie den Koeffizienten (a) ein: ");
        double a = scanner.nextDouble();

        System.out.print("Geben Sie den Koeffizienten (b) ein: ");
        double b = scanner.nextDouble();

        System.out.print("Geben Sie den Koeffizienten (c): ");
        double c = scanner.nextDouble();

        double diskrinminante = b * b - 4 * a * c;

        if (diskrinminante > 0) {
            System.out.println("Die Gleichung hat zwei Lösungen.");
        }else if (diskrinminante == 0) {
            System.out.println("Die Gleichung hat eine Lösung. ");
        } else {
            System.out.println("Die Gleichung hat keine reellen Lösungen.");
        }
    }

}
