public class MaxProductSubarray {
    private static int brute(int[] arr){
        int n =arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                int product=1;
                for(int k=i;k<j;k++){
                    product*=arr[k];
                }
                max=Math.max(max, product);
            }
        }
        return max;
    }
    private static int better(int[] arr){
        int n =arr.length;
        int max=Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product*=arr[j];
                 max=Math.max(max, product);
            }
        }
        return max;
    }
    private static int optimal(int[] arr){
        int n =arr.length;
        int max=Integer.MIN_VALUE,prefix=1,suffix=1;
        for(int i =0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;

            prefix*=arr[i];
            suffix*=arr[n-i-1];
            max=Math.max(max, Math.max(prefix,suffix));
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr ={2,3,-2,4};
        System.out.println(optimal(arr));
    }
}
