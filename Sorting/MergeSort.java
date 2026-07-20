import java.util.ArrayList;
public class MergeSort {
    // Divide and Merge 
    private static void merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        // int[] temp = new int[high - low + 1];  without array list
        // int k = 0;                             without array list
        int left =low;
        int right =mid+1;
        while( left <= mid && right<=high){
            if(arr[left]<= arr[right]){
                temp.add(arr[left]);   //temp[k++] = arr[left++];
                left++;                
            }
            else{
                temp.add(arr[right]);  //temp[k++] = arr[right++];
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);  //temp[k++] = arr[left++];
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);//temp[k++] = arr[right++];
            right++;
        }
        for (int i = low; i <= high; i++) {    
            arr[i] = temp.get(i - low);       
        }
        // for (int i = 0; i < temp.length; i++) {
        //     arr[low + i] = temp[i];
        // }

    }
    private static void Mergesort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        Mergesort(arr,low,mid);
        Mergesort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args) {
        int[] nums={3,1,2,4,1,5,2,6,4};
        int low = 0;
        int high = nums.length-1;
        Mergesort(nums,low,high);
        for (int num : nums) {
        System.out.print(num + " ");
        }
    }
}
