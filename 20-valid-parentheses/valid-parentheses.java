class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {

            if(ch == '(' || ch == '{' || ch == '[') {
                st.add(ch);
            } else {
                if(st.isEmpty()) {
                    return false;
                }

                char stCh = st.pop();
                if(!check(stCh, ch)) {
                    return false;
                }

            }
        }

        if(st.size() > 0) {
            return false;
        }

        return true;
    }
        
    public boolean check(char stCh, char ch) {

        if((stCh == '(' && ch == ')') ||
           (stCh == '{' && ch == '}') ||
           (stCh == '[' && ch == ']')) {
            return true;
        }

        return false;

    }
}
