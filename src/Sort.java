/*
Olivia Ringhiser
2/13/2020
Sort.java
This file contains an implementation
of the bucket sort alogirthm
*/


package greenriver.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A version of the Bucket sorting algorithm
 *
 * @author Olivia Ringhiser
 * @version 1.0
 */
public class Sort {

    /**
     * @param arr       unsorted integer array
     * @param numGroups user defined number of groups
     * @return the upper bounds for each group
     */
    public int[] createGroups(int[] arr, int numGroups) {
        //ensures there are more groups than items
        if (numGroups >= arr.length) {
            System.out.println("Can't have more groups than elements! Setting the " +
                    "number of elements to half of array.length");
            numGroups = arr.length / 2;
        }
        System.out.println("Sorting with " + numGroups + " groups");
        int min = findMin(arr);
        int max = findMax(arr);
        System.out.println("Min/max: [" + min + "," + max + "]");
        //number of possible values
        int range = max - min + 1;
        //approximate group size
        int groupSize = range / numGroups;
        System.out.println("The group size is: " + groupSize);
        int[] groupThresholds = new int[numGroups];
        /*assigns the largest number that fits into each group
         * With this implementation, all of the 'remainders' of the integer division
         * will fall into the first threshold, meaning if the range of possible
         * numbers doesn't divide evenly into the number of groups, the first
         * threshold will always be slightly bigger than the others*/
        groupThresholds[groupThresholds.length - 1] = max;
        for (int i = groupThresholds.length - 2; i >= 0; i--) {
            groupThresholds[i] = groupThresholds[i + 1] - groupSize;
        }
        System.out.println("Group thresholds: " + Arrays.toString(groupThresholds));
        return groupThresholds;
    }

    /**
     * Sorts the integer array by calling the add method
     * for each value in the array
     *
     * @param arr        unsorted integer array
     * @param numGroups  number of groups
     * @param thresholds highest integer thresholds
     * @return sorted integer array
     */
    public Node[] sort(int[] arr, int numGroups, int[] thresholds) {
        Node[] groups = new Node[numGroups];
        for (int value : arr) {
            //adds each integer into the correct group
            for (int j = 0; j < thresholds.length; j++) {
                if (value <= thresholds[j]) {
                    add(groups, value, j);
                    break;
                }
            }
        }
        return groups;
    }

    /**
     * Creates a Node with an integer value and sorts
     * it into a linked list of integers within a
     * certain threshold
     *
     * @param groups node array of groups/buckets
     * @param item   data to be stored in Node
     * @param index  index of proper group
     */
    private void add(Node[] groups, int item, int index) {
        //group currently empty
        if (groups[index] == null) {
            groups[index] = new Node(item);
        }
        //adding to the beginning of the group
        else if (groups[index].getData() > item) {
            Node newNode = new Node(item, groups[index]);
            groups[index] = newNode;
        }
        //look for proper place in linked nodes
        else {
            Node prev = groups[index];
            //set new node to head
            Node newNode = new Node(item, prev);
            //find the node directly before the new node
            while (prev.getNext() != null && prev.getNext().getData() < newNode.getData()) {
                prev = prev.getNext();
            }
            //put the new node in sorted order
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
    }

    private int findMin(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * prints out the nodes within the groups
     * and returns the sorted values in an a list
     *
     * @param groups     sorted elements in groups
     * @param thresholds the cutoff thresholds
     * @return a list of sorted integers
     */
    public ArrayList<Integer> printSortedGroups(Node[] groups, int[] thresholds) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < thresholds.length; i++) {
            System.out.print(i + "[" + thresholds[i] + "]: ");
            Node node = groups[i];
            //iterates through nodes
            while (node != null) {
                //adds the integers to the list
                sorted.add(node.getData());
                System.out.print(node.getData());
                //adds an arrow if the node has one after it
                if (node.hasNext()) {
                    System.out.print(" -> ");
                }
                node = node.getNext();
            }
            System.out.println();
        }
        return sorted;
    }

}