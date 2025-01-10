class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> ans = new ArrayList<>();
        int[] tempfreq = new int[26];
        int[] maxfreq = new int[26];
        
        for(String word : words2) {
            Arrays.fill(tempfreq, 0);
            for(int i = 0; i<word.length(); i++) {
              tempfreq[word.charAt(i)-'a']++;
            }
            for(int i = 0; i< 26;i++) {
            maxfreq[i] = Math.max(maxfreq[i], tempfreq[i]);
        }
        }
        for(String word: words1) {
            Arrays.fill(tempfreq,0);
            for(int i = 0; i<word.length(); i++) {
                tempfreq[word.charAt(i)-'a']++;
            }
            boolean isUniversal = true;
            for(int i =0; i<26; i++) {
                if(maxfreq[i]>tempfreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) {
                ans.add(word);
            }
        }

        return ans;
    }
}