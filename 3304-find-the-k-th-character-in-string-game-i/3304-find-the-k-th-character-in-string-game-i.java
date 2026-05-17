class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while(sb.length() < k) {
            for(char c: sb.toString().toCharArray()) {
                sb.append((char)(c+1));
            }
        }
        return sb.charAt(k-1);
    }
}