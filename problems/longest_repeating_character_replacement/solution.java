class Solution {
    public int characterReplacement(String s, int k) {
        int hashLen = 26;
        int[] hash = new int[hashLen];
        Arrays.fill(hash, 0);
        int maxLen = 0, maxFreq = 0, l = 0, r = 0;
        while(r<s.length()) {
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);
            while((r - l + 1)-maxFreq > k) {
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, (r - l + 1));
            r++;
        }
        return maxLen;
    }
}