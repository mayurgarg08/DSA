class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxPoints = 0;
        int lSum = 0;
        int rSum = 0;
        for(int i = 0; i< k; i++) {
           lSum += cardPoints[i];
        }
        maxPoints = lSum;
        int rIndex = cardPoints.length-1;
        for(int i = k-1; i >= 0; i--) {
            lSum = lSum-cardPoints[i];
            rSum = rSum+cardPoints[rIndex];
            rIndex = rIndex-1;
            maxPoints = Math.max(maxPoints, lSum+rSum);
        }
        return maxPoints;
    }
}