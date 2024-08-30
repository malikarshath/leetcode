class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> st = new HashSet<>();
        int n = s.length();
        int i = 0;
        int j = 0;

        int finalAns = 0;

        while(j < n) {
            char ich = s.charAt(i);
            char jch = s.charAt(j);
            if(st.contains(jch)) {
                st.remove(ich);
                i++;
            } else {
                st.add(jch);
                finalAns = Math.max(finalAns, j - i + 1);
                j++;
            }
        }

        return finalAns;
        
    }
}