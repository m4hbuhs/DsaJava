public class LowerBound {
    private static int lower_bound(int[] arr,int target,int n){
        int ans=0;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr ={1,2,3,3,5,8,8,10,10,11};
        System.out.println(lower_bound(arr, 5, arr.length));

    }
    
}
