class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        
        String[] parts = path.split("/");
        
        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue;
            }
            else if(part.equals("..")) {
                if(!stk.isEmpty()) stk.pop();
            }
            else {
                stk.push(part);
            }
        }

        StringBuilder res = new StringBuilder();
        
        for(String dir : stk) {
            res.append("/").append(dir);
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}