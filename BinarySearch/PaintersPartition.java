public class PaintersPartition {
    private static int CountPainter(int[] arr,long mid){
        int Painter=1;
        long paint = 0;
        for(int i =0;i<arr.length;i++){
            if(paint+arr[i]<=mid) paint+=arr[i];
            else {
                Painter++;
                paint=arr[i];
            }
        }
        return Painter;
    }
    public static int minTime(int[] arr, int k) {
        if(k>arr.length) return -1;
        int max = Integer.MIN_VALUE;
        long sum =0;
        for(int i =0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            sum = sum + arr[i];
        }
        long low =max,high =sum;
        while(low<=high){
            long mid = low + (high-low)/2;
            int painter = CountPainter(arr,mid);
            if(painter>k) low = mid +1;
            else high = mid - 1;
        }
        return (int)low;
    }
    public static void main(String[] args) {
        int[] arr ={5, 10, 30, 20, 15} ;
        int k = 3;
        System.out.println(minTime(arr, k));
    }
}

