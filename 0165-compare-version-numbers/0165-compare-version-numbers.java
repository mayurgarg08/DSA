class Solution {
    public int compareVersion(String version1, String version2) {
        int ans = 0;
        String[] arr = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int n = arr.length;
        int m = arr2.length;

        int x = Math.min(n, m);
        for(int i = 0; i < x; i++) {
            int num = Integer.parseInt(arr[i]);
            int num2 = Integer.parseInt(arr2[i]);

            if(num < num2) {
                return -1;
            } else if(num > num2) {
                return 1;
            } else continue;
        } 

        if(n == m) return ans;
        else if(n < m) {
            for(int i = n; i < m; i++) {
                int num = Integer.parseInt(arr2[i]);
                if(num != 0) {
                    return -1;
                }
            }
        } else {
            for(int i = m; i < n; i++) {
                int num = Integer.parseInt(arr[i]);
                if(num != 0) {
                    return 1;
                }
            }
        }
        return ans;
    }
}