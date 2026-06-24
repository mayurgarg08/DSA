class Solution {
    class Job {
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
       int[] dp;

    public int solve(int idx, Job[] jobs) {

        if (idx == jobs.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int notTake = solve(idx + 1, jobs);

        int next = binarySearch(jobs, jobs[idx].end);

        int take = jobs[idx].profit + solve(next, jobs);

        return dp[idx] = Math.max(take, notTake);
    }

    private int binarySearch(Job[] jobs, int endTime) {

        int low = 0;
        int high = jobs.length - 1;
        int ans = jobs.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (jobs[mid].start >= endTime) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, jobs);
    }
}