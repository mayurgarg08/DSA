class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stk = new Stack<>();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            freq[idx]--;

            if (visited[idx]) continue;

            while (!stk.isEmpty() &&
                   stk.peek() > ch &&
                   freq[stk.peek() - 'a'] > 0) {

                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }

            stk.push(ch);
            visited[idx] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : stk) {
            ans.append(ch);
        }

        return ans.toString();
    }
}