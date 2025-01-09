class Solution {
    public int prefixCount(String[] words, String pref) {
       int n = words.length;
       int cnt = 0;
       int m = pref.length();
       
       for(int i = 0; i<n; i++){
        if(words[i].length()>=m){
            //int flag = -1;
            int  check = 0;
            for(int j = 0; j<m; j++){
                if(words[i].charAt(j)==pref.charAt(j)){
                    check++;
                }
                
            }
            if(check==m) {
                cnt++;
            }
        }
        
    
}
return cnt;
}
}