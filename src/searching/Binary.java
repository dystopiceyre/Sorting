package searching;

public class Binary {
    //    T(n) = O(log n)
    public static int binarySearch(int[] sortedArr, int searchTerm) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (sortedArr[mid] == searchTerm) {
                return mid;
            }
            else if (sortedArr[mid] < searchTerm) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] arr, int search) {
        return recursiveBinarySearch(arr, search, 0, arr.length - 1);
    }

    public static int recursiveBinarySearch(int[] arr, int search, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (arr[mid] == search) {
            return mid;
        }
        else if (arr[mid] < search) {
            return recursiveBinarySearch(arr, search, mid + 1, high);
        }
        else {
            return recursiveBinarySearch(arr, search, low, mid - 1);
        }
    }
}
