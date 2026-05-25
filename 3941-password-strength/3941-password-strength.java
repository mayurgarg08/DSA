class Solution {
    public int passwordStrength(String password) {
        Set<Character> st = new HashSet<>();
        int strength = 0;
        for(char ch: password.toCharArray()) {
            if(!st.contains(ch)) {
                st.add(ch);
                if(ch >= 'a' && ch <= 'z') strength += 1;
                else if(ch >= 'A' && ch <= 'Z') strength += 2;
                else if(ch >= '0' && ch <= '9') strength += 3;
                else if(ch == '!' || ch == '@' || ch == '#' || ch == '$') strength += 5;
                else continue;
            } else continue;
        }
        return strength;
    }
}