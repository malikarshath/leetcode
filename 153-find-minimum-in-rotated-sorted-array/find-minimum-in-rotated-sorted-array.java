class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        int ans = 0;

        while(s <= e) {
            int mid = ((e - s) / 2 ) + s;

            if(nums[0] <= nums[mid]) { 
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }

        return nums[ans];
    }
}