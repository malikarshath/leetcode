class Solution {
    public int calculate(String s) {

        Stack<String> st = new Stack<>();
        StringBuilder stb = new StringBuilder();
        int n = s.length();
        ArrayList<String> arr =  new ArrayList<>();

        String symbols = "+-*/";
        String fullsymbols = "+-*/()";

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            String str = String.valueOf(ch);
            if(ch == ' ') {
                continue;
            } else if(Character.isDigit(ch)) {
                stb.append(ch);
            } else {
                if(stb.length() > 0) {
                    arr.add(stb.toString());
                }
                stb.setLength(0);
                arr.add(str);
            }
        }

        if(stb.length() > 0) {
            arr.add(stb.toString());
        }
        stb.setLength(0);

        for(String currentStr : arr) {
            if(!fullsymbols.contains(currentStr)) {
                stOperation(st, currentStr, symbols, fullsymbols);
            } else {
                if(currentStr.equals(")")) {
                    String num = st.pop();
                    String open = st.pop();
                    stOperation(st, num, symbols, fullsymbols);
                } else {
                    st.add(currentStr);
                }
            }
        }

        if(st.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(st.pop());
    }

    public int operation(int num1, String symbol, int num2) {
        if(symbol.equals("+")) {
            return num1 + num2;
        } else if(symbol.equals("-")) {
            return num1 - num2;
        } else if(symbol.equals("*")) {
            return num1 * num2;
        } else if(symbol.equals("/")) {
            return num1 / num2;
        }
        return 0;
    }

    public void stOperation(Stack<String> st, String currentStr, String symbols, String fullsymbols) {
        if(st.isEmpty()) {
            st.add(currentStr);
        } else {
            if(!fullsymbols.contains(st.peek())) { // previous string is number
                String newstr = st.pop() + currentStr;
                st.add(newstr);
            } else { // previous string is symbol
                String str = st.pop();
                if(st.isEmpty()) { // only one symbol is available
                    if(str.equals("-")) {
                        st.add(String.valueOf(Integer.valueOf(currentStr) * -1));
                    } else {
                        st.add(str);
                        st.add(currentStr);
                    }
                } else {
                    if(symbols.contains(str)) { // if it is operator
                        if(!fullsymbols.contains(st.peek())) { // previous to that is a number
                            int num1 = Integer.valueOf(st.pop());
                            int result = operation(num1, str, Integer.valueOf(currentStr));
                            st.add(String.valueOf(result));
                        } else if(str.equals("-")) { // current is a operator and previous to that is not a number
                            st.add(String.valueOf(Integer.valueOf(currentStr) * -1));
                        } 
                    } else { // if it is bracket
                        if(str.equals("(") || str.equals(")")) {
                            st.add(str);
                            st.add(currentStr);
                        }
                    }
                }
            }
        }
    }
}