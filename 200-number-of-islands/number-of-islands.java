class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int island = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    island++;
                    dfs(i , j, grid);
                }
            }
        }

        return island;
    }

    public void dfs(int i , int j, char[][] grid) {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return;
        if(grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(i, j + 1, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);
    }
}