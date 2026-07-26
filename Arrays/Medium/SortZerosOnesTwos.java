import java.util.Arrays;

public class SortZerosOnesTwos {
    private static void brute(int[] nums){
        Arrays.sort(nums);
    }
    private static void better(int[] nums){
        int count=0,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count++;
            else if(nums[i]==1)count1++;
            else count2++;
        }
        for(int i =0;i<count;i++) nums[i]=0;
        for(int j=count;j<count1;j++) nums[j]=1;
        for(int k=count+count1;k<count2;k++) nums[k]=2;
    }
    // dutch nantional flag algo
    private static void optimal(int[] nums){
        int mid=0;
        int low=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, mid, low);
                mid++;
                low++;
            }
            else if(nums[mid]==1) mid++;
            else {
                swap(nums, mid, high);
                high--;
            }

        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public static void main(String[] args) {
        int[] arr ={0,0,1,0,2,1,2,1,2,1,0,1,1};
        //  brute(arr);
        optimal(arr);
        // better(arr);
       for(int a:arr){
        System.out.print(a+" ");
       }

    
    }
}
