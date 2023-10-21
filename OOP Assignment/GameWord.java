//============================================================================
// Name        : GameWord.java
// Author      : Kevin Xu
// Version     : 2.0
// Description : This is a class that is designed to be used to used within 
// the game of Scrabble.
// There are 5 methods in this class: reverse, anagram, pointValue,
// permutations, and toString.
// Reverse returns the flipped version of the current word.
// Anagram returns true if the current word can be rewritten as the another word.
// PointValue returns the point value of the word at a given position and direction.
// Permutations returns an ArrayList of all the permutations of the current word.
// toString returns the current word.
//============================================================================



import java.util.*;
public class GameWord {

    

    private String contents;
    public static final int RIGHT = 1, DOWN = 2;

    /*
    Double Letter - 12
    Triple Letter - 13
    Double Word   - 21
    Triple Word   - 31
                   W L
     */


     // the scrabble board
    final int [][]board = {
            {31,11,11,12,11,11,11,31,11,11,11,12,11,11,31},
            {11,21,11,11,11,13,11,11,11,13,11,11,11,21,11},
            {11,11,21,11,11,11,21,11,12,11,11,11,21,11,11},
            {12,11,11,21,11,11,11,12,11,11,11,21,11,11,12},
            {11,11,11,11,21,11,11,11,11,11,21,11,11,11,11},
            {11,13,11,11,11,13,11,11,11,13,11,11,11,13,11},
            {11,11,12,11,11,11,12,11,12,11,11,11,12,11,11},
            {31,11,11,12,11,11,11,21,11,11,11,12,11,11,31},
            {11,11,12,11,11,11,12,11,21,11,11,11,12,11,11},
            {11,13,11,11,11,13,11,11,11,21,11,11,11,13,11},
            {11,11,11,11,21,11,11,11,11,11,21,11,11,11,11},
            {12,11,11,21,11,11,11,12,11,11,11,21,11,11,12},
            {11,11,21,11,11,11,12,11,12,11,11,11,21,11,11},
            {11,21,11,11,11,13,11,11,11,13,11,11,11,21,11},
            {31,11,11,12,11,11,11,31,11,11,11,12,11,11,31}
    };



    // constructor
    // takes in a string and sets it to contents
    public GameWord(String word) {

        this.contents = word;
    }



    // returns the reversed version of the current word
    public String reverse() {
        return new StringBuilder(contents).reverse().toString();
    }


    public boolean anagram (String otherWord) {

        // return true if the current word can be rewritten as the other word


        // logic is simple:
        // if the length of the two words are not the same, then they are not anagrams
        // else, sort the contents of the two words and compare them
        // if the contents are the same, then they are anagrams
        if (contents.length() != otherWord.length()) {
            return false;
        }


        else {
            char[] wordArray = contents.toCharArray();
            char[] otherWordArray = otherWord.toCharArray();

            Arrays.sort(wordArray);
            Arrays.sort(otherWordArray);

            boolean anagram = (Arrays.equals(wordArray, otherWordArray));

            return anagram;
        }
    }


    // allows the user to use the anagram method with a GameWord object
    public boolean anagram(GameWord otherWord) {
        // return true if the current word can be rewritten as the other word

        return anagram(otherWord.contents);
    }



    // returns the point value of the word at a given position and direction
    public int pointValue(int x, int y, int direction) {
        // direction: 1 = right, 2 = down

        // value of each letter
        int[] vals = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int points = 0;
        int multiplier = 1;

        // loop thru every letter in the word and add the point value of each letter
        // multiply the point value by the multiplier of the square
        // word multiplier is always a tens digit of the board
        // letter multiplier is always a ones digit of the board

        // do the letter multipliers before the words
        for (int i = 0; i < contents.length(); i++) {
            if (direction == 1) {
                points += vals[contents.charAt(i)-'a'] * board[x][y + i] % 10;
                multiplier *= board[x][y + i] / 10;
            }
            else {
                points += vals[contents.charAt(i)-'a'] * board[x + i][y] % 10;
                multiplier *= board[x + i][y] / 10;
            }
        }
        return points * multiplier;
    }


    // returns an ArrayList of all the permutations of the current word
    public ArrayList permutations() {

        ArrayList<String> perm = new ArrayList<String>();
        // calls the actual recursive method
        recur(perm, contents, "");
        return perm;
    }

    // the recursive method that actually does the work
    public void recur(ArrayList<String> perm, String word, String ret) {
        if (word.length() == 0) { // base case
            perm.add(ret);
        }


        else {
            for (int i=0; i<word.length(); i++) {
                // remove the letter at index i and add it to the end of ret
                // call the method again with the new word and ret
                recur(perm, word.substring(0,i) + word.substring(i+1), ret+word.charAt(i));
            }
        }
    }


    // returns the current word
    @Override
    public String toString() {
        return contents;
    }
}
