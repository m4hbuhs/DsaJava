public class Pattern15 {
    public static void main(String[] args) {
        // int A = 65;
        int n =5;
        // char newChar = (char) A;
        for(int i =0;i<n;i++){
             for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
            System.out.print(ch +" ");;  // Print the current character followed by a space
        }
            // for(int j =i;j<n;j++){
            //     System.out.print((char)(newChar +j));
            // }
            System.out.println();
        }
    }
    
}
// ABCDE
// BCDE
// CDE
// DE
// E