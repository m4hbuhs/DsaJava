class Solution{
    void Recurse(int i ,int n){
        if(i>n) return;
        System.out.print(i + " " );
        Recurse(i+1,n);

    }
}
public class Print1toN {
     public static void main(String[] args) {
        Solution obj = new Solution();
        int N =5;
        obj.Recurse(1,N);
    }
    
    
}
