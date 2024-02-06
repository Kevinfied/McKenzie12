/*
 * Kevin Xu
 * BasicAssign5.java
 * 
 * This is a basic program that reads in a two-part product code, and outputs whether its valid or not
 */

import java.util.*;


public class BasicAssign5 {

/* 
    public static boolean check1(String word) {

        int[] nums = new int[6];
        int counter = 0;

        for (char ch : words[0].toCharArray()) { 

            if (Character.isDigit(ch)) {
                
                if (counter >= 6) {
                    return false;
                }
            }
        }
       return true;
    }
*/

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] words = line.split(" ");   /// splits the line into 2 parts

        boolean flag1 = true; //// flag for the first condition
        // boolean flag2 = true;

        int[] nums = new int[6];    /// this is used to store the the numbers from the first half
        int counter = 0;

        /// loop thru all the characters in the first part
        for (char ch : words[0].toCharArray()) { 

            /// Numbers
            if (Character.isDigit(ch)) {

                /// if there are more than 6 numbers, break. the product code is not valid
                if (counter >= 6) {
                    flag1 = false;
                    break; 
                }

                else {
                /// Otherwise, add it to nums array for later use
                    nums[counter] = Character.getNumericValue(ch);
                    /*
                     * note to self:
                     * to get two dig number, just take the first dig * 10 + the second dig
                     */
                    counter++;
                }
            }

            // Characters
            else {
                /// if the character is not upper case, invalid
                if (!Character.isUpperCase(ch)) {
                    flag1 = false;
                    break;
                }
                // else {
                //     flag1 = false;
                //     break;

                // }
            }

        }

        /// if there arent exactly 6 numbers in the first part, invalid
        if (counter != 6) {
            flag1 = false;

        }


        // Second part
        if (flag1) {

            int compare = Integer.parseInt(words[1]); /// convert second part of product code into an int
            int product = 1;
            // int a, b, c;
            int[] temp = {0, 0, 0}; /// used to store the 3 two-digit numbers


            for (int j=0; j<6; j++) {
            //     System.out.println(nums[j]);

            //// [0, 1, 2, 3, 4, 5]
            /// takes number at even index, multiply it by 10, and adds it to the next number.
            /// this will form the two digit number
                if (j%2 == 0) {
                    temp[j/2] += nums[j] * 10;
                }
                else {
                    temp[j/2] += nums[j];
                }

            }

            /// product of the three numbers
            for (int val : temp) {
                product *= val;
            }

            // System.out.println(compare);
            // System.out.println(product);

            /// if product of the three 2 digit numbers equals to the second half of the product code
            if (compare == product) {
                System.out.println("Valid");
            }
            
            else {
                System.out.println("Invalid");
            }

        }

        /// first part has failed conditions
        else {
            System.out.println("Invalid");
        }

    }
}