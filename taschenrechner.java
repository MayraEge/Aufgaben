import java.util.Scanner;

public class taschenrechner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Willkommen beim einfachen Taschenrechner!");

        while (continueCalculating) {
            System.out.println("Gib die erste Zahl ein: ");
            double number1 = sc.nextDouble();

            System.out.println("Gib die zweite Zahl ein: ");
            double number2 = sc.nextDouble();

            System.out.println("Wähle die Operation (+, -, *, /): ");
            char operation = sc.next().charAt(0);

            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        System.out.println("DIVISION DURCH NULL IST VERBOTEN!!!");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Ungültige Operation");
                    validOperation = false;
            }
            if (validOperation) {
                System.out.println("Das Ergebnis ist: " + result);
            }
            System.out.println("Weiterrechnen? (Ja/Nein)");

            String userResponse = sc.nextLine();
            if (!userResponse.equalsIgnoreCase("ja")) {
                continueCalculating = false;
            }
        }
        System.out.println("Du bist schon fertig? Byebye!");
    }
}
