class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(n > 0) {
            int rem = n%10;
            map.put(rem, map.getOrDefault(rem, 0)+1);
            n = n/10;
        }
        for(int num: map.keySet()) {
           ans += map.get(num)*num;
        }
        return ans;
    }
}