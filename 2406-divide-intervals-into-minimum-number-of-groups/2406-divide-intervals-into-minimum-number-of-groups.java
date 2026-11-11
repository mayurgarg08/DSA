class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = intervals[i][0];
            arr2[i] = intervals[i][1];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while(i < n && j < n) {
            if(arr1[i] <= arr2[j]) {
                count++;
                i++;
            }    
            else {
                count--;
                j++;
            }    
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}