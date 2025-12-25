class Solution {

    static final int MOD = 1_000_000_007;
    private long recursivePower(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = recursivePower(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = recursivePower(5, evenPositions);
        long oddWays = recursivePower(4, oddPositions);

        long answer = (evenWays * oddWays) % MOD;
        return (int) answer;
    }
}
