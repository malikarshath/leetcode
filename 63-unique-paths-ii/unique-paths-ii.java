class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1) return 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                if(obstacleGrid[i][j] == 0) {
                    continue;
                }
                if(i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    if(obstacleGrid[i][j - 1] == 0) {
                        obstacleGrid[i][j] = 0;
                    }
                }  else if(j == 0) {
                    if(obstacleGrid[i - 1][j] == 0) {
                        obstacleGrid[i][j] = 0;
                    }
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[n - 1][m - 1];

        
    }
}