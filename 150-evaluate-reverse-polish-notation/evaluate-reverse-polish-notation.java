class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> st = new Stack<>();
        
        for(String str : tokens) {
            if(str.equals("+") || str.equals("-") || str.equals("*")  || str.equals("/")) {
                if(!st.isEmpty()) {
                    int num1 = Integer.valueOf(st.pop());
                    if(!st.isEmpty()) {
                        int num2 = Integer.valueOf(st.pop());

                        st.add(String.valueOf(doOperation(num1, num2, str)));
                    }
                }
            } else {
                st.add(str);
            }
        }

        if(!st.isEmpty()) {
            return Integer.valueOf(st.pop());
        }

        return 0;
    }

    public int doOperation(int num1, int num2, String str) {
        if(str.equals("+")){
            return num2 + num1;
        } else if(str.equals("-")) {
            return num2 - num1;
        } else if(str.equals("*")) {
            return num2 * num1;
        }  else if(str.equals("/")) {
            return num2 / num1;
        }
        return 0;
    }
}