import java.util.Arrays;

public class SecondsmallestNlargest {
    private static int[] optimal(int[] arr){
        int  secondSmallest=Integer.MAX_VALUE,min=Integer.MAX_VALUE;
        int secondLargest=Integer.MIN_VALUE,max=Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);  // Update the smallest element
            max = Math.max(max, arr[i]);  // Update the largest element
        }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < secondSmallest && arr[i] != min) {
                    secondSmallest = arr[i];  
                    }
                if (arr[i] > secondLargest && arr[i] != max) {
                    secondLargest = arr[i];  
                    }
                }

        return new int[] {secondSmallest,secondLargest };
        }

    
    public static void main(String[] args) {
        int[] arr={9,20,8,11,29,1,3,6};
        int[] ans = optimal(arr);

        System.out.println("Second Smallest: " + ans[0]);
        System.out.println("Second Largest: " + ans[1]);
        //brute force method
        // Arrays.sort(arr);
        // for(int a : arr){
        //     System.out.print(a+" ");
        // }
        // int max = arr[arr.length-1];
    }
}
