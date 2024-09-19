class Solution {
    public int findMin(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int s = 0;
        int e = nums.length - 1;

        int ans = 0;

        while(s <= e) {
           int m = (e - s) / 2 + s;

           if(nums[m] >= nums[0]) {
                s = m + 1;
           } else {
                ans = m;
                e = m - 1;
           }
        }

        return nums[ans];
        
    }
}