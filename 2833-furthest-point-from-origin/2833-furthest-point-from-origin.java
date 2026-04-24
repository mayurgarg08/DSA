class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int left = 0;
        int right = 0;
        int dash = 0;
        for(int i = 0; i < n; i++) {
            if(moves.charAt(i) == 'L') left++;
            else if(moves.charAt(i) == 'R') right++;
            else dash++;
        }
        if(left > right) return left-right+dash;
        return right-left+dash; 
    }
}