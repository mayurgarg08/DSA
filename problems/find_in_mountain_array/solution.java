

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if (left != -1) return left;
        
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private int findPeak(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int binarySearch(MountainArray arr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = arr.get(mid);
            
            if (midVal == target) return mid;

            if (ascending) {
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
