class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
      int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int farthest = 0;

        while(!q.isEmpty()) {
            int idx = q.poll();

            int start = Math.max(idx + minJump, farthest);
            int end = Math.min(idx + maxJump, n - 1);

            for(int j = start; j <= end; j++) {
                if(s.charAt(j) == '0') {
                    if(j == n - 1) return true;
                    q.offer(j);
                }
            }

            farthest = end + 1;
        }

        return n == 1;
    }
}