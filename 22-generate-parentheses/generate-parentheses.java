class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, n, "", ans);
        return ans;
    }

    public void generate(int open , int close, String str, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }

        if(close > open) {
            generate(open, close - 1, str+")", ans);
        }

        if(open > 0) {
            generate(open - 1, close, str+"(", ans);
        }
    }
}