class Solution {
    private StringBuilder helper(StringBuilder ans) {
        StringBuilder temp = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= ans.length(); i++) {
            if (i < ans.length() && ans.charAt(i) == ans.charAt(i - 1)) {
                count++;
            } 
            else {
                temp.append(count);
                temp.append(ans.charAt(i - 1));
                count = 1;
            }
        }
        return temp;
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder ans = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            ans = helper(ans);
        }
        return ans.toString();
    }
}