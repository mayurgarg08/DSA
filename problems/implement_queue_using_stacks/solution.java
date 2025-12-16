class MyQueue {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public MyQueue() {
    }
    
    public void push(int x) {
         while(!stk.empty()) {
            stk2.push(stk.pop());
        }
        stk.push(x);
        while(!stk2.empty()) {
            stk.push(stk2.pop());
        }
    }
    
    public int pop() {
        return stk.pop();
    }
    
    public int peek() {
        return stk.peek();
    }
    
    public boolean empty() {
        return stk.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */