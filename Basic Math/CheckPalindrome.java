public class CheckPalindrome {
    public static void main(String[] args) {
        int n = 123;
        int org=n;
        int Reverse=0;
        while(n>0){
            int ld = n%10;
            Reverse = (Reverse*10) +ld;
            n=n/10;
        }
        if(Reverse == org){
                System.out.println("it is palindrome");
            }
            else {
                System.err.println("its not a palindrome");
            }
    }
    
}
