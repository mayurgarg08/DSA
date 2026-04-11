class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int maxFreq = 0;

        Map<Character, Integer> mpp = new HashMap<>();
        for(char c : tasks) {
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        for(int val: mpp.values()) {
            maxFreq = Math.max(val, maxFreq);
        }
        int countMax = 0;
        for(int val: mpp.values()) {
            if(val == maxFreq) countMax++;
        }
        int ans = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(m, ans);
    }
}