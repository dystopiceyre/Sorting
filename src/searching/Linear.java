package searching;

//T(n) = O(n)
public class Linear {
    public static int linearSearch(int[] arr, int searchTerm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchTerm) {
                return i;
            }
        }
        return -1;
    }
}
