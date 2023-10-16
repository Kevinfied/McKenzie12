

import java.util.*;

public class GameWordTest {

    public static void main(String[] args) {

        GameWord test = new GameWord("test");
        System.out.println(test.reverse());
        System.out.println(test.anagram("stet"));
        System.out.println(test.pointValue(0, 0,1));
//        System.out.println(test.permutations().toString());

    }



}
