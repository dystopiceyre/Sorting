/*
Olivia Ringhiser
2/12/2020
Main.java
This file creates random integer arrays,
sorts them using the bucket sort algorithm,
and displays the output to the user
*/

package greenriver.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Olivia Ringhiser
 * @version 1.0
 */
public class Main {

    private static final int NUM_GROUPS = 25;
    private static final int SIZE = 5000;
    private static final int MIN = -50;
    private static final int MAX = 1500;

    /**
     * Runs the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Sort sort = new Sort();
        Utilities util = new Utilities();
        int[] arr = util.generateArr(SIZE, MIN, MAX);
        System.out.println("Original: " + Arrays.toString(arr));
        int[] thresholds = sort.createGroups(arr, NUM_GROUPS);
        Node[] inGroups = sort.sort(arr, NUM_GROUPS, thresholds);
        ArrayList<Integer> sorted = sort.printSortedGroups(inGroups, thresholds);
        System.out.println("Sorted: " + sorted);
        System.out.println("Detected inversions: " + util.hasInversions(sorted));
    }
}