class Solution {
    public String decodeString(String s) {
       Stack<Character> stack = new Stack<>();
       for(char ch: s.toCharArray()) {
        if(ch == ']') {
            StringBuilder decoded = new StringBuilder();
            while(stack.peek() != '[') {
                decoded.insert(0, stack.pop());
            }
            stack.pop();

            StringBuilder num = new StringBuilder();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                num.insert(0, stack.pop());
            }
            int count = Integer.parseInt(num.toString());
            String repeated = decoded.toString().repeat(count);

            for(char c: repeated.toCharArray()) {
                stack.push(c);
            }

        } else {
            stack.push(ch);
        }
       }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}