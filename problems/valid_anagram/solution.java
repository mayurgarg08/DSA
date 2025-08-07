class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] ch = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(ch);
        
        return Arrays.equals(chars, ch);
    }
}