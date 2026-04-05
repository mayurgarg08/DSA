class Solution {
    public boolean judgeCircle(String s) {
        int n = s.length();
        int left = 0, right = 0, up = 0, down = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'U') {
                if(down > 0) {
                    down--;
                    continue;
                } else {
                    up++;
                }
            } else if(s.charAt(i) == 'D') {
                  if(up > 0) {
                    up--;
                    continue;
                  } else down++;
            } else if(s.charAt(i) == 'R') {
                if(left > 0) {
                    left--;
                    continue;
                } else right++;
            } else {
                if(right > 0) {
                    right--;
                    continue;
                } else left++;
            }
        }
        return left == 0 && right == 0 && up == 0 && down == 0;
    }
}