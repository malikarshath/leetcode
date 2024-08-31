class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int buy = -1;
        int sell = 0;
        int profit = 0;
        for(int i = 0; i < n; i++) {
            if(i + 1 < n) {
                if(buy == -1 && prices[i] < prices[i + 1]) {
                    buy = prices[i];
                } else if(buy != -1 && prices[i] > prices[i + 1] && buy < prices[i]) {
                    sell = prices[i];
                    profit += sell - buy;
                    buy = -1;
                }
            } else {
                if(buy != -1 && buy < prices[i]) {
                    sell = prices[i];
                    profit += sell - buy;
                    buy = -1;
                }
            }
        }

        return profit;
        
    }
}