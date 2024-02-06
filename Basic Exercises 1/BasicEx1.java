// Kevinfied
// BasicsEx1.java

import java.util.Scanner;


public class BasicEx1 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int total = 0;
            int counter = 0;
            int n;
//            int min = 2147483647;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;


            while (true) {
                System.out.print("Enter a number > ");
                n = scan.nextInt();


                if (n == 0) {
                    break;
                }

                if (n > max) {
                    max = n;
                }

                if (n < min) {
                    min = n;
                }

                counter++;
                total += n;

            }

            System.out.printf("The average of these numbers is %d \n", total/counter);
            System.out.printf("The smallest of these integers is %d \n", min);
            System.out.printf("The largest of these integers is %d \n" , max);



        }

}
