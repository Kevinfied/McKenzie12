// Kevinfied
// BasicEx2.java

import java.util.Scanner;

public class BasicEx2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        int temp;

        System.out.print("Enter an integer > ");

        int n = scan.nextInt();

        System.out.print("Number of terms > ");

        int terms = scan.nextInt();


        int[] dp = new int[terms];


        dp[0] = 1;
        dp[1] = n;

        int sum = dp[0] + dp[1];

        for (int i = 2; i < terms; i++) {

            dp[i] = dp[i-1] * n;

            sum += dp[i];


        }

        System.out.printf("The sum is %d", sum);


    }

}
