class Solution {
    public List<String> stringMatching(String[] words) {
       ArrayList<String> ans = new ArrayList<String>(); 
       for(int i = 0; i <words.length; i++) {
          for(int j = 0; j<i; j++) {
            if(words[i].contains(words[j])) {
                if(!(ans.contains(words[j]))) {
                    ans.add(words[j]);
                }
            } 
          }
        for(int j = i+1; j<words.length; j++) {
            if(words[i].contains(words[j])) {
              if(!(ans.contains(words[j]))) {
                ans.add(words[j]);
              }  
            } 
          }
       }
       return ans;
    }
}