class Solution {
    public int minInsertions(String s) {
        
        Stack<Character> st = new Stack<>();

        int insertionCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                if(!st.isEmpty() && st.peek() == ')') {
                    st.pop();
                    st.pop();
                    insertionCount++;
                }  
                st.add(ch);
            } else {
                if(st.isEmpty()) {
                    st.add('(');
                    insertionCount++;
                }
                if(st.peek() == ')') {
                    st.pop();
                    if(!st.isEmpty()) {
                        st.pop();
                    }
                } else {
                    st.add(ch);
                }
            }
        }
        while(!st.isEmpty()) {
            char ch = st.pop();
            if(ch == '(') {
                insertionCount += 2;
            } else {
                insertionCount++;
                st.pop();
            }
        }


        return insertionCount; // 
    }
}