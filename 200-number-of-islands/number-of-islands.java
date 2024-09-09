class Solution {
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int islands = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int i, int j, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        grid[i][j] = '0';

        for(int k = 0; k < 4; k++) {
            int row = i + rows[k];
            int col = j + cols[k];

            if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1') {
                dfs(row, col, grid);
            }
        }
    }
}