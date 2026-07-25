import java.util.HashMap;

class LongestSubarraykPositive{
    private static int brute(int[] nums,int k){
        int maxlen=0;
        int n=nums.length;
        for(int i =0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k) {
                    if(maxlen<j-i+1){
                        maxlen=j-i+1;
                    }
                }
            }
        }
        return maxlen;
    }
    private static int better(int[] nums,int k){
        HashMap<Long,Integer> map =new HashMap<>();
        int Maxlen=0;
        long sum=0;
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
            if(sum==k){
                if(Maxlen<i+1){
                Maxlen=i+1;
                }
            }
            long rem = sum-k;
            if(map.containsKey(rem)){
                int len = i-map.get(rem);
                if(Maxlen<len) Maxlen=len;  
            }
            
            if(!map.containsKey(sum))  map.put(sum,i);
            
        }
        return Maxlen;

    }
    private static int optimal(int[] arr,int k){
        int n=arr.length;
        int left=0;
        if (arr.length == 0) return 0;
        long sum=arr[0];
        int right=0;
        int mlen=0;
        while (n>right) {
            while(left<=right && sum>k){
                sum -= arr[left];
                left++;
            }
            if(sum==k){
                if(right-left+1>mlen) mlen=right-left+1;
            }
            right++;
            if(right<n) sum+=arr[right];
        }
        return mlen;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,1,1,1,4,1,1,2,3};
        int k =5;
        System.out.println("longest subarray length -> "+brute(arr,k));
        System.out.println("longest subarray length -> "+better(arr, k));
        System.out.println("longest subarray length -> "+optimal(arr, k));
    }
}