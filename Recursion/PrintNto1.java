class Solution{
    void Recurse(int i ,int n){
        if(i>n) return;
        System.out.print(n+ " " );
        Recurse(i,n-1);

    }
}
public class PrintNto1 {
     public static void main(String[] args) {
        Solution obj = new Solution();
        int N =5;
        obj.Recurse(1,N);
    }
    
    
}
