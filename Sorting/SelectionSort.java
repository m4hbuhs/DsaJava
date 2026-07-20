import java.util.Scanner;

class SelectionSort {
    // select minimum and swap
    static void swap(int[] arr,int min,int i){
        int temp =arr[min] ;
        arr[min]= arr[i];
        arr[i]= temp;
    }
    static void sort(int[] arr){
        
        for(int i = 0;i<arr.length-1;i++){
            int  min = i;
            for(int j = i + 1; j < arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=10;
        int[] nums= new int[n];
        for(int i =0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        sc.close();
    }

    
} 

