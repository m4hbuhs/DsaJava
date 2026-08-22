public class SmallestDivisor {
    public static int MaxElement(int[] nums,int n){
        int max=0;
        for(int i =0;i<n;i++){
            max=Math.max(max, nums[i]);
        }
        return max;
    }
    private static int sumofD(int[] nums,int mid,int n){
        int sum =0;
        for(int i =0;i<n;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low=1,high=MaxElement(nums,n);
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sumofD(nums,mid,n)<=threshold) high = mid-1;
            else low = mid +1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr ={1,2,5,9};
        System.out.println(smallestDivisor(arr, 6));

    }
    
}
