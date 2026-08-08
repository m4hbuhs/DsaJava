import java.util.HashMap;

public class SubarrayxorK {
    private static int brute(int[] nums,int x){
        int n =nums.length;
        int count=0;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                int xor=0;
                for(int k =i;k<=j;k++){
                    xor=xor^nums[k];
                }
                if(xor==x) count++;
                
            }
        }
        return count;
    }
    private static int better(int[] nums,int x){
        int n =nums.length;
        int count=0;
        for(int i =0;i<n;i++){
            int xor=0;
            for(int j =i;j<n;j++){
                    xor=xor^nums[j];
                    if(xor==x) count++;
            
            }

        }

        return count;
    }
     private static int optimal(int[] nums,int k){
        int count=0;
        int xor=0;
        int n =nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i = 0 ; i < n ; i++){
            xor=xor^nums[i];

            int x=xor^k;
            if(map.containsKey(x)) count += map.get(x);
            
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }
        return count;
     }
    public static void main(String[] args) {
        int[] arr={4,2,2,6,4};
        System.out.println(brute(arr, 6));
        System.out.println(better(arr, 6));
        System.out.println(optimal(arr, 6));

    }
}
