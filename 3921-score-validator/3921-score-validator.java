class Solution {
    public int[] scoreValidator(String[] events) {
        int[] arr = new int[2];
        int score = 0, counter = 0;
        for(int i = 0; i < events.length; i++) {
            if(counter == 10) break;
            else if (events[i].equals("0") || events[i].equals("1") ||
                     events[i].equals("2") || events[i].equals("3") ||
                     events[i].equals("4") || events[i].equals("6")) {

                score += Integer.parseInt(events[i]);

            } else if (events[i].equals("W")) {

                counter += 1;

            } else if (events[i].equals("WD")) {

                score += 1;

            } else if (events[i].equals("NB")) {

                score += 1;

            }  else continue;
        }   
        arr[0] = score;
        arr[1] = counter;
        return arr;
    }
}