class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int index = -1;
        for(int i = 0; i< n; i++) {
            if(s.charAt(i) == s.charAt(n-i-1)) {
                index = i;
                break;
            }
        }
        return index;
    }
}