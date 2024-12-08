class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        gen(nums, 0, smallAns, ans);
        return ans;
        
    }

    public void gen(int[] nums, int idx, List<Integer> smallAns, List<List<Integer>> ans) {

        if(idx == nums.length) {
            ans.add(new ArrayList<>(smallAns));
            return;
        }

        smallAns.add(nums[idx]);

        gen(nums, idx + 1, smallAns, ans);

        smallAns.remove(smallAns.size() - 1);

        gen(nums, idx + 1, smallAns, ans);


    }
}