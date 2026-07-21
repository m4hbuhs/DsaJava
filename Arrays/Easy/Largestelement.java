import java.util.Arrays;

class Largestelement{
    private static void swap(int[] arr,int i,int max){
        int temp=arr[i];
        arr[i]=max;
        max=temp;
    }

    private static int optimal(int[] arr){
        int max=arr[0];
        for(int i =1;i<arr.length-1;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={9,20,8,11,29,1,3,6};
        
        int max =optimal(arr);
        System.out.println(max);
        // brute force method
        // Arrays.sort(arr);
        // for(int a:arr){
        //     System.out.print(a +" ");
        // }
        //    int max = arr[arr.length-1];
        //    System.out.println();
        //    System.out.println(max);
    }
}