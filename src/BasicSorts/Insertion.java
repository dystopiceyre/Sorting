package BasicSorts;

public class Insertion {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = j;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
}
