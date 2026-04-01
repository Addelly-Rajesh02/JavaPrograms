package practiseprograms.numbers;

import java.util.Random;

public class GenerateRandomNumber {

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        int random = getRandomInt(1, 100);
        System.out.println("Random number: " + random);
    }
}