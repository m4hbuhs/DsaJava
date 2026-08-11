public class CountInversions {
    public static long brute(int[] arr) {

        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
    public static long optimal(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int low, int high) {
        long count = 0;
        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    private static long merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        long count = 0;
        int[] temp = new int[high - low + 1];
        int index = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return count;
    }
    public static void main(String[] args) {
         int[] arr = {5, 3, 2, 4, 1};

        System.out.println(brute(arr));
        System.out.println(optimal(arr));
    }
    
}
