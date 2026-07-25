import java.util.HashMap;

public class LongestSubarrayk {
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
    private static int optimal(int[] nums,int k){
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
    public static void main(String[] args) {
        int[] arr ={1,2,3,1,1,1,4,1,1,2,3};
        int k =5;
        System.out.println("longest subarray length -> "+brute(arr,k));
        System.out.println("longest subarray length -> "+optimal(arr, k));
    }
}
