class Solution {
    public int findMin(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int j = nums.length - 1;

        int ans = Integer.MAX_VALUE;

        while(i < j) {
            if(nums[i] < nums[j]) { // Array is sorted return the min
                return nums[i];
            }

            int mid = (i + j) / 2;

            ans = Math.min(ans, nums[j]);

            if(nums[i] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return ans;
        
    }
}