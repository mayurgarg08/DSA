class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) {
                return steps;
            }
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedWord[] = word.toCharArray();
                    replacedWord[i] = ch;
                    String formedWord = new String(replacedWord);
                    if(set.contains(formedWord)) {
                        set.remove(formedWord);
                        q.offer(new Pair(formedWord, steps+1));
                    }
                }
            }

        }
        return 0;
    }
}