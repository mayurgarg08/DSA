class Solution {
      private int lcs(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        for(int idx1 = 1; idx1 <= n; idx1++) {
            int[] curr = new int[m+1];
            for(int idx2 = 1; idx2 <= m; idx2++) {
                
                 if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) {
                     curr[idx2] = 1 + prev[idx2-1];
                 }
                 else curr[idx2] = Math.max(0 + prev[idx2], 0 + curr[idx2-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int lcsLength = lcs(word1, word2);
        return n + m - (2*lcsLength);   
    }
}