import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class UnionNIntersection {
   
        public static ArrayList<Integer> optimalUnion(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while(i < arr1.length && j < arr2.length){

            if(arr1[i] <= arr2[j]){

                if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i])
                    ans.add(arr1[i]);

                i++;
            }
            else{

                if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j])
                    ans.add(arr2[j]);

                j++;
            }
        }

        while(i < arr1.length){

            if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i])
                ans.add(arr1[i]);

            i++;
        }

        while(j < arr2.length){

            if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j])
                ans.add(arr2[j]);

            j++;
        }

        return ans;
    }
    private static int[] bruteunion(int[] arr1, int[] arr2) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : arr1)
            set.add(num);

        for (int num : arr2)
            set.add(num);

        int[] union = new int[set.size()];

        int i = 0;
        for (int num : set) {
            union[i++] = num;
        }

        return union;
    }
    public static ArrayList<Integer> bruteintersection(int[] arr1, int[] arr2){

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[arr2.length];

        for(int i = 0; i < arr1.length; i++){

            for(int j = 0; j < arr2.length; j++){

                if(arr1[i] == arr2[j] && !visited[j]){
                    ans.add(arr1[i]);
                    visited[j] = true;
                    break;
                }
            }
        }

        return ans;
    }
    public static ArrayList<Integer> optimalintersection(int[] arr1, int[] arr2){

        int i = 0;
        int j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while(i < arr1.length && j < arr2.length){

            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }
            else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }

        return ans;
    }

        
    
    public static void main(String[] args) {
        int[] arr1={1,1,2,3,4,5,6,7};
        int[] arr2={2,3,4,4,5,6,7};

        System.out.println(optimalUnion(arr1, arr2));
        System.out.println(optimalintersection(arr1,arr2));
        // System.out.println(optimalunion(arr1, arr2));
        // int[] union = bruteunion(arr1, arr2);
        // for(int u :union){
        //     System.out.print(u+" ");
        // }
    }
    
}
