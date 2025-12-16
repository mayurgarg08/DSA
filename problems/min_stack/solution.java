
class MinStack {
    private Stack<Long> st;   
    private long mini;        

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            mini = val;
            st.push((long) val);
        } else if (val >= mini) {
            st.push((long) val);
        } else {
            st.push(2L * val - mini);
            mini = val;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long x = st.pop();
        if (x < mini) {
            mini = 2 * mini - x;
        }
    }
    
    public int top() {
        if (st.isEmpty()) return -1;

        long x = st.peek();
        return (x >= mini) ? (int) x : (int) mini;
    }
    
    public int getMin() {
        return (int) mini;
    }
}
