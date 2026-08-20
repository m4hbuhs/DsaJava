public class SqrtBS {
    private static int Sqrt(int n){
        int low=1,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            long val = (long) mid * mid;
            if(val<=n) low=mid+1;
            else high=mid-1;
        }
        return high;
    }
    public static void main(String[] args) {
        int n =28;
        System.out.println(Sqrt(n));
    }
}
