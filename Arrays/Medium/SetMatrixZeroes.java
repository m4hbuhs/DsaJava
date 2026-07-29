public class SetMatrixZeroes {

    static void markRow(int[][] matrix, int row) {
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            if (matrix[row][j] != 0)
                matrix[row][j] = -1;
        }
    }

    static void markCol(int[][] matrix, int col) {
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    static void brute(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    markRow(matrix, i);
                    markCol(matrix, j);

                }
            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;

            }
        }
    }
    static void better(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] row = new int[rows];
        int[] col = new int[cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    row[i] = 1;
                    col[j] = 1;

                }
            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;

            }
        }
    }
    static void optimal(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1;
        // Step 1 : Mark rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        // Step 2 : Fill remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // Step 3 : First row
        if (matrix[0][0] == 0) {

            for (int j = 0; j < cols; j++)
                matrix[0][j] = 0;
        }
        // Step 4 : First column
        if (col0 == 0) {
        for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;

        }
    }

        public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {1, 1, 1, 1}
        };

        optimal(matrix);   // or brute(matrix) / better(matrix)

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}