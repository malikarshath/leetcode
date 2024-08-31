class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;

        if(nums.length == 1) {
            return true;
        }

        int start = 0;

        while(start < n) {
            int currJump = nums[start];

            if(start + currJump >= n - 1) {
                return true;
            }

            if(currJump == 0) {
                return false;
            }

            int maxJump  = 0;
            int idx = -1;

            for(int i = start + 1; i <= start + currJump; i++) {
                if(i + nums[i] > maxJump) {
                    maxJump = i + nums[i];
                    idx = i;
                }
            }

            start = idx;
        }


        return true;
        
    }
}