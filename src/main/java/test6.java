import java.util.Scanner;
public class test6 {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static char[][] board = new char[ROWS][COLS];
    private static String playerOneName;
    private static String playerTwoName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playerOneName = getPlayerName(scanner, 1);
        playerTwoName = getPlayerName(scanner, 2);

        intializeBoard();
        printBoard();
        playGame(scanner);
    }

    private static String getPlayerName(Scanner scanner, int playerNumber) {
        String name;
        while (true) {
            System.out.println("Spieler " + playerNumber + ", bitte gib deinen Namen ein ( 3- 15 Zeichen max.): ");
            name = scanner.nextLine();
            if (name.length() >= 3 && name.length() <= 15) {
                break;
            } else {
                System.out.println("Ungültiger Name. Der Name muss mindestens 3 Zeichen und höchstens 15 Zeichen lang sein. ");
            }
        }
        return name;
    }

    private static void intializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playGame(Scanner scanner) {
        boolean playerOneTurn = true;
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            if (playerOneTurn) {

                System.out.println(playerOneName + " (X), wähle eine Spalte von 0 bis 6 aus: ");
            } else {
                System.out.println(playerTwoName + " (O), wähle eine Spalte von 0 bis 6 aus: ");
            }

            int column = scanner.nextInt();
            if (column < 0 || column >= COLS) {
                System.out.println("Ungültige Eingabe, bitte wähle eine Spalte von 0 bis 6 aus: ");
                continue;
            }
            if (!placeDisc(column, playerOneTurn ? 'X' : 'O')) {
                System.out.println("Diese Spalte ist voll, bitte wähle eine andere Spalte aus.");
                continue;
            }
            gameWon = checkWin();
            playerOneTurn = !playerOneTurn;
        }
        printBoard();
        System.out.println("Gewonnen! Spiel beendet!");
    }

    private static boolean placeDisc(int column, char disc) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == '.') {
                board[i][column] = disc;
                return true;
            }
        }
        return false;
    }

    private static boolean checkWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] != '.' && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] != '.' && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2] && board[i][j] == board[i - 3][j + 3]) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] != '.' && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}
