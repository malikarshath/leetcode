class Solution {
    List<List<Integer>> finalAns;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        finalAns = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, target, li, 0);
        return finalAns;
    }

    public void sum(int[] candidates, int target, List<Integer> li, int start) {
        if(target == 0) {
            List<Integer> ans = new ArrayList<>(li);
            finalAns.add(ans);
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            li.add(candidates[i]);
            sum(candidates, target - candidates[i], li, i);
            li.remove(li.size() - 1);
        }
    }
}