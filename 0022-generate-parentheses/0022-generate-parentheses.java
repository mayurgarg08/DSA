class Solution {
    private void generate(int n, String curr, int open, int close, List<String> ans) {
        if(curr.length() == 2*n) {
            ans.add(curr);
            return;
        }
        if(open < n) generate(n, curr + "(", open+1, close, ans);
        if(close < open) generate(n, curr + ")", open, close+1, ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, "", 0, 0, ans);
        return ans;
    }
}