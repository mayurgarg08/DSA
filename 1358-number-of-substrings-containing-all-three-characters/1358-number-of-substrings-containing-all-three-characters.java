class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] hash = new int[3];
        int count = 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < n) {
            hash[s.charAt(right)-'a']++;
            while(hash[0] >= 1 && hash[1] >= 1 && hash[2] >= 1) {
                count += n-right;
                hash[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}