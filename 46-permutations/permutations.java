class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Integer[] smallAns = new Integer[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        gen(nums, 0, visited, smallAns, ans);

        return ans;
    }

    public void gen(int[] nums, int idx, boolean[] visited,Integer[] smallAns, List<List<Integer>> ans ) {

        if(idx == nums.length) {
            ans.add(new ArrayList<>(Arrays.asList(smallAns)));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                smallAns[idx] = nums[i];
                gen(nums, idx + 1, visited, smallAns, ans);
                visited[i] = false;
            }
        }
    }
}