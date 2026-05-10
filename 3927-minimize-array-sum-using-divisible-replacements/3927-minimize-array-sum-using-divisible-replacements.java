class Solution {
    public long minArraySum(int[] nums) {
          int n = nums.length;
          HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        long sum = 0;

        for (int num : nums) {

            int best = num;
            for (int d = 1; d * d <= num; d++) {

                if (num % d == 0) {
                    if (set.contains(d)) {
                        best = Math.min(best, d);
                    }

                    int other = num / d;

                    if (set.contains(other)) {
                        best = Math.min(best, other);
                    }
                }
            }

            sum += best;
        }

        return sum;

    }
}