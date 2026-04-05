class Solution {
    private boolean isPalindrome(int i, int j, String str) {
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private void helper(int i, int n, String s,  List<String> temp,List<List<String>> ans) {
        if(i == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < n; j++) {
            if(isPalindrome(i, j, s)) {
                temp.add(s.substring(i, j + 1));
                helper(j+1, n, s, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        helper(0, n, s, new ArrayList<>(), ans);   
        return ans;
    }
}