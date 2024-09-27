class Solution {
    public List<String> letterCombinations(String digits) {
        
        Map<Character, String> po = new HashMap<>();

        po.put('1',"");
        po.put('2',"abc");
        po.put('3',"def");
        po.put('4',"ghi");
        po.put('5',"jkl");
        po.put('6',"mno");
        po.put('7',"pqrs");
        po.put('8',"tuv");
        po.put('9',"wxyz");

        List<String> finalAns = new ArrayList<>();
        char[] ans = new char[digits.length()];
 
        gen(ans, 0, finalAns, digits, po);

        return finalAns;
    }

    public void gen(char[] ans, int idx, List<String> finalAns, String digits, Map<Character, String> po) {
        if(idx == digits.length()) {
            String finalStr = new String(ans);
            if(!finalStr.isEmpty()) {
                finalAns.add(finalStr);
            }
            return;
        }
        String str = po.get(digits.charAt(idx));

        for(int i = 0; i < str.length(); i++) {
            ans[idx] = str.charAt(i);
            gen(ans, idx + 1, finalAns, digits, po);
        }
    }
}