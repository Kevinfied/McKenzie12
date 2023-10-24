// Kevin Xu
import java.util.*;

class MyDate {


    private int month, day, year;

    // private ArrayList<String> months = new ArrayList<String>();

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                       "October", "November", "December"};
    
    // for (int i = 0; i < m.length; i++) {
    //     months.add(m[i]);
    // }

    // constructor 

    public MyDate(String date) {

            String[] items = date.split(" ");
            String m1 = items[0];
            this.month = convert(m1);
        
            this.day = Integer.parseInt(items[1]);
    
            this.year = Integer.parseInt(items[2]);
    }

    public int convert(String m1) {

        int num = -1;

        for (int i=0; i<12; i++) {
            if (months[i].equals(m1)) {
                num = i + 1;
            }
        }


        if (num != -1) {
            return num;
        }

        else {
            return Integer.parseInt(m1);
        }
    }



    public void setMonth(int m) {

        if (m >= 1 && m <= 12) {

            this.month = m;

        }

    }

    public void setDay(int d) {
        boolean[] validDays = {  (d >= 1 && d <= 31), (d >= 1 && d <= 28), 
            (d >= 1 && d <= 31), (d >= 1 && d <= 30), (d >= 1 && d <= 31), 
            (d >= 1 && d <= 30), (d >= 1 && d <= 31), (d >= 1 && d <= 31), 
            (d >= 1 && d <= 30), (d >= 1 && d <= 31), (d >= 1 && d <= 30), 
            (d >= 1 && d <= 31) };
        if (validDays[month - 1]) {

            this.day = d;

        }

    }


    public void setYear(int y) {

        this.year = y;

    }


    public int between(MyDate d2) {


        // int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int date2 = days[d2.month-1] + d2.day + (d2.year * 365);

        int date1 = days[month-1] + day + (year * 365);

        return date2 - date1;
    }




    @Override
    public String toString(){
        // must return month as a string

        return (months[month - 1] + " " + day + ", " + year);
    }


}
