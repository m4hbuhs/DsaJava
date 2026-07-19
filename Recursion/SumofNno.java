class Solution{
    int SumofN(int sum){
        // base case
        if(sum==0) {
            return 0;
        }
        // backtrack
        return sum+SumofN(sum-1);
        

    }
}
public class SumofNno {
     public static void main(String[] args) {
        Solution obj = new Solution();
        int N =5;
        int res = obj.SumofN(N);
        System.out.println(res);
    }
}
