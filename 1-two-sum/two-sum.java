class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int t1 = target - nums[i];

            if(mp.containsKey(t1)) {
                return new int[]{mp.get(t1), i};
            }
            mp.put(nums[i], i);
        }

        return new int[0];
        
    }
}