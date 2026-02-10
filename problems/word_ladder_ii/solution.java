class Solution {
    String b;
    HashMap<String, Integer> mpp;
    List<List<String>> ans;
    private void dfs(String word, List<String> seq) {
        if(word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        int sz = word.length();
        for(int i = 0; i < sz; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
               char[] replaceArray = word.toCharArray();
               replaceArray[i] = ch;
               String replaceWord = new String(replaceArray);
               if(mpp.containsKey(replaceWord) && mpp.get(replaceWord) + 1 == steps) {
                seq.add(replaceWord);
                dfs(replaceWord, seq);
                seq.remove(seq.size() - 1);
               } 
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b = beginWord;
        mpp = new HashMap<>();
        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for(int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        mpp.put(beginWord, 1);
        st.remove(beginWord);
        int sizee = beginWord.length();
        q.add(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek();
            int steps = mpp.get(word);
            q.remove();
            if(word.equals(endWord)) break;
            for(int i = 0; i<  sizee; i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaceArray = word.toCharArray();
                    replaceArray[i] = ch;
                    String replaceWord = new String(replaceArray);
                    if(st.contains(replaceWord) == true) {
                        q.add(replaceWord);
                        st.remove(replaceWord);
                        mpp.put(replaceWord, steps+1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(mpp.containsKey(endWord) == true) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}