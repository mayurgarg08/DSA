class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'O') continue;
            else {
                count++;
                i += 2;
            }
        }
        return count;
    }
}