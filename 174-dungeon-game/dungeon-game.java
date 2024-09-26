class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) {
                    int x = 1 - dungeon[i][j];
                    dp[i][j] = x <= 0 ? 1 : x;
                } else if(i == n - 1) {
                    int x = dp[i][j + 1] - dungeon[i][j];
                    dp[i][j] = x <= 0 ? 1 : x;
                } else if(j == m -1) {
                    int x = dp[i + 1][j] - dungeon[i][j];
                    dp[i][j] = x <= 0 ? 1 : x;
                } else {
                    int right = dp[i][j + 1] - dungeon[i][j];
                    int bottom = dp[i + 1][j] - dungeon[i][j];
                    int x = Math.min(right, bottom);
                    dp[i][j] = x <= 0 ? 1 : x;
                }
            }
        }

        return dp[0][0];
        
    }
}