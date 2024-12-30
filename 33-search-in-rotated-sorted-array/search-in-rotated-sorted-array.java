class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        
        while(s <= e) {
            int m = (e - s)/ 2 + s;
            if(nums[m] ==  target) {
                return m;
            }
            if(target < nums[0]) { // target part 2
                if(nums[m] >= nums[0]) { // mid in part 1
                    s = m + 1;
                } else { // mid and target in part 2
                    if(target >= nums[m]) {
                        s = m + 1;
                    } else {
                        e = m - 1;
                    }
                }
            } else { // target part 1
                if(nums[m] < nums[0]) { // mid in part 2
                    e = m - 1;
                } else { // mid and target in part 1
                    if(target >= nums[m]) {
                        s = m + 1;
                    } else {
                        e = m - 1;
                    }
                }
            }
        }

        return -1;

    }
}