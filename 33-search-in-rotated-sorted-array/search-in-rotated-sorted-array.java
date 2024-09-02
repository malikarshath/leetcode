class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int s = 0;
        int e = n - 1;

        int ans = -1;

        while(s <= e) {
            int m = ((e - s) / 2) + s;

            if(nums[m] == target) {
                ans = m;
                break;
            }

            if(target >= nums[0]) { // t in 1
                if(nums[m] < nums[0]) { // m in 2
                    e = m - 1;
                } else { // m in 1
                    if(nums[m] > target) {
                        e = m - 1;
                    } else if(nums[m] < target) {
                        s = m + 1;
                    }
                }
            } else { // t in 2
                if(nums[m] >= nums[0]) { // m in 1
                    s = m + 1;
                } else { // m in 2
                    if(nums[m] > target) {
                        e = m - 1;
                    } else if(nums[m] < target) {
                        s = m + 1;
                    }
                }
            }
        }

        return ans;
        
    }
}