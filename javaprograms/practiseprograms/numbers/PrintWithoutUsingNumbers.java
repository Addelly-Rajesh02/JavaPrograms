package practiseprograms.numbers;

import java.util.Scanner;

public class PrintWithoutUsingNumbers {

    public static void printWithoutUsingNumbers() {
        int hundred = 'd';
        int one = 'A' / 'A';
        for (int i = one; i <= hundred; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            printWithoutUsingNumbers();
        }
    }
}