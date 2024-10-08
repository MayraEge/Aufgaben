import java.util.Scanner;

public class TuermeVonHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie viele Scheiben? ");
        int n = scanner.nextInt();
        hanoi(n, 'A', 'C', 'B');
    }

    // Rekursive Methode zur Lösung des Türme von Hanoi-Problems
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Bewege Scheibe 1 von " + from + " nach " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Bewege Scheibe " + n + " von " + from + " nach " + to);
        hanoi(n - 1, aux, to, from);
    }
}
