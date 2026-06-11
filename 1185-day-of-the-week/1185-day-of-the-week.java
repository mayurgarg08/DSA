class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        int[] monthDays = {
            31,28,31,30,31,30,
            31,31,30,31,30,31
        };

        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m - 1];
            if (m == 2 && isLeap(year)) {
                totalDays++;
            }
        }

        totalDays += day - 1;
        return week[(totalDays + 5) % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }   
}