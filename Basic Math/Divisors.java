import java.util.ArrayList;
import java.util.List;

public class Divisors {
    // public static void main(String[] args) {
    //     int n =36;
    //     int num=n;
    //     while(num>0){
    //         if(n%num == 0){
    //             System.out.print(num+" ");
    //         }
    //         num--;

    //     }
        
    // }
    public static void main(String[] args) {
        int n=36;
        List<Integer> res = new ArrayList<>();
        for(int i =1;i*i<=n;i++){
            if(n%i == 0){
                res.add(i);
                if(n/i != i){
                    res.add(n/i);
                }
            }
        }
        res.sort(null);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
