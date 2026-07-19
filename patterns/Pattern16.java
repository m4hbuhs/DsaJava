public class Pattern16{
    public static void main(String[] args) {
        int A = 65;
        int n =5;
        char newChar = (char) A;
        for(int i =0;i<n;i++){
            for(int j =0;j<=i;j++){
                System.out.print((char)(newChar +i));
            }
            System.out.println();
        }
    }
    
}
// A
// BB
// CCC
// DDDD
// EEEEE