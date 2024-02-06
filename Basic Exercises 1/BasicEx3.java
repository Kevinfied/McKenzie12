// Kevinfied
// BasicEx3.java

import java.util.Scanner;


public class BasicEx3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer between 1 and 50 > ");
        int n = scan.nextInt();

        System.out.printf("Factors of %d: \n", n);

        for (int i=1; i <= n; i++) {

            if (n % i == 0) {
                System.out.println(i);
            }


        }

    }


}
