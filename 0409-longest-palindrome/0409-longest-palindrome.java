class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int length = 0;
        boolean hasOdd = false;
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for(int c : freq) {
            if(c % 2 == 0) {
                length += c;
            } else {
                length += c-1;
                hasOdd = true;
            }
        }
        if(hasOdd) length += 1;
        return length;
    }
}