class Solution {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        //return check(coins, amount);

        if(amount < 1) {
            return 0;
        }

        int n = coins.length;

        long[] dp = new long[amount + 1];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            long max = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(i - coins[j] >= 0) {
                    max = Math.min(max, dp[i - coins[j]]);
                }
            }
            dp[i] =  max + 1;
        }

        return dp[amount] >= Integer.MAX_VALUE ? -1 : (int)dp[amount];

        //return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int check(int[] coins, int amount) {

        if(amount <= 0) {
            return 0;
            //min = Math.min(min, count);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            ans = Math.min(ans, check(coins, amount - coins[i]));
        }

        return ans + 1;
    }
}