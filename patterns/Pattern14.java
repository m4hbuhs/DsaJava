public class Pattern14 {
    public static void main(String[] args) {
        
        int n =5;
                // Outer loop for the number of rows
        for (int i = 0; i < n; i++) {
            
            // Inner loop to print alphabets from A to A + i
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");  // Print the character followed by a space
            }

            // Move to the next line after printing the current row
            System.out.println();

        // int A = 65;
        // char newChar = (char) A;
        // for(int i =1;i<=n;i++){
        //     for(int j =0;j<i;j++){
        //         System.out.print((char)(newChar +j));
        //     }
        //     System.out.println();
        }
    }
    
}
// A
// AB
// ABC
// ABCD
// ABCDE