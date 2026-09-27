class Solution {
    String b;
    Map<String, Integer> map;
    List<List<String>> ans;
 
    private void dfs(String word, List<String> seq) {
        if(word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = map.get(word);
        int sz = word.length();
        for(int i = 0; i < sz; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
               char[] replaceArray = word.toCharArray();
               replaceArray[i] = ch;
               String replaceWord = new String(replaceArray);
               if(map.containsKey(replaceWord) && map.get(replaceWord) + 1 == steps) {
                seq.add(replaceWord);
                dfs(replaceWord, seq);
                seq.remove(seq.size() - 1);
               } 
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b = beginWord;
        map = new HashMap<>();
       Set<String> set = new HashSet<>();
       int len = wordList.size();
       for(int i = 0; i < len; i++) {
          set.add(wordList.get(i));
       }
       Queue<String> q = new LinkedList<>();
       q.add(beginWord);
       map.put(beginWord, 1);
       set.remove(beginWord);
       int size = beginWord.length();
       while(!q.isEmpty()) {
         String word = q.peek();
         int steps = map.get(word);
         q.remove();
         if(word.equals(endWord)) break;
         for(int i = 0; i < size; i++) {
            char[] replacedWord = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++) {
                replacedWord[i] = c;
                String newWord = new String(replacedWord);
                if(set.contains(newWord) == true) {
                   set.remove(newWord);
                   q.add(newWord);
                   map.put(newWord, steps+1);
                } 
            }
         }
       }
       ans = new ArrayList<>();
       if(map.containsKey(endWord)) {
         List<String> seq = new ArrayList<>();
         seq.add(endWord);
         dfs(endWord, seq);
       }
       return ans;
    }
}