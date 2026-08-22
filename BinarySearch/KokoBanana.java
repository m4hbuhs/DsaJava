public class KokoBanana {
    private static int FindMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    private static int Caltotalhour(int[] arr,int hourly){
        int Totalhour=0;
        for(int i =0;i<arr.length;i++){
            Totalhour+=Math.ceil((double)arr[i]/(double)hourly);
        }
        return Totalhour;
    }
    private static int MinRateToEatBanana(int[] arr,int h ){
        int low=1,high=FindMax(arr);
        while(low<=high){
            int mid= low+(high-low)/2;
            int totalhour =Caltotalhour(arr,mid);
            if(totalhour<=h) high=mid-1;
            else low =mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] banana={3,6,7,11};
        System.out.println(MinRateToEatBanana(banana,8));
    }
}
