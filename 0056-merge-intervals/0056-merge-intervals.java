class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for(int i = 1; i < n; i++) {
          int prevEnd = ans.get(ans.size()-1)[1];
          int prevStart = ans.get(ans.size()-1)[0];
          if(prevEnd >= intervals[i][0]) {
              int minStart = Math.min(prevStart, intervals[i][0]);
              int maxEnd = Math.max(prevEnd, intervals[i][1]);
 
              ans.remove(ans.size()-1);
              ans.add(new int[]{minStart, maxEnd});
          } else {
              ans.add(intervals[i]);
          }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
