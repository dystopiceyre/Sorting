package searching;

/**
 * Extra credit implementation of jump search
 */
public class Jump {
    /**
     * Runs the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 11, 17, 19, 28, 32, 34, 41, 42, 51, 59, 61, 66, 68, 69, 72, 74, 75, 82, 83, 84, 87, 99};
        //search low end of array
        System.out.println(jumpSearch(arr, 17));
        //search middle of array
        System.out.println(jumpSearch(arr, 59));
        //search high end of array
        System.out.println(jumpSearch(arr, 83));
        //search for item not in array
        System.out.println(jumpSearch(arr, 16));
    }


    /**
     * @param arr    a sorted integer array
     * @param search the item to search for
     * @return the index the search term is found at,
     * or -1 if not found
     */
    public static int jumpSearch(int[] arr, int search) {
        //finds the nearest whole number to the square root of the array length, converts to int
        int jumpInterval = (int) Math.floor(Math.sqrt((double) arr.length));
        int low = 0;
        int high = low + jumpInterval;
        //jump subarrays of determined interval until greater than array size
        while (high < arr.length - 1) {
            low = high;
            high += jumpInterval;
            //if skipped over search term, go to linear search
            if (arr[low] >= search) {
                break;
            }
        }
        //linear search of subarray
        for (int i = low; i <= high; i++) {
            if (arr[i] == search) {
                return i;
            }
        }
        //if not found, return -1
        return -1;
    }
}

