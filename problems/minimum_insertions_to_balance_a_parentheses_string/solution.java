class Solution {
    public int minInsertions(String s) {
        int openCount = 0;
        int insertCount = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '(') openCount++;

            else{
                if(i + 1 < n && s.charAt(i + 1) == ')'){
                    if(openCount > 0)
                        openCount--;
                    else
                        insertCount++;
                    i++;
                }
                
                else{
                    if(openCount > 0)
                        openCount--;
                    else
                        insertCount++;
                    insertCount++;
                }
                    
            }
        }

        insertCount += (2 * openCount);
        
        return insertCount;
    }
}