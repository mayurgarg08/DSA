class Solution {
    Map<String, Integer> memo = new HashMap<>();

    private int helper(int curr, int clipboard, int n) {
        if (curr == n) return 0;
        if (curr > n) return Integer.MAX_VALUE;

        String key = curr + "," + clipboard;
        if (memo.containsKey(key)) return memo.get(key);

        int copyPaste = Integer.MAX_VALUE;
        int next1 = helper(curr * 2, curr, n);
        if (next1 != Integer.MAX_VALUE) {
            copyPaste = 2 + next1;
        }

        int paste = Integer.MAX_VALUE;
        if (clipboard > 0) {
            int next2 = helper(curr + clipboard, clipboard, n);
            if (next2 != Integer.MAX_VALUE) {
                paste = 1 + next2;
            }
        }

        int ans = Math.min(copyPaste, paste);
        memo.put(key, ans);
        return ans;
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        return helper(1, 0, n);
    }
}