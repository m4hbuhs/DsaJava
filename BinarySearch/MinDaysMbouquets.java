public class MinDaysMbouquets {
    private static int MinElement(int[] arr,int n){
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            min=Math.min(min, arr[i]);
        }
        return min;
    }
    private static int MaxElement(int[] arr,int n){
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max=Math.max(max, arr[i]);
        }
        return max;
    }
   private static boolean Possbile(int[] arr, int m, int k, int mid, int n) {
        int count = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid) {
                count++;
            } 
            else {
                noOfB += count / k;
                count = 0;
            }
            if (noOfB >= m) {
                return true;
            }
        }
        noOfB += count / k;
        return noOfB >= m;
    }

    private static int Minday(int[] bloomday,int m, int k){
        int n = bloomday.length;
        if ((long) m * k > n) {
            return -1;
        }
        int low =MinElement(bloomday,n),high=MaxElement(bloomday,n);
        while(low<=high){
            int mid =low +(high-low)/2;
            if(Possbile(bloomday,m,k,mid,n)) high =mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr={7,7,7,7,13,11,12,7,};
        System.out.println(Minday(arr,2,3));
    }
    
}
