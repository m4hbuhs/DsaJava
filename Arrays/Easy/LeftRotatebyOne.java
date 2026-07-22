public class LeftRotatebyOne {
    private static void optimal(int[] arr){
        int temp=arr[0];
        for(int i =1;i<arr.length;i++){
            arr[i-1]=arr[i];     
        }
        arr[arr.length-1]=temp;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        optimal(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
