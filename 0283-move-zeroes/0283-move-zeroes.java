class Solution {
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void moveZeroes(int[] a) {
        int n = a.length;
        int j = -1;
        for(int i = 0; i < n; i++) {
            if(a[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1; i < n; i++) {
            if(a[i] != 0) {
                swap(a, j, i);
                j++;
            }
        }
    }
}