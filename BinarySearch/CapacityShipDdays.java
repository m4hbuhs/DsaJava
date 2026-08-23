public class CapacityShipDdays {
    private static int DaysRequired(int[] weights,int n,int capacity){
        int day = 1, load = 0;
        for(int i =0;i<n;i++){
            if(load+weights[i]>capacity){
                day++;
                load =weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return day;
    }
    private static int Minload(int[] weights,int n,int days){ 
        int max = Integer.MIN_VALUE,sum =0;
        for(int i = 0;i<n;i++){
            max = Math.max(max, weights[i]);
            sum +=weights[i];
        }
        int low =max,high=sum;
        while (low<=high) {
            int mid = low + (high - low) / 2;
            int day = DaysRequired(weights,n,mid);
            if(day<=days) high=mid-1;
            else low = mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights= {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int n = weights.length;
        System.out.println(Minload(weights, n, days));

    }
    
}