class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        int[][] queen = new int[n][n];
        placequeens(0, n, queen);

        return count;
    }

    public void placequeens(int row, int n, int[][] queen) {
        if(row == n) {
            count++;
            return;
        }

        for(int col = 0; col < n; col++) {
            if(noqueen(row, col, queen)) {
                queen[row][col] = 1;
                placequeens(row + 1, n, queen);
                queen[row][col] = 0;
            }
        }

    }

    public boolean noqueen(int row, int col, int[][] queen) {
        int n = queen.length;

        for(int i = 0; i < n; i++) {
            if(queen[i][col] == 1) {
                return false;
            }
        }

        int i = row;
        int j = col;

        while(i >= 0 && j >= 0) { // top left
            if(queen[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while(i < n && j < n) { // bottom right
            if(queen[i][j] == 1) {
                return false;
            }
            i++;
            j++;
        }

        i = row;
        j = col;

        while(i >= 0 && j < n) { // top right
            if(queen[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        i = row;
        j = col;

        while(i < n && j >= 0) { // bootom left
            if(queen[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}