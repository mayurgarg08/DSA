class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return bfs(start, arr, n, visited);
    }
    private boolean bfs(int idx, int[] arr, int n, boolean[] visited) {
        if(idx < 0 || idx >= n || visited[idx] == true) return false;
        if(arr[idx] == 0) return true;
        
        visited[idx] = true;

        return bfs(idx+arr[idx], arr, n, visited) || bfs(idx-arr[idx], arr, n, visited);
    }
}