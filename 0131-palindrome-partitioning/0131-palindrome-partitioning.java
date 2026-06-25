class Solution {
    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low <= high) {
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
    private void helper(int idx, String s, int n, List<String> curr, List<List<String>> ans) {
        if(idx == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < n; i++) {
            if(isPalindrome(s.substring(idx, i+1))) {
                curr.add(s.substring(idx, i+1));
                helper(i+1, s, n, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, n, new ArrayList<>(), ans);
        return ans;
    }
}