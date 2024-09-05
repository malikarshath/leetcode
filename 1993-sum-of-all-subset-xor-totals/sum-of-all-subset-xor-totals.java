class Solution {
    int finalSum = 0;
    public int subsetXORSum(int[] nums) {
        finalSum = 0;
        int sum = 0;
        
        gen(nums, 0, sum);
        
        return finalSum;
    }

    public void gen(int[] nums, int idx, int sum) {

        if(idx == nums.length) {
            finalSum += sum;
            return;
        }


        sum ^= nums[idx];
        gen(nums, idx + 1, sum);

        sum ^= nums[idx];
        gen(nums, idx + 1, sum);

    }
}