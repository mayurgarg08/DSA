class Solution {
    public int countPalindromicSubsequence(String s) {
     int[] firstOcc = new int[26];
     int[] lastOcc  = new int[26];

     Arrays.fill(firstOcc,-1);
     Arrays.fill(lastOcc, -1);
      
     for(int i = 0; i<s.length(); i++) {
        if(firstOcc[s.charAt(i)-'a'] == -1) {
          firstOcc[s.charAt(i)-'a'] = i;
        }
            lastOcc[s.charAt(i)-'a'] = i;
     
     }
     int count = 0;
     for(int i = 0; i<26; i++) {
        int si = firstOcc[i];
        int li = lastOcc[i];
       boolean[] visited = new boolean[26];
       
        for(int j = si+1; j<li; j++) {
        if(!visited[s.charAt(j)-'a']) {
            visited[s.charAt(j)-'a'] = true;
            count++;
        }
     }
     }
     return count; 
    }
}