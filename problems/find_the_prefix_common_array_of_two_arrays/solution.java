class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
      int m = A.length;
    
      int[] freq1 = new int[m+1];
      int[] freq2 = new int[m+1];
      int [] c = new int[m];

      Arrays.fill(freq1, 0);
      Arrays.fill(freq2, 0);

      freq1[0] = 0;
      freq2[0] = 0;
      
      int count = 0;
      for(int i = 0; i<m; i++) {
        freq1[A[i]]++;
        freq2[B[i]]++;
     
        for(int j = 0; j<=i; j++) {
            if(freq1[A[j]] == freq2[A[j]]) {
                count++;
                
            }
             c[i] = count;
             
        }
        count = 0;
      } 
      return c;
    }
}