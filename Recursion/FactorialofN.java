import java.util.Scanner;

class Solution{
    int Factorial(int n){
        if(n == 0) return 1;
        return n*Factorial(n-1);

    }

}
class FactorialofN{
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a number to find its factorial :");
        int a=sc.nextInt();
        int res = obj.Factorial(a);
        System.out.printf("The factorial of %d is %d",a,res);
        sc.close();
    }
}