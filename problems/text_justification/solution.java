class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int length = 0;
        int i = 0;
        while(i < n) {
            int j = i;
            int totalChars = 0;
            while(j < n && totalChars + words[j].length() + (j-i) <= maxWidth) {
                totalChars += words[j].length();
                j++;
            }
            int numWords = j-i;
            int spaces = maxWidth - totalChars;

            StringBuilder sb = new StringBuilder();
            if(j == n || numWords == 1) {
                for(int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if(k < j-1) {
                        sb.append(' ');
                        spaces--;
                    }
                }
                while(spaces-- > 0) {
                    sb.append(' ');
                }
            } else {
                int gaps = numWords-1;
                int spacespergap = spaces/gaps;
                int extra = spaces%gaps;

                for(int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if(k < j-1) {
                        for(int s = 0; s < spacespergap; s++) {
                            sb.append(' ');
                        }
                        if(extra > 0) {
                            sb.append(' ');
                            extra--;
                        }
                    }
                }
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
}



