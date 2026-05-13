class Solution {
    public int trailingZeroes(int n) {
        int ans = Math.abs(n/5) + Math.abs(n/25) + Math.abs(n/125) + Math.abs(n/625) + Math.abs(n/3125);
        return ans;
    }
}