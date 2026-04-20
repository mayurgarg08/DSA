class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char c: s.toCharArray()) {
            if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                vowels.add(c);
            }
        }       
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                sb.append(vowels.get(vowels.size()-1));
                vowels.remove(vowels.size()-1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}