class Solution {
    List<List<Integer>> finalAns;
    public List<List<Integer>> combine(int n, int k) {
        finalAns = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            li.add(i);
        }
        List<Integer> curr = new ArrayList<>();

        combine(li, k, 0, curr);

        return finalAns;
    }

    public void combine(List<Integer> li, int k, int start, List<Integer> curr) {
        if(k == 0) {
            finalAns.add(new ArrayList<>(curr));
            return;
        }
        k--;

        for(int i = start; i < li.size(); i++) {
            curr.add(li.get(i));
            combine(li, k, i + 1, curr);
            curr.remove(curr.size() - 1);
        }


    }
}