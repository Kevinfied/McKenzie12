// Kevinfied
// BasicEx4.java

import java.util.Scanner;

public class BasicEx4 {

    public static long factorial(long n, int MOD) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % MOD;
        }

        return ans;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int MOD = 1000000007;

        System.out.print("Enter a number > ");
        long n = scan.nextLong();

        System.out.print(factorial(n, MOD));


    }


}
