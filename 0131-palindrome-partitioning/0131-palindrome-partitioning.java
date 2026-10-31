class Solution {
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void helper(int idx, String s, List<String> curr, List<List<String>> ans) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(s.substring(idx, i+1))) {
                curr.add(s.substring(idx, i+1));
                helper(i+1, s, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }
}