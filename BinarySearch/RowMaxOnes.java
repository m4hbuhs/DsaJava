public class RowMaxOnes {
    private static int brute(int[][] arr){
        int index=-1;
        int countMax=-1;
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0;i<n;i++){
            int countrow=0;
            for(int j =0;j<m;j++){
                countrow+=arr[i][j];
            }
            if(countrow>countMax) {
                countMax = countrow;
                index=i;
            }
        }
        return index;

    }

    private static int lower_bound(int[] arr,int target,int n){
        int ans=n;
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
    private static int optimal(int[][] arr,int n,int m){
        int countMax=0;
        int index=-1;
        for(int i=0;i<n;i++){
            int countrow = m - lower_bound(arr[i], 1, m);
            if(countrow>countMax) {
                countMax = countrow;
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[][] arr ={{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{0,1,1,1,1}};
        System.out.println(brute(arr));
        int n = arr.length;
        int m = arr[0].length;
        System.out.println(optimal(arr, n, m));
    }
    
}
