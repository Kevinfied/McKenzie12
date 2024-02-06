// Kevinfied
import java.util.*;
import java.io.*;
public class Method5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	
	public static int randint(int a, int b) {
		return (int)(Math.random()*(b-a+1)) + a;
	}
	
	public static String licensePlate(String[] words) {
		Random rand = new Random();
		String[] nono = words;
		String ret = "";
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}
		int let;
		let = rand.nextInt(26);
		boolean flag = true;
		while (true) {
			flag = true
			ret = "";
			for (int i=0; i<4; i++) {
				let = rand.nextInt(26);
				
				ret += letters[let];
				
			}
			
			for (String word : nono) {
				if (ret.contains(word)) {
					flag = false;
					continue;
				}
			}
			if (flag) {
				break;
			}
			
		}
		
		
		
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


