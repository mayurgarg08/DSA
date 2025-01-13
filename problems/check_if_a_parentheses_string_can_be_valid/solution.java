class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 == 1) return false;
        int n = s.length();
        int wild_l2r = 0, open_l2r = 0, close_l2r = 0;
        int wild_r2l = 0, open_r2l = 0, close_r2l = 0;
        for(int i = 0; i<n; i++){
            // left to right
            if(locked.charAt(i) == '0') wild_l2r++;
            else if(s.charAt(i) == '(') open_l2r++;
            else close_l2r++;
            if(wild_l2r + open_l2r < close_l2r) return false;
            // right to left

            int j = n-1-i;
            if(locked.charAt(j) == '0') wild_r2l++;
            else if(s.charAt(j) == '(') open_r2l++;
            else close_r2l++;
            if(wild_r2l + close_r2l < open_r2l) return false;
        }
        return true;
    }
}