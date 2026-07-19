public class Pattern17 {
    public static void main(String[] args) {
        int n =5;
        
        for(int i =0;i<n;i++){
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Initialize character to start from 'A'
            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;

            // Print characters in row
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);

                // Increment or decrement character
                if (j <= breakpoint) ch++;
                else ch--;
            }

            // Print trailing spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
}
