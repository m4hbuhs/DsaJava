public class UpperBound {
    private static int upper_bound(int[] arr,int target,int n){
        int low=0;
        int high=n-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
       int[] arr ={2,3,6,7,8,8,11,11,11,12};
    System.out.println(upper_bound(arr, 6, arr.length));
    }
}
