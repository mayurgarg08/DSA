class Solution {
    public boolean parseBoolExpr(String exp) {
       Stack<Character> stk = new Stack<>();

       for(char ch : exp.toCharArray()) {
          if(ch == ',') continue;
           
          if(ch != ')') {
            stk.push(ch);
          } else {

            int t = 0, f = 0;
            while(stk.peek() != '(') {
                char c = stk.pop();
                if(c == 't') t++;
                else f++;
            }

            stk.pop();
            char op = stk.pop();
            char res;
            if(op == '&') {
                res = (f == 0)? 't' : 'f';
            } else if(op == '|') {
                res = (t > 0)? 't' : 'f';
            } else {
                res = (t == 1) ? 'f' : 't';
            }

            stk.push(res);
          }
       }
       return stk.peek() == 't';
    }
}