// Kevinfied
import java.util.*;
import java.io.*;
public class Method3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	
	public static int[] arrayAdd(int[] lst, int n) {
		
		int[] arr = new int[lst.length + 1];
		
		for (int i=0; i<lst.length; i++) {
			arr[i] = lst[i];
			
		}
		
		arr[lst.length] = n;
		
		return arr;
		
		
		
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


