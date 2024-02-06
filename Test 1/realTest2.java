// Kevinfied
import java.util.*;
import java.io.*;
public class realTest2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        // a e i o u

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        String line;

        while (true) {
            print("Enter a line > ");
            line = readLine();

            if (line.equals("end")) {
                break;
            }

            for (char ch: line.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    while (true) {
                    
                    int randint = rand.nextInt(5);
                    if (ch != vowels[randint]) {
                        print(vowels[randint]);
                        break;
                    }

                    }
                }
                else {
                    print(ch);
                }
            }
            print("\n");

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


