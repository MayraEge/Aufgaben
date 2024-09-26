import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe einen Namen ein: ");
        String name = "";

        do{
            name = scanner.next();
           isValid = name.length() > 3 && name.length() <= 15;
           if(!isValid){
               System.out.println("Der Name darf minimum 3 Zeichen und max 15 Zeichen benutzen.  ");
           }
        } while (!isValid);

        System.out.println(name);
    }
}
