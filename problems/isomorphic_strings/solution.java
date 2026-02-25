class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> st1 = new HashMap<>();
        Map<Character, Character> st2 = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(st1.containsKey(c1)) {
                if(st1.get(c1) != c2) return false;
            } else {
                st1.put(c1, c2);
            }
            if(st2.containsKey(c2)) {
                if(st2.get(c2) != c1) return false;
            } else {
                st2.put(c2, c1);
            }
        }
        return true;
    }
}