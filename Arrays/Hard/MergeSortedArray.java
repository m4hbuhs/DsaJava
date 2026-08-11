import java.util.Arrays;

public class MergeSortedArray {
    private static void brute(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int[] arr=new int[m+n];
        int left=0,right=0,index=0;
        while(left<m && right<n){
           if (arr1[left] <= arr2[right]) {
                arr[index++] = arr1[left++];
            } else {
                arr[index++] = arr2[right++];
            }
        }
        while(left<m){
            arr[index++]=arr1[left++];
        }
        while(right<n){
            arr[index++]=arr2[right++];
        }
          for (int i = 0; i < m; i++) {
            arr1[i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = arr[m + i];
        }
    }
    public static void better(int[] arr1, int[] arr2) {
        int m=arr1.length;
        int n=arr2.length;

        int left = m - 1;
        int right = 0;

        while (left >= 0 && right < n) {

            if (arr1[left] > arr2[right]) {

                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--;
                right++;
            } 
            else {
                break;
            }
        }

        Arrays.sort(arr1);

        Arrays.sort(arr2);
    }
    private void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public void optimal(int[] arr1, int[] arr2) {
        int m=arr1.length;
        int n=arr2.length;
        int len = n + m;

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < len) {

                // arr1 and arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }

                // arr2 and arr2
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }

                // arr1 and arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }

                left++;
                right++;
            }

            // If gap is 1, we're done
            if (gap == 1) {
                break;
            }

            // Reduce gap
            gap = (gap / 2) + (gap % 2);
        }
    }


    public static void main(String[] args) {
        int[] arr1={1,2,3,4,6,7};
        int[] arr2={5,8,9,10};
    //     brute(arr1, arr2);
    //     System.out.print("arr1: ");
    //     for (int x : arr1) {
    //         System.out.print(x + " ");
    //     }

    //     System.out.print("\narr2: ");
    //     for (int x : arr2) {
    //         System.out.print(x + " ");
    // }
    better(arr1,arr2);
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    
    }
}
