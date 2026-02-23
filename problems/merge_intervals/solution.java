class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        List<int[]> ans = new ArrayList<>();
       int n = intervals.length;
       int m = intervals[0].length;
       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
       ans.add(intervals[0]);
       for(int i = 1; i< n; i++) {
          if(ans.get(ans.size()-1)[1] < intervals[i][0]) {
            ans.add(intervals[i]);
          } else {
            int end = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            int start = Math.min(ans.get(ans.size()-1)[0], intervals[i][0]);

            ans.remove(ans.size() - 1);
            ans.add(new int[] {start, end});
          }
       }
       int k = ans.size();
       int[][] result = new int[k][2];
       for(int i = 0; i< k; i++) {
         result[i] = ans.get(i);
       }
       return result;
    }
}
