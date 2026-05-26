class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        Set<Character> st = new HashSet<>();
        for(char ch: word.toCharArray()) {
            if(!st.contains(ch)) st.add(ch);
        }
        for(char ch: st) {
            if(ch >= 'a' && ch <= 'z' && st.contains((char)(ch - 32))) count++;
        }
        return count;
    }
}