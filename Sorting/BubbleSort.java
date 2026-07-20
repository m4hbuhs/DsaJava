public class BubbleSort {
    // push the max to the last by adjacent swap
    private static void Swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void Sort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j =0;j<=i;j++){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={1,3,2,9,3,5};
        Sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
}
