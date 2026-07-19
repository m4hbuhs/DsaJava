import java.util.Scanner;

class Solution{
    void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    void reverse(int i,int arr[],int n){
        if(i>=n/2) return;
        swap(arr,i,n-i-1);
        reverse(i+1, arr, n);
    }
}
public class Reversearr {
    public static void main(String[] args) {
        
    
    Solution obj =new Solution();
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int[] arr= new int[n];
    for(int i =0;i<n;i++){
        arr[i]=sc.nextInt();
        
    }
    obj.reverse(0,arr,n);
    for(int j =0;j<n;j++){
        System.out.print(arr[j]+" ");
    }
    sc.close();
}

}


