class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();

        while(a > 0 || b > 0) {

            int len = ans.length();

            if(len >= 2 && ans.charAt(len-1) == ans.charAt(len-2)) {
                if(ans.charAt(len-1) == 'a') {
                    ans.append('b');
                    b--;
                } else {
                    ans.append('a');
                    a--;
                }
            } 
            else {
                if(a >= b) {
                    ans.append('a');
                    a--;
                } else {
                    ans.append('b');
                    b--;
                }
            }
        }

        return ans.toString();
    }
}