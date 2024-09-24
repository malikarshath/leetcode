class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;

        while(i < n) {
            if(nums[i] > 0 && nums[i] <= n) {
                int idx = nums[i] - 1;
                if(nums[i] != nums[idx]) {
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for(int j = 0; j < n; j++) {
            if(j + 1 != nums[j]) {
                return j + 1;
            }
        }
        
        return n + 1;
        
    }
}