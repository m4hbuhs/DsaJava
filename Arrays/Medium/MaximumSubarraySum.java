public class MaximumSubarraySum {
    private static int brute(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                    if(sum>max) max=sum;
                }
            }
        }
        return max;
    }
    private static int better(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            int sum =0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>max) max=sum;
            }
        }
        return max;
    }
    private static int optimal(int[] nums){
        int sum =0;
        int max =Integer.MIN_VALUE;
        int start=0;
        int startans=0,endans=0;
        for(int i=0;i<nums.length;i++){
            if(sum==0) start =i;
            sum+=nums[i];
            if(sum>max){
                max=sum;
                startans=start;
                endans=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr ={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(brute(arr)); //tc - O(n³) | auxiliary space(extra space) - O(1) | sc - Total Space = O(1)
        System.out.println(better(arr));//tc - O(n²) | auxiliary space(extra space) - O(1) | sc - Total Space = O(1)
        System.out.println(optimal(arr));//tc - O(n) | auxiliary space(extra space) - O(1) | sc - Total Space = O(1)
    }
    
}
