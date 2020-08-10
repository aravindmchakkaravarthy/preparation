package leetcode.array.easy;

/**
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 *
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 *
 *
 * Constraints:
 *
 * The given dates are valid dates between the years 1971 and 2100.
 */
public class DaysOfWeek {

    public static String dayOfTheWeek(int day, int month, int year) {

        String[] days = {"Wednesday","Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        int[] daysOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        int startYear = 1970;
        int countOfDays = 0;
        while(startYear < year){
            if(startYear % 4 == 0){
                countOfDays += 366;
            }else{
                countOfDays += 365;
            }
            startYear++;
        }
        int startMonth = 1;
        if(year % 4 == 0){
            daysOfMonth[2] = 29;
        }
        while(startMonth<month){
            countOfDays +=daysOfMonth[startMonth];
            startMonth++;
        }
        countOfDays +=day;
        return days[countOfDays%7];

    }

    public static void main(String[] args){

        System.out.println(dayOfTheWeek(10, 8, 2020));
    }
}
