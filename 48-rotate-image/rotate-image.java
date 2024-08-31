class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 1 2 3
        // 4 5 6
        // 7 8 9

        // 1 4 7
        // 2 5 8
        // 3 6 9

        // 7 4 1
        // 8 5 2
        // 9 6 3

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int j = 0; j < m / 2; j++) {
            for(int i = 0; i < n; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = temp;
            }
        }
        
    }
}