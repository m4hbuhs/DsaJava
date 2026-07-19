class Solution{
    void Recurse(int i ,int n){
        if(n<i) return;
        Recurse(i+1,n);
        System.out.print(i+ " ");

    }
}
public class NtoOnebacktracking {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int N =5;
        obj.Recurse(1,N);
    }
    
}
