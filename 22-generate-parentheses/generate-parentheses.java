class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        gen(n, n, "",ans);

        return ans;
    }

    public void gen(int open, int close, String str, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }
        if(open > 0) {
            gen(open - 1 , close, str + "(", ans);
        }
        if(close > open) {
            gen(open, close - 1, str + ")", ans);
        }
    }
}