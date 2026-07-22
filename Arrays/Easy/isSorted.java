import java.util.Arrays;

class isSorted {

    private static boolean brute(int[] arr) {
        int[] nums = Arrays.copyOf(arr, arr.length);

        Arrays.sort(nums);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean optimal(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 5};

        System.out.println(brute(arr));   
        System.out.println(optimal(arr)); 
    }
}