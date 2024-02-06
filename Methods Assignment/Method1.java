// Kevinfied
import java.util.*;
import java.io.*;
public class Method1{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
	public static double mean(int[] arr) {
		int len = arr.length;
		double average = 0;
		
		for (int num : arr) {
			average += num;
		}
		
		average = average / len;
		
		return average;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
		
		
    
		
		

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


