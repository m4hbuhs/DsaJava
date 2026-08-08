import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static List<List<Integer>> brute(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n - 1; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp);   // Ensure same order
                        set.add(temp);            // Removes duplicates
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
    public static List<List<Integer>> better(int[] nums){
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i]+nums[j]);
                if(hashSet.contains(third)){
                     List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(third);

                        Collections.sort(temp);   // Ensure same order
                        set.add(temp);  
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(set);

    }
    public static List<List<Integer>> optimal(int[] nums){
        ArrayList<List<Integer>> list = new ArrayList<>();
        int n =nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){

            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i + 1;
            int k = n - 1;
            while(j<k){
                int sum =nums[i]+nums[j]+nums[k];

                if(sum<0) j++;

                else if(sum>0) k--;

                else{
                    ArrayList<Integer> temp =new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    list.add(temp);
                    
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }

        }
        return list;
    }
    
    public static void main(String[] args) {
        int[] arr ={1,1,1,1,2,2,2,3,3,3,3,-1,1,1,-1,1,-1,1,1,-2,2,-2,-3,-3,3};
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
