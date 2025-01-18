class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        String minLengthString = " ";
        int minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            if(strs[i].length() < minLength) {
                minLengthString = strs[i];
                minLength = strs[i].length();
            }
        }

        for(int i = 0; i < minLengthString.length(); i++) {
            char curr = minLengthString.charAt(i);

            for(int j = 0; j < strs.length; j++) {
                if(curr != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(curr);
        }

        return sb.toString();
    }
}