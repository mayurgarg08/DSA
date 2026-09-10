class Solution {
    private void generate(int n, String curr, int open, int close, List<String> result) {
        if(curr.length() == 2*n) {
            result.add(curr);
            return;
        }
        
        if(open < n) generate(n, curr + "(", open+1, close, result);
        if(close < open) generate(n, curr + ")", open, close+1, result);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, "", 0, 0, ans);
        return ans;
    }
}