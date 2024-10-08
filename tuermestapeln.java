package com.btcag.bootcamp.W02;
import java.util.Scanner;

public class tuermestapeln {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie hoch soll der Turm sein? ");
        int size = scanner.nextInt();
        int[] usableTowerIndexes = new int[2]; //speichert die Türme
        long[][] towers = {new long[size], new long[size], new long[size]};
        int direction = (towers[0].length % 2) * -2 + 1; //in welche Richtung die Ringe gehen
        long movesMade = 0;

        for (int i = 0; i < towers.length; i++) { //erstellt Ringe
            towers[0][i] = i + 1;
        }

        while ((arrSum(towers[0]) + arrSum(towers[1])) != 0) {
            System.out.println(generateDisplay(towers) + "\n");
            if (movesMade % 2 == 0) {
                for (int i = 0; i < towers.length; i++) {
                    if (findFirst(towers[i]) != -1) {
                        if (towers[i][findFirst(towers[i])] == 1) {
                            moveDisk(towers[i], towers[posMod((i - direction), towers.length)]);
                            usableTowerIndexes[0] = i;
                            usableTowerIndexes[1] = posMod((i - direction), towers.length);
                            i = 3;
                        }
                    }
                }
            } else {
                if (!moveDisk(towers[usableTowerIndexes[0]], towers[usableTowerIndexes[1]])) {
                    moveDisk(towers[usableTowerIndexes[1]], towers[usableTowerIndexes[0]]);
                }
            }
            movesMade++;
        }
        System.out.println(generateDisplay(towers));
        System.out.println("Spiel wurde gewonnen in " + movesMade + " Zügen. ");
    }

    public static String generateDisplay(long[][] towerArray) {
        String display = "";
        String temp;
        char ringChar;
        for (int ringIndex = 0; ringIndex < towerArray[0].length; ringIndex++) { //jeder Ring
            for (int towerIndex = 0; towerIndex < towerArray.length; towerIndex++) { //jeder Turm
                temp = ("" + towerArray[towerIndex][ringIndex]);
                ringChar = temp.charAt(temp.length() - 1);
                temp = repeatString(" ", (towerArray[0].length + 1) - towerArray[towerIndex][ringIndex])
                        + repeatString("" + ringChar, towerArray[towerIndex][ringIndex]);
                display += temp + "@" + reverseString(temp);
                if (towerArray.length - 1 != towerIndex) {
                    display += " | "; //fügt trennlinie hinzu, wenn nicht letzter turm
                }
            }
            display += "\n";
        }
        temp = repeatString("@", (towerArray.length + 1) * 2 + 1);
        for (int i = 0; i < towerArray.length; i++) {
            display += temp;
            if (towerArray.length - 1 != i) {
                display += " | ";
            }
        }
        return display;
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static String repeatString(String str, long n) {
        String result = "";
        for (long i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

    public static int posMod(int a, int b) {
        int result = a % b;
        if (result < 0) {
            result += b;
        }
        return result;
    }

    public static int findFirst(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean moveDisk(long[] fromArr, long[] toArr) {
        int fromFirst = findFirst(fromArr);
        if (fromFirst == -1) {
            return false;
        }
        int toFirst = findFirst(toArr);
        boolean valid = false;
        if (toFirst == -1) {
            toFirst = toArr.length;
            valid = true;
        } else {
            valid = fromArr[fromFirst] < toArr[toFirst];
        }
        toFirst -= 1;
        if (valid) {
            toArr[toFirst] = fromArr[fromFirst];
            fromArr[fromFirst] = 0;
            return true;
        }
        return false;
    }

    public static long arrSum(long[] arr) {
        long sum = 0;
        for (long i : arr) {
            sum += i;
        }
        return sum;
    }
}