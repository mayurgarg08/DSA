class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int unmatchedClose = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    unmatchedClose++;
                }
            }
        }

        return (unmatchedClose + 1) / 2;
    }
}