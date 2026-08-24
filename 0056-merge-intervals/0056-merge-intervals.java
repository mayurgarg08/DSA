class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ans.add(intervals[0]);
        for(int i = 1; i < n; i++ ){
            if(intervals[i][0] > ans.get(ans.size()-1)[1]) {
                ans.add(intervals[i]);
            } else {
                int minStart = Math.min(intervals[i][0], ans.get(ans.size()-1)[0]);
                int maxEnd = Math.max(intervals[i][1], ans.get(ans.size()-1)[1]);
                int[] arr = new int[2];
                arr[0] = minStart;
                arr[1] = maxEnd;
                ans.remove(ans.size()-1);
                ans.add(arr);
            }
        }
        int k = ans.size();
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++ ){
            result[i] = ans.get(i);
        }
        return result;
    }
}
