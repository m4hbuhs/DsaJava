import java.util.ArrayList;
import java.util.HashSet;

public class moveZeros { 
    private static void brute(int[] arr){
     ArrayList<Integer> temp = new ArrayList<>();

        for(int num : arr){
            if(num != 0)
                temp.add(num);
        }

        int k = 0;

        for(int num : temp)
            arr[k++] = num;

        while(k < arr.length)
            arr[k++] = 0;

    }
    private static void optimal(int[] arr){
        int j=-1;
        for(int i =0;i<=arr.length-1;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j == -1) return;//if no zeros it wont go out of the bounds
        for(int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
        }

    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr={1,2,0,0,2,0,0,4,0,5,0,6,0};
        optimal(arr);
        // brute(arr);
        for(int a: arr){
            System.out.print(a+" ");
        }
    }

    
}