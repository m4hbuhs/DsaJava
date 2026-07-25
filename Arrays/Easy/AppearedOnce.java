import java.util.HashMap;

public class AppearedOnce {
    private static int brute(int[] arr){
        for(int i =0;i<arr.length;i++){
            int num=arr[i];
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==num){
                    count++;
                }
            }
            if(count==1) return num;
        }
        return -1;
        
    }
    private static int better(int[] arr){
        int max= arr[0];
        
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int[] hash= new int[max+1];
        for(int i=0;i<arr.length;i++){
                hash[arr[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(hash[arr[i]]==1) return arr[i];
        }
        return -1;
    }
    private static int betterlong(int[] arr){
       HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;

    }
    private static int optimal(int[] nums){
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }
        return xor;
        
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4};
        // System.out.println(brute(arr)); tc - n × n = O(n²) | auxilary space(extra space)-O(1) | sc-Total Space = O(n)
        // System.out.println(better(arr));// TC - O(n) + O(n) + O(n) = O(3n) = O(n) | Auxiliary Space (Extra Space) - O(max) | SC - O(n + max)
        // System.out.println(betterlong(arr)); //TC - O(n) + O(n) = O(2n) = O(n) | Auxiliary Space (Extra Space) - O(n) | SC - O(n)
        System.out.println(optimal(arr));//TC - O(n) | Auxiliary Space (Extra Space) - O(1) | SC - O(n)
    }
    
}
