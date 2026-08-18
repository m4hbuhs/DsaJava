public class SingleEle {
    public static int brute(int[] arr){
        int n = arr.length;
        int num=0;
        if(n==1) return arr[0];
       for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    num = arr[i];
            }
            else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    num = arr[i];
            }
            else {
                if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1])
                    num = arr[i];
            }
        }

        return num;
    }
     public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            if (mid % 2 == 1)
                mid--;

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } 
            else {
                high = mid;
            }
        }

        return nums[low];
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6,7,7,8,8};
        System.out.println(brute(arr));
        System.out.println(singleNonDuplicate(arr));
    }
    
}