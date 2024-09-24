class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int el : nums) {
            xor ^= el;
        }

        // ones complement

        int[] ans = new int[2];

        int ones = ~xor + 1;
        int rsb = xor & ones;

        for(int el : nums) {
            if((el & rsb) != 0) {
                ans[0] ^= el;
            } else {
                ans[1] ^= el;
            }
        }

        return ans;
    }
}