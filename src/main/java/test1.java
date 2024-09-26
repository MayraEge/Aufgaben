public class test1 {
    public static void main(String[] args) {
        String[] items = new String[15];
        System.out.println("Array Laenge " + items.length);
        for (int index = 14; index >=0; index--) {
            items[index] = "" + (index);
        }
        for (int index = 0; index < items.length; index++) {
           System.out.println(items[index]);
        }
    }
}
