class Solution {
    int f(int n){
        if(n<=1) return n;
        return f(n-1)+f(n-2);
    }
}
public class Fibonacci {
    public static void main(String[] args) {
        Solution obj=new Solution();
        int N=10;
        int res = obj.f(N);
        System.out.println(res);
    }
    
}
