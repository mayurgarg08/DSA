class Solution {
    public int maxDepth(String s) {
        int maxDep = 0;
        int depth = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                depth++;
                maxDep = Math.max(maxDep, depth);
            } else if(c == ')') {
                depth--;
            } else {
                continue;
            }
        } 
        return maxDep;
    }
}