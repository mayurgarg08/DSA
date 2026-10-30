class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int maxLen = 0;
       int[] hash = new int[256];
       Arrays.fill(hash, -1);
       int left = 0;
       int right = 0;
       while(left <= right && right < n) {
          if(hash[s.charAt(right)] != -1) {
            left = Math.max(left, hash[s.charAt(right)]+1);
          }
          int len = right-left+1;
          maxLen = Math.max(maxLen, len);
          hash[s.charAt(right)] = right;
          right++;
       }
       return maxLen;
    }
}