class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int depth = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                depth++;
                stk.push(ch);
            } else {
                if(ch == ')') {
                    if(stk.isEmpty() || stk.pop() != '(') return false;
                    depth--; 
                } else if(ch == ']') {
                    if(stk.isEmpty() || stk.pop() != '[') return false;
                    depth--;
                } else {
                    if(stk.isEmpty() || stk.pop() != '{') return false;
                    depth--;
                }
            }
        }
        return depth == 0;
    }
}