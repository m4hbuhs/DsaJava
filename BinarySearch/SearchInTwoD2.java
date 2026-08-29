public class SearchInTwoD2 {
    public static boolean searchElement(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;

    int row = 0;
    int col = m - 1;

    while (row < n && col >= 0) {

        if (mat[row][col] == target) {
            return true;
        } 
        else if (mat[row][col] < target) {
            row++;
        } 
        else {
            col--;
        }
    }

    return false;
}
    public static void main(String[] args) {
        int[][] mat = {
        {1, 4, 7, 11},
        {2, 5, 8, 12},
        {3, 6, 9, 16},
        {10, 13, 14, 17}
    };

    int target = 9;

     boolean result = searchElement(mat, target);

    System.out.println(result);
    }
}
