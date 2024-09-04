class MinStack {

    Stack<Pair> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.add(new Pair(val, min));
        
    }
    
    public void pop() {
        st.pop();
        if(st.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = getMin();
        }
        
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }

    class Pair {
        int val, min;

        Pair(int v, int m) {
            this.val = v;
            this.min = m;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */