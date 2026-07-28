import java.util.ArrayList;
import java.util.List;

public class LeaderofaArrays {
    private static List<Integer> brute(int[] nums){
        ArrayList<Integer> list =new ArrayList<>();
        int n=nums.length-1;
        
        for(int i =0;i<n;i++){
            boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]){
                    leader=false;
                }
            }
            if(leader==true){
                list.add(nums[i]);
            }
        }
        return list;

    }
    private static List<Integer> optimal(int[] nums){
         ArrayList<Integer> list =new ArrayList<>();
        int n=nums.length-1;
        int max =Integer.MIN_VALUE;
        for(int i =n-1;i>0;i--){
            if(nums[i]>max){
                list.add(nums[i]);
            }
            max=Math.max(max, nums[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr={10,22,12,0,3,6};
        for(int a:brute(arr)){
            System.out.print(a+" ");
        }
        System.out.println();
        for(int a:optimal(arr)){
            System.out.print(a+" ");
        }
        
    }
    
    
}
