class Solution {
    public int numberOfSubstrings(String s) {
       int n = s.length();
       int[] hash = new int[3];
       int l = 0;
       int r = 0;
       int count = 0;
       while(r < n) {
         hash[s.charAt(r)-'a']++;
         while(hash[0] >= 1 && hash[1] >= 1 && hash[2] >= 1) {
            count += s.length() - r;
            hash[s.charAt(l)-'a']--;
            l++;
         } 
         r++;
       }
       return count;
    }
}