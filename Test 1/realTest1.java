// Kevinfied
import java.util.*;
import java.io.*;
public class realTest1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
		
        // Fibonacci sequence

        print("Enter a number: ");
		int n = readInt();

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;

        if (n == 0) {
            println(dp[0]);
        }

        else if (n == 1) {
            println(dp[0] + ", " + dp[1]);
        }
        else {
            print(dp[0] + ", " + dp[1] + ", ");
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            print(dp[i] + ", ");
        }
        println(dp[n-1] + dp[n-2]);

        }
        

    
		
		

    }

    static void print(Object o) {
        System.out.print(o);
    }
    static void println(Object o) {
        System.out.println(o);
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }  
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}


