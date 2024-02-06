/*
 * Kevin Xu
 * BasicAssign1.java
 * 
 * 
 */


import java.util.*;


public class BasicAssign1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        int len = line.length();

        for (int i = 0; i < len+1; i++) {

            // First line
            if (i == 0) {
                System.out.print(line);
                System.out.println(line.charAt(0));
            }
            // Last line
            else if (i == len) {
                System.out.print(line.charAt(0));
                for (int j=0; j<len; j++) {
                    System.out.print(line.charAt(len-j-1));
                }
            }
            // The middle
            else {
                System.out.print(line.charAt(len-i));
                System.out.print(" ".repeat(len-1));
                System.out.println(line.charAt(i));
            }

        }

    }

}