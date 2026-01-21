class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        merged.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {

            int[] lastMerged = merged.get(merged.size() - 1);
            int currentStart = intervals[i][0];
            int currentEnd   = intervals[i][1];

            if (currentStart <= lastMerged[1]) {
                lastMerged[1] = Math.max(lastMerged[1], currentEnd);
            }
            else {
                merged.add(new int[]{currentStart, currentEnd});
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
