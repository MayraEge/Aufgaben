import java.util.Scanner;

public class immerPositiv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long myLong = Scanner.nextLong();
        if (myLong < 0) {
            myLong *= -1;
        }
        System.out.println(myLong);
    }
}
