/*
Olivia Ringhiser
2/13/2020
Utilities.java
This file contains helper methods
used in the bucket sort algorithm
*/


package BucketSortAssignment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Helper functions not directly related to bucket sort
 *
 * @author Olivia Ringhiser
 * @version 1.0
 */
public class Utilities {
    /**
     * Finds if there are elements out of order in the sorted output
     *
     * @param sorted a list of sorted integer values
     * @return true if inversions are present, otherwise false
     */
    public boolean hasInversions(ArrayList<Integer> sorted) {
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i) > sorted.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a pseudo-random array of a specified
     * size with integer elements within a defined range
     *
     * @param size desired size of array
     * @param min  minimum element value
     * @param max  maximum element value
     * @return pseudo-randomly generated array within provided bounds
     */
    public int[] generateArr(int size, int min, int max) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + rand.nextInt(max - min + 1);
        }
        return arr;
    }
}
