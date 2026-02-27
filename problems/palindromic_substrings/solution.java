class Solution {
    private int check(String s, int left, int right) {
       int count = 0;
       while(right < s.length() && left >= 0) {
        if(s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        } else {
            break;
        }
       }
       return count;
    }
    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        for(int i = 0; i< n; i++) {
            result += check(s, i, i);
            result += check(s, i, i+1);
        }
        return result;
    }
}