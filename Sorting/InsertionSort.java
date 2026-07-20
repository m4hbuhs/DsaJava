class InsertionSort{
    // takes an element and place it in a correct order
    private static void Swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void Sort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                Swap(arr,j-1,j);
                j--;
            }
        }
    }
    public static void main(String[] args){
        int[] nums ={9,8,7,6,5,4,3};
        Sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}