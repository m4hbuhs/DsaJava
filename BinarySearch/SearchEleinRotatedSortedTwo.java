public class SearchEleinRotatedSortedTwo {
    private static boolean SearchElement(int[] arr,int target){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            if(arr[mid]==target) return true;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                high--;low++;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]) high=mid-1;
                else low=mid+1;
            }
            else{
                if(arr[mid]<=target && target<=arr[high]) low=mid+1;
                else high= mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={3,1,2,3,3,3,3};
        System.out.println(SearchElement(arr, 2));

    }
    
}