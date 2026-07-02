class Solution {
    private int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        Arrays.fill(prev, 0);
        for(int idx1 = 1; idx1 <= n; idx1++) {
            int[] curr = new int[m+1];
            for(int idx2 = 1; idx2 <= m; idx2++) {
                if(s.charAt(idx1-1) == t.charAt(idx2-1)) curr[idx2] = 1 + prev[idx2 - 1];
                else curr[idx2] = Math.max(prev[idx2], curr[idx2-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
    private String reverse(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }
    private int lps(String s) {
        String t = reverse(s);
        return lcs(s, t);
    }
    public int minInsertions(String s) {
        int n = s.length();
        return n - lps(s);
    }
}