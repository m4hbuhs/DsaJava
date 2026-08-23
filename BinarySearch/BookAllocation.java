public class BookAllocation {
    private static int CountPage(int[] arr ,long pages){
        int students=1;
        long pageStudent =0;
        for(int i =0;i<arr.length;i++){
            if(pageStudent+arr[i]<=pages) pageStudent+=arr[i];
            else {
                students++;
                pageStudent=arr[i];
            }
        }
        return students;
    }
    public static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int max = Integer.MIN_VALUE;
        long sum=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>max) max = arr[i];
            sum+=arr[i];
        }
        long low = max ;
        long high = sum;
        while(low<=high){
            long mid = low  + (high - low )/2;
            int Student=CountPage(arr,mid);
            if(Student>k) low = mid +1;
            else high = mid - 1;
        }
        return (int)low ;
    }
    public static void main(String[] args) {
        int[] arr = {25, 46,28,49, 24};
        int k =4;
        System.out.println(findPages(arr,k));
    }
}
