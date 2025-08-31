import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Arrays.sort(friends); 
        List<Integer> ans = new ArrayList<>();

        for (int num : order) {
            if (binarySearch(friends, num)) {
                ans.add(num);
            }
        }

        int[] sol = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            sol[j] = ans.get(j); // fixed get()
        }
        return sol;
    }

    private boolean binarySearch(int[] friends, int ele) {
        int start = 0;
        int end = friends.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (friends[mid] == ele) {
                return true;
            } else if (friends[mid] < ele) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
