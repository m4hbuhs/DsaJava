import java.util.HashSet;

public class Removeduplicates {
    private static int brute(int[] nums){
        HashSet<Integer> seen =new HashSet<>();
         int index = 0;

        for (int num : nums) {
            if (!seen.contains(num)) {
                seen.add(num);
                nums[index] = num;
                index++;
            }
        }
        return index;
    }
    private static int optimal(int[] nums){
        int j = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,1,2,2,2,3,3,3,3};
        System.out.println("number of elements repeted -> "+ optimal(arr));
        System.out.println("number of elements repeted -> "+ brute(arr));

    }

    
}
