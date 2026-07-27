import java.util.ArrayList;

class RearrangeBysign{
    private static int[] brute(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {    
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && nums[j] > 0) {
                        ans[i] = nums[j];
                        visited[j] = true;
                        break;
                    }
                }
            } else {         
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && nums[j] < 0) {
                        ans[i] = nums[j];
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    private static int[] better(int[] nums){
        int n=nums.length;
        ArrayList<Integer> pos = new ArrayList<>(n/2);
        ArrayList<Integer> neg = new ArrayList<>(n/2);
        for (int num : nums) {
            if (num > 0)
                pos.add(num);
            else
                neg.add(num);
        }

        int[] res = new int[n];

        for (int i = 0; i < n / 2; i++) {
            res[2 * i] = pos.get(i);
            res[2 * i + 1] = neg.get(i);
        }

        return res;
    }
    private static int[] optimal(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {

            if (num > 0) {
                ans[posIndex] = num;
                posIndex += 2;
            } else {
                ans[negIndex] = num;
                negIndex += 2;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr={3,1,-2,-5,2,-4};
        for(int num:brute(arr)){
            System.out.print(num + " ");
        }
        for(int num:better(arr)){
            System.out.print(num + " ");
        }
        for(int num:optimal(arr)){
            System.out.print(num + " ");
        }
    }
}