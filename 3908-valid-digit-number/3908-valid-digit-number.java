class Solution {
    public boolean validDigit(int n, int x) {
        String num = Integer.toString(n);
        char num2 = (char)(x + '0');;

        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == num2 && num.charAt(0) != num2) {
                return true;
            }
        }
        return false;
    }
}