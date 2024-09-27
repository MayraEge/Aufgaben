import java.util.Scanner;
public class Schaltjahre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie ein Jahr ein: ");
        int jahr = scanner.nextInt;

        if (istSchaltjahr(jahr)) {
            System.out.println(jahr + " ist ein Schaltjahr. ");
        }else{
            System.out.println(jahr + " ist kein Schaltjahr. ");
        }
    }
    public static boolean istSchaltjahr(int jahr) {
        if (jahr % 4 == 0) {
            if (jahr % 100 == 0) {
                return jahr % 400 == 0;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
}
