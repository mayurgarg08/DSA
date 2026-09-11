class Solution {
    public void helper(int index, String digits, String[] map, StringBuilder temp, List<String> ans) {
        if(index == digits.length()) {
            ans.add(temp.toString());
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(int i = 0; i < letters.length(); i++) {
            temp.append(letters.charAt(i));
            helper(index+1, digits, map, temp, ans);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
        };
        helper(0, digits, map, new StringBuilder(), ans);
        return ans;
    }
}