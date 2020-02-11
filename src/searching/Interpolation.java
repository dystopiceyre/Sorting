package searching;

public class Interpolation {
    public static int interpolationSearch(int[] uniformArr, int search) {
        int low = 0;
        int high = uniformArr.length - 1;

        while (low < high && uniformArr[low] <= search && uniformArr[high] >= search) {
            int position = low + ((search - uniformArr[low]) * (high - low)) / (uniformArr[high] - uniformArr[low]);
            if (uniformArr[position] == search) {
                return position;
            }
            else if (uniformArr[position] < search) {
                low = position + 1;
            }
            else {
                high = position - 1;
            }
        }
        return -1;
    }
}
