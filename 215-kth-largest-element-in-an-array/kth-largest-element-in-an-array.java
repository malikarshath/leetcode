class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            min.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > min.peek()) {
                min.poll();
                min.add(nums[i]);
            }
        }

        return min.peek();
    }
}