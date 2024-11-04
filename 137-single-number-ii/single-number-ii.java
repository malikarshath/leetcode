class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i = 31; i >= 0; i--) {
            int countSetBits = 0;
            for(int num : nums) {
                if((num & 1<<i) != 0) {
                    countSetBits++;
                }

            }
            if(countSetBits % 3 != 0) {
                ans = ans | 1<<i;
            }
        }

        return ans;
        
    }
}