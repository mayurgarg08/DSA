class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int max = 0;
        int count = 0;
        int maxFreq = 0;
        int[] hash = new int[26];
        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            hash[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right)-'A']);
            if((right-left+1) - maxFreq > k) {
                hash[s.charAt(left)-'A']--;
                left++;
            }
            max = Math.max(max, (right-left+1));
        }
        return max;
    }
}