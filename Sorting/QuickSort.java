public class QuickSort {
    private static void Swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static int index(int[] arr,int low,int high){
        int pivot=arr[low];
        int i= low;
        int j = high;
        while(i<j){
            while(i <= high-1 && arr[i] <= pivot){
                i++;
            }
            while(j >= low+1 && arr[j] > pivot){
                j--;
            }
            if(i<j){
                Swap(arr,i,j);
            }
        }
        Swap(arr,low,j);
        return j;
    }
    private static void Qsort(int[] arr,int low,int high){
        if(low>=high) return;
        int partiton = index(arr,low,high);
        Qsort(arr,low,partiton-1);
        Qsort(arr,partiton+1,high);

    }
    public static void main(String[] args) {
        int[] nums={3,1,2,4,1,5,2,6,4};
        int low = 0;
        int high = nums.length-1;
        Qsort(nums,low,high);
        for (int num : nums) {
        System.out.print(num + " ");
        }
    }
    
}
