//============================================================================
// Name        : GameWord.java
// Author      : Kevin Xu
// Version     : 1.0
// Copyright   : AL UR CODE BELAONGS TO ME! !1 1
// Description : This is a class that is designed to be used to used within  the game of Scrabble.
//============================================================================



import java.util.*;
public class GameWord {

    private String word;

    String contents = this.word;

    /*
    Double Letter - 12
    Triple Letter - 13
    Double Word   - 21
    Triple Word   - 31
                   W L
     */


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




    public GameWord(String word) {

        this.word = word;
    }

    


    public String reverse() {
        return new StringBuilder(word).reverse().toString();
    }

    public boolean anagram (String otherWord) {

        // return true if the current word can be rewritten as the other word

        if (word.length() != otherWord.length()) {
            return false;
        }

        else {
            char[] wordArray = word.toCharArray();
            char[] otherWordArray = otherWord.toCharArray();

            Arrays.sort(wordArray);
            Arrays.sort(otherWordArray);

            boolean anagram = (Arrays.equals(wordArray, otherWordArray));

            return anagram;
        }
    }

    public int pointValue(int x, int y, int direction) {
//        direction == 1 means RIGHT
//        direction == 2 means DOWN

// 🤦
//        Set<Character>onePoints = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'l', 'n', 'o', 'r', 's', 't', 'u'));
//        Set<Character>twoPoints = new HashSet<Character>(Arrays.asList('d', 'g'));
//        Set<Character>threePoints = new HashSet<Character>(Arrays.asList('b', 'c', 'm', 'p'));
//        Set<Character>fourPoints = new HashSet<Character>(Arrays.asList('f', 'h', 'v', 'w', 'y'));
//        Set<Character>fivePoints = new HashSet<Character>(Arrays.asList('k'));
//        Set<Character>eightPoints = new HashSet<Character>(Arrays.asList('j', 'x'));
//        Set<Character>tenPoints = new HashSet<Character>(Arrays.asList('q', 'z'));

        int[] vals = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1,
                        1, 4, 4, 8, 4, 10};
        int points = 0;

        if (direction == 1) {
            for (int i = 0; i < word.length(); i++) {
                points += vals[word.charAt(i) - 'a'] * board[x][y + i];
                System.out.println(board[x+ i][y]);
            }
        }

        else if (direction == 2) {
            for (int i = 0; i < word.length(); i++) {
                points += vals[word.charAt(i) - 'a'] * board[x + i][y];

            }
        }

        return points;
    }


    public ArrayList permutations() {
        ArrayList<String> perm = new ArrayList<String>();


        perm = recur(perm, word, 0);

        return perm;
    }

    public ArrayList recur(ArrayList<String> perm, String word, int index) {
        if (index == word.length()) {
            return perm;
        }


        else {
            for (int i = 0; i < word.length(); i++) {
                perm.add(word.charAt(i) + (recur(perm, word, index + 1)).toString());
            }
        }
        return perm;
    }

    @Override
    public String toString() {
        return contents;
    }


}

