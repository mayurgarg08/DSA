class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Special cases
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0; // starting point

        double windowSum = 1.0; // sum of probabilities in the window
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            // Probability of reaching exactly i
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // If Alice has less than k, she can still draw
                windowSum += dp[i];
            } else {
                // Otherwise, game ends here, add to final result
                result += dp[i];
            }

            // Slide the window: remove dp[i - maxPts] if it's out of range
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}
