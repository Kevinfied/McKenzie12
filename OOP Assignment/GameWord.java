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


        Set<Character>onePoints = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'l', 'n', 'o', 'r', 's', 't', 'u'));
        Set<Character>twoPoints = new HashSet<Character>(Arrays.asList('d', 'g'));
        Set<Character>threePoints = new HashSet<Character>(Arrays.asList('b', 'c', 'm', 'p'));
        Set<Character>fourPoints = new HashSet<Character>(Arrays.asList('f', 'h', 'v', 'w', 'y'));
        Set<Character>fivePoints = new HashSet<Character>(Arrays.asList('k'));
        Set<Character>eightPoints = new HashSet<Character>(Arrays.asList('j', 'x'));
        Set<Character>tenPoints = new HashSet<Character>(Arrays.asList('q', 'z'));

        int points = 0;



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


}


