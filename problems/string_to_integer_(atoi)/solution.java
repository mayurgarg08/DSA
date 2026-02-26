class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int ans = 0;
        boolean neg = false;
        boolean started = false;  

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == ' ' && !started) {
                continue;
            }

            if ((ch == '-' || ch == '+') && !started) {
                neg = (ch == '-');
                started = true;
                continue;
            }

            if (ch >= '0' && ch <= '9') {
                started = true;
                int digit = ch - '0';

                if (ans > Integer.MAX_VALUE / 10 ||
                   (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                ans = ans * 10 + digit;
            } 
            else {
                break;
            }
        }

        return neg ? -ans : ans;
    }
}