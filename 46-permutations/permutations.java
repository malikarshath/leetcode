class Solution {
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;

        int[] visited = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sa = new ArrayList<>(Collections.nCopies(n, 0));

        gen(0, nums, visited, ans, sa);

        return ans;
        
    }

    public void gen(int idx, int[] nums, int[] visited, List<List<Integer>> ans, List<Integer> sa) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(sa));
        }

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                sa.set(idx, nums[i]);
                gen(idx + 1, nums, visited, ans, sa);
                visited[i] = 0;
            }
        }

    }
}