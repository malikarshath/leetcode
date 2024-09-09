class Solution {
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int islands = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i,j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int i, int j, char[][] grid, int[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        visited[i][j] = 1;

        for(int k = 0; k < 4; k++) {
            int row = i + rows[k];
            int col = j + cols[k];

            if(row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0 && grid[row][col] == '1') {
                dfs(row, col, grid, visited);
            }
        }
    }
}