class Solution{
    void Recurse(int i ,int n){
        if(i<1) return;
        Recurse(i-1,n);
        System.out.print(i+ " ");

    }
}
public class OnetoNbacktracknig {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int N =5;
        obj.Recurse(N,N);
    }
    
}
