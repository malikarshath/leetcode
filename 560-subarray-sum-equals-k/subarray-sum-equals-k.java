class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pf = prefixSum(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int count = 0;
        freq.put(0 , 1);
        for(int i = 0; i < n; i++) {
            int target = pf[i] - k;
            if(freq.containsKey(target)) {
                count += freq.get(target);
            }
            freq.put(pf[i], freq.getOrDefault(pf[i], 0) + 1);
        }
        return count;
    }

    public int[] prefixSum(int[] nums) {
        int n = nums.length;
        int[] pf = new int[n];
        pf[0] = nums[0];

        for(int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + nums[i];
        }

        return pf;
    }
}