import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    private static int[] brute(int[] nums,int target){
        for(int i =0;i<nums.length;i++){
            for(int j=i + 1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};

    }
    private static int[] optimal(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];

            if (map.containsKey(temp)) {
            return new int[]{map.get(temp), i};
            }

        map.put(nums[i], i);
    }

    return new int[]{-1, -1};
    
    }
    private static boolean checkTwoSumOptimal(int[] nums,int target){
        Arrays.sort(nums);
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==target) return true;
            else if(sum<target) left++;
            else right--;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr ={3,1,2,3};
        int k=6;
        int[] hehe=brute(arr, k);
        int[] res=optimal(arr, k);
         System.out.println("brute fore approach -> "+hehe[0]+" "+hehe[1]);
        System.out.println("optimal approach -> "+res[0]+" "+res[1]);
        System.out.println(checkTwoSumOptimal(arr, k));
    }
    
}
