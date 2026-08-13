public class FloorNCeil {
    public static int Ceil(int[] arr,int x) {
        int ans= -1;
        int n =arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    public static int Floor(int[] arr,int x){
        int ans=-1;
        int n =arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                low=mid+1;
            }else high=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        System.out.println("Ceil:"+Ceil(arr, 25));
        System.out.println("Floor:"+Floor(arr, 25));
    }
    
}
