/*
 * Kevin Xu
 * BasicAssign4.java
 * 
 * This is a simple program that gives an average of at least how many people in a class will have 
 * the same birthdates 
 */

import java.util.*;


public class BasicAssign4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // int []nums = new int[10000];
        double total = 0.0;


        for (int i = 0; i < 10000; i++) {
            int date;
            int counter = 0;
            Set<Integer> dates = new HashSet<>();


            while (true) {
                // date = scan.nextInt();
                date = rand.nextInt(365);


                counter++;
                if (dates.contains(date)) {
                    // nums[i] = counter;
                    total += counter;

                    break;
                }
                dates.add(date);

            }

        }

        System.out.print(total/10000);
    }



}






