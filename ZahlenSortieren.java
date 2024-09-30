import java.util.Scanner;

public class ZahlenSortieren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[6];
        System.out.println("Bitte geben Sie bis zu 6 Zahlen ein, mit Leerzeichen getrennt: ");
        for (int i = 0; i < 6; i++){
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            }else{
                break;
            }
        }
        zahlenSortieren(array);
        System.out.println("Sortiertes Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    public static void zahlenSortieren(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++){
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
