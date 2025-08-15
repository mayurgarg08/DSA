class Solution {
    public String largestGoodInteger(String num) {
        List<Character> ans = new ArrayList<>();
        for(int i = 1; i < num.length()-1; i++) {
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i+1)) {
                ans.add(num.charAt(i));
            }
        }
        if (ans.isEmpty()) {
            return "";
        }
        
        char maxChar = Collections.max(ans);
        return "" + maxChar + maxChar + maxChar;
    }
}