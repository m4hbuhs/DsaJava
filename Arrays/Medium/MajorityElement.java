import java.util.HashMap;

public class MajorityElement {
    private static int brute(int[] nums){
        for(int i=0;i<nums.length;i++){
            int cnt=0;
            for(int j =0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
            if(cnt>nums.length/2) return nums[i];
        }
        return -1;
    } 
    private static int better(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
         for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
    private static int optimal(int[] nums){
        int count=0;
        int el=0;
        for(int i =0;i<nums.length;i++){
            if(count==0){
                count=1;
                el=nums[i];
            }
            else if(el==nums[i]) count++;
            else count--;
        }
        int count1=0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]==el) count1++;
        }
        if(count1>nums.length/2) return el;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,4,5,4,5,6,5,6,5,5};
        System.out.println(brute(arr));//tc - O(n²) | auxiliary space(extra space) - O(1) | sc - Total Space = O(1)
        System.out.println(better(arr));//tc - O(n) | auxiliary space(extra space) - O(n) | sc - Total Space = O(n)
        System.out.println(optimal(arr));//tc - O(n) + O(n) = O(n) | auxiliary space(extra space) - O(1) | sc - Total Space = O(1)
    }
    
}
