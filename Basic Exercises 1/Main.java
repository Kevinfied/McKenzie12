// Kevinfied
// BasicsEx1.java

/*
Write a program that gets numbers from the user until they enter zero then tells the user the average of all the numbers,
the largest number entered, the smallest number entered.
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int total = 0;
        int counter = 0;
        int n;
        int min = 2147483647;
        int max = 0;

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
