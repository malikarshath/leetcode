class Solution {
    public int countKDifference(int[] nums, int k) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        int ansCount = 0;

        for(int i = 0; i < nums.length; i++) {
            int target = nums[i] + k;
            int target1 =  nums[i] - k; // A - B = C / A = C + B / B = A - C

            if(numsMap.containsKey(target)) {
                ansCount += numsMap.get(target);
            } 
            if(numsMap.containsKey(target1)) {
                ansCount += numsMap.get(target1);
            }

            if(numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], numsMap.get(nums[i])+1);
            } else {
                numsMap.put(nums[i], 1);
            }
        }

        return ansCount;
        
    }
}