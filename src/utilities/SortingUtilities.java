package utilities;

import java.util.Random;

public class SortingUtilities {
    public static int[] genArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }
}
