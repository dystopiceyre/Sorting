package DivideAndConquer;

import java.util.Arrays;

public class Mergesort {

    private static int[] aux;

    public static void main(String[] args) {
        int[] testArray = {10, 13, 1, 2, 4, 18, 22, -10};
        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void mergeSort(int[] array) {
        //pre-condition
        if (array.length <= 1) {
            return; //already sorted
        }

        aux = new int[array.length];

        //recursively sort array
        mergeSort(array, 0, array.length - 1);
    }

    //recursively sort elements from low to high (inclusive)
    private static void mergeSort(int[] array, int low, int high) {
        //base case
        if (high - low <= 0) {
            return; //subarray of length 1 or 0
        }
        //recursively sort left and right sub-array
        int mid = (high + low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, high);
    }

    private static void merge(int[] array, int low, int high) {
        //find midpoint and set left and right pointers
        int mid = (high + low / 2);
        int left = low;
        int right = mid + 1;
        int numToMerge = high - low + 1;

        for (int i = 0; i < numToMerge; i++) {
            //check if we have exhausted either subarray
            if (left > mid) {
                aux[i] = array[right++];
            }
            else if (right > high) {
                aux[i] = array[left++];
            }
            //check for smaller element of the two
            else if (array[left] < array[left]) {
                aux[i] = array[left++];
            }
            else { //if array[right] <= array[left]
                aux[i] = array[right++];
            }
        }
        //copy our merged subarrays from aux to original
        for (int i = 0; i < numToMerge; i++) {
            array[low + i] = aux[i];
        }
    }

}
