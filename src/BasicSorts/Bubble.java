package BasicSorts;

public class Bubble {
    public static void bubbleSort(int[] arr) {
        //for each position
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            //swap elements until we find the next
            //highest element in the array
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
