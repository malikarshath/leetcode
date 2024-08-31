class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int start = 0;
        int jump = 0;

        if(n == 1) {
            return 0;
        }

        while(start < n) {
            int currJump = nums[start];

            if(currJump + start >= n - 1) {
                return jump + 1;
            }

            if(currJump == 0) {
                // will not move forward   
            }

            int maxJump = 0;
            int idx = -1;

            for(int i = start + 1; i <= start + currJump; i++) {
                if(nums[i] + i > maxJump) {
                    maxJump = nums[i] + i;
                    idx = i;
                }
            }

            start = idx;
            jump++;
        }

        return jump;
        
    }
}