class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int m = shifts.length;
        int[] diff = new int[n+1];
        for(int[] shift: shifts) {
            if(shift[2] == 0) {
                diff[shift[0]]--;
                diff[shift[1]+1]++;
            } else {
                diff[shift[0]]++;
                diff[shift[1]+1]--;
            } 
        }

        for(int i = 1; i< n+1; i++) {
           diff[i] += diff[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i< n; i++) {
           int cnt = diff[i];
           cnt = cnt%26;
           if(cnt<0) cnt += 26;
           char ch = (char)((s.charAt(i) - 'a' + cnt)%26 +'a');
           sb.append(ch);
        }
        return sb.toString();
    }
}