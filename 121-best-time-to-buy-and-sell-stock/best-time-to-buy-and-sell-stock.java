class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int profit = 0;

        int buy = -1;
        int sell = -1;

        for(int i = 0; i < n; i++) {
            if(i + 1 < n) {
                if(prices[i] < prices[i + 1] && (buy == -1 || prices[i] < prices[buy])) {
                    buy = i;
                } else if(buy != -1 && prices[i] > prices[i + 1]) {
                    sell = i; 
                    profit = Math.max(profit,prices[sell] - prices[buy]); // 7 2 5 1 8 4
                }
            } else {
                if(buy != -1 && prices[buy] < prices[i]) {
                    sell = i;
                    profit = Math.max(profit,prices[sell] - prices[buy]);
                }
            }
        }

        return profit;
    }
}