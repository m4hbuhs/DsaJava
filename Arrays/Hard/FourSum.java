import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FourSum{
    private static List<List<Integer>> brute(int[] nums,int target){
        Set<List<Integer>> set = new HashSet<>();
        int n=nums.length;
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                for(int k =j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                            ArrayList<Integer> temp=new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);

                            Collections.sort(temp); 
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    private static List<List<Integer>> better(int[] nums,int target){
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                HashSet<Integer> s = new HashSet<>();
                for(int k =j+1;k<n;k++){
                    int sum = nums[i]+nums[j];
                    sum+=nums[k];
                    int fourth=target - sum;
                    if(s.contains(fourth)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(fourth);

                        Collections.sort(temp);
                        set.add(temp);
                    }
                    s.add(nums[k]);
                    
                }
            }
        }
        return new ArrayList<>(set);

    }
    public static List<List<Integer>> optimal(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j]+ nums[k] + nums[l];

                    if (sum == target) {

                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        list.add(temp);

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        
                        while (k < l && nums[l] == nums[l + 1]) l--;
                        

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
        System.out.println(brute(arr, 0));
        System.out.println(better(arr, 0));
        System.out.println(optimal(arr, 0));
    }
}