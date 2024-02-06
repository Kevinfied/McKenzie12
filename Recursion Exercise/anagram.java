// Kevinfied
import java.util.*;
import java.io.*;
public class anagram {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	
	// public static void anagram(String word, int index, String ans) {
		
		// Base case
		// if (ans.length() == word.length()) {
			// println(ans);
			// return;
		// }
		
		// char[] letters = word.toCharArray();
		
		// for (char ch : word.toCharArray()) {
			
			// anagram(word, index+1, ans+ch);
			
		// }
		
		
		
	// }
	
	public static void anagram(String ans, String left) {
		
		if (left.isEmpty()) {
			println(ans);
			return;
		}
		
		
		for (int i = 0; i<left.length(); i++) {
			String newWord = left.substring(0,i) + left.substring(i+1);
			anagram(ans + left.charAt(i), newWord);
		}
		
	}
	
	
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
		
		
		
		anagram("", "satin");
		
		

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


