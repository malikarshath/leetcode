class Solution {
    List<List<Integer>> finalAns;
    Set<List<Integer>> finalSet;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        finalAns = new ArrayList<>();
        finalSet = new HashSet<>();
        List<Integer> li = new ArrayList<>();
        sum(candidates, target, li);
        return finalAns;
    }

    public void sum(int[] candidates, int target, List<Integer> li) {
        if(target == 0) {
            List<Integer> ans = new ArrayList<>(li);
            Collections.sort(ans);
            if(!finalSet.contains(ans)) {
                finalAns.add(ans);
                finalSet.add(ans);
            }
            return;
        }
        if(target < 0) {
            return;
        }
        for(int can : candidates) {
            li.add(can);
            sum(candidates, target - can, li);
            li.remove(li.size() - 1);
        }
    }
}