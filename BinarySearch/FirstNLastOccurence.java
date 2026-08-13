public class FirstNLastOccurence {
    private static int lowerbound(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    private static int upperbond(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    private static int[] Occurence(int[] arr,int n,int target){
        int lb=lowerbound(arr, target);
        if(lb==n || arr[lb] !=target) return new int[]{-1,-1};
        return new int[]{lb,upperbond(arr, target)-1};
    }
    
    private static int firstoccurence(int[] arr,int target){
        int n = arr.length;
        int first=-1;
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                first=mid;
                high=mid-1;
            } 
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return first;
    }
    private static int lastoccurence(int[] arr,int target){
        int n =arr.length;
        int last=-1;
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                last = mid;
                low=mid+1;
            }
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return last;
    }
    private static int[] occurence(int[] arr,int target){
        int first = firstoccurence(arr, target);
        if(first==-1) return new int[] {-1,-1};
        return new int[] {first,upperbond(arr, target)-1};
    }
    public static void main(String[] args) {
        int[] arr ={2,3,6,7,8,8,8,11,11,11,12};
        int[] temp= Occurence(arr,arr.length, 8);
        for(int t:temp) System.out.print(t+" "); // binary search upper bound lower bound
        System.out.println();
        int[] hi = occurence(arr, 8);
        for(int hey:hi) System.out.print(hey+" "); //binarySearch


    }
}

