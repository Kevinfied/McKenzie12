// Kevinfied

/*
 * 
 * The method will take as a parameter an 8 x 8 grid of numbers starting with 
 * the top left corner (0,0) and ending with the bottom right(7,7). 
 * These numbers are the number of seconds that it takes for the 
 * tank to move onto that particular square (oddly enough it takes 
 * the same time regardless of the direction it comes from.) 
 * Your output will be the fastest time the tank can make it to the last square 
 * as well as proper directions. 
 * You may assume that it will always take less than 1000 seconds total.
 */

import java.util.*;
import java.io.*;
public class Method6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int best = Integer.MAX_VALUE;
    static String bestAns = "";
    public static void recur(int[][]arr) {
        String ans = "";



        recur(arr, 0, 0, 0, ans);

        println(best);
        println(bestAns);
    }
	
	public static void recur(int[][] arr, int a, int b, int count, String ans) {


        // Base case
        if (a == 7 && b == 7) {
            if (count < best) {
                best = count;
                bestAns = ans;
            }

            return;
        }

        // Recursive case

        else {
            if (a < 7) {
                recur(arr, a+1, b, count + arr[a+1][b], ans + "R");
            }
            if (b < 7) {
                recur(arr, a, b+1, count + arr[a][b+1] , ans + "D");
            }
        }
	}
	
	
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        int [][]grid = {
        { 0,21,20, 5,25,25,35,15},
        {12,26,43,29,15,26,15,12},
        { 7,18,23,28,36,32,12,18},
        {43,34,35,18,25,18,21,25},
        {32,41,23, 9,21,17,24,14},
        {12, 9,20,42, 9,19,26,22},
        {30,17,17,35,14,25,14,21},
        {15,21,37,24,19,15,35,15}
        };

        recur(grid);
		
    
		
		

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


