class Solution {
    public int removeDuplicates(int[] nums) {

        int max = Integer.MAX_VALUE;
        int n = nums.length;
        if(n <= 2) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while(j < n) {
            if(nums[i] == nums[j]) {
                if(j - i >=  2) {
                    nums[j] = 100000;
                }
            } else {
                i = j;
            }
            j++;
        }
        Arrays.sort(nums);

        int count = 0;

        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] != 100000) {
                count++;
            }
        }

        return count;
        
    }
}