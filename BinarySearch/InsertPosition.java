public class InsertPosition {
    private static int SearchPosition(int[] arr,int k){
        int n =arr.length;
        int low=0;
        int high=n-1;
        int ans=0;
        //lowerbound
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr ={1,2,4,7};
        System.out.println(SearchPosition(arr, 6));
    }
}
