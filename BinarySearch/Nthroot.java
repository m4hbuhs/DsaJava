public class Nthroot {
    private static int func(int o,int p,int q){
        long ans =1;
        for(int i =1;i<=p;i++){
            ans=ans*o;
            if(ans>q) return 2;
        }
        if(ans == q) return 1;
        return 0;
    }
    private static int Nroot(int x,int n){
        int low=1,high = x;
        while(low<=high){
            int mid = low+ (high-low)/2;
            int midN=func(mid,n,x);
            if(midN==1) return mid;
            else if(midN==0) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n =27;
        System.out.println(Nroot(n, 3));
    }
}
