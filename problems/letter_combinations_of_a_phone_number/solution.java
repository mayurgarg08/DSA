class Solution {

    private void helper(int index, String digits, StringBuilder curr,
                        List<String> res, String[] map) {

        // Base case: formed one complete combination
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }

        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try each letter
        for (int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));
            helper(index + 1, digits, curr, res, map);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        helper(0, digits, new StringBuilder(), res, map);
        return res;
    }
}
