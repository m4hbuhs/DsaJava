class Binarysearch{
    //iterative
    private static int BSearch(int[] arr,int target){
        int n =arr.length;
        int low=0;
        int high=n-1;
        int mid=(low+high)/2;
        while(low<=high){
            if(target==arr[mid]) return mid;
            else if(target>arr[mid]) low = mid+1;
            else high=mid-1;
        }
        return -1;
    }
    //recursive
    private static int Bsearch(int[] arr,int target,int low,int high){
        int n =arr.length;
        if(low>high) return -1;
        int mid=(low+high)/2;
        while(low<=high){
            if(target==arr[mid]) return mid;
            else if(target>arr[mid]) Bsearch(arr,target,mid+1,high);
            else Bsearch(arr,target,low,mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={3,4,6,7,9,12,16,17};
        int n =arr.length;
        System.out.println(BSearch(arr,7));
        System.out.println(Bsearch(arr,7,0,n-1));

    }
}