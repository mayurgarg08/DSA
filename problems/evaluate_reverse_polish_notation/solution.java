class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stk = new Stack<>();
        StringBuilder exp = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String ch = tokens[i];
            if(!ch.equals("+") && !ch.equals("-") && 
   !ch.equals("*") && !ch.equals("/")) {
                stk.push(Integer.parseInt(ch));
            } else {
                int y = stk.pop();
                int x = stk.pop();
                if(ch.equals("+")) {
                    stk.push(x+y);
                } else if(ch.equals("-")) {
                    stk.push(x-y);
                } else if(ch.equals("*")) {
                    stk.push(x*y);
                } else {
                    stk.push(x/y);
                }
            }
        }
        return stk.pop();
    }
}