class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    HashMap<Integer, Integer> map = new HashMap<>(); 

    public boolean canCross(int[] stones) {
        int n = stones.length;

        if(n > 1 && stones[1] != 1) return false;

        for(int i = 0; i < n; i++) {
            map.put(stones[i], i); 
        }

        return helper(1, 1, stones);
    }

    private boolean helper(int idx, int prevJump, int[] stones) {
        if(idx == stones.length - 1) return true;

        String key = idx + "," + prevJump;
        if(memo.containsKey(key)) return memo.get(key);

        int currPos = stones[idx];

        if(prevJump - 1 > 0) {
           int nextPos = currPos + prevJump - 1;
            if(map.containsKey(nextPos)) {
                int nextIdx = map.get(nextPos);
                if(helper(nextIdx, prevJump - 1, stones)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

          int nextPos = currPos + prevJump;
        if(map.containsKey(nextPos)) {
            int nextIdx = map.get(nextPos);
            if(helper(nextIdx, prevJump, stones)) {
                memo.put(key, true);
                return true;
            }
        }

        nextPos = currPos + prevJump + 1;
        if(map.containsKey(nextPos)) {
            int nextIdx = map.get(nextPos);
            if(helper(nextIdx, prevJump + 1, stones)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}