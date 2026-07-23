public class LinearSearch {
    private static int optimal(int[] arr,int num){
        for(int i =0;i<arr.length;i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,3,4,5,2,67,12,34,56,78,4};
        int k =67;
        int index=optimal(arr,k);
        System.out.println(index);
    }
    
}
