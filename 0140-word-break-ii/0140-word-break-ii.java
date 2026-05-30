class Solution {
    private void dp(int idx, String s, StringBuilder sb, StringBuilder sentence, List<String> wordDict, List<String> ans) {
       if (idx == s.length()) {
            if (wordDict.contains(sb.toString())) {
                int len = sentence.length();

                sentence.append(sb.toString());
                ans.add(sentence.toString());

                sentence.setLength(len);
            }
            return;
        }

        sb.append(s.charAt(idx));

        if (wordDict.contains(sb.toString())) {
            String word = sb.toString();

            int len = sentence.length();
            sentence.append(word).append(" ");

            dp(idx + 1, s, new StringBuilder(), sentence, wordDict, ans);

            sentence.setLength(len);
        }

        dp(idx + 1, s, sb, sentence, wordDict, ans);  
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        dp(0, s, sb, sentence, wordDict, ans);
        return ans;
    }
}