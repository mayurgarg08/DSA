class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        String ans = "";
        boolean flag = false;
        for(int i = 0; i< str.length(); i++) {
            if(str.charAt(i) == '6' && flag == false) {
               ans += "9";
               flag = true;
            } else {
                ans += str.charAt(i);
            }
        }   
        return Integer.parseInt(ans);   
    }
}