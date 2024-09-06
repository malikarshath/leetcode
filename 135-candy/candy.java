class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int ans = 0;

        for(int num : candies) {
            ans += num;
        }

        return ans;

        // 1 0 2
        // 1 1 1
        // 1 1 2
        // 2 1 2
        
    }
}