class Solution {
    public boolean isPalindrome(String s) {

        ArrayList<Character> arr = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                arr.add((char)(ch+32));
            } else if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                arr.add(ch);
            }
        }

        int l = 0;
        int m = arr.size() - 1;

        while(l < m) {
            if(arr.get(l) != arr.get(m)) {
                return false;
            }
            l++;
            m--;
        }

        return true;
        
    }
}