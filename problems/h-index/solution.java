class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); 
        int n = citations.length;
        if(n == 1) {
            if(citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int start = 0;
        int end = n-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(n-mid == citations[mid]) {
                return citations[mid];
            } else if(n-mid > citations[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
      return n-start;
    }
}