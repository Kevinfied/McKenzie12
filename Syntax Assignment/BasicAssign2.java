/*
 * Kevin Xu
 * BasicAssign2.java
 * 
 * 
 */

import java.util.*;
public class BasicAssign2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();

        String line = a + " ";
        char prev = ' ';

        int counter = 0;
        for (char ch : line.toCharArray()) {
            if (ch != prev) {
                if (counter != 0) {
                    System.out.print(counter);
                    System.out.print(prev);
                }

                counter = 1;
                prev = ch;
            }
            else {          
                counter ++;
                prev = ch;
            }
        }
    }
}