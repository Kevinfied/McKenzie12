//============================================================================
// Name        : CheckersBoard.java
// Author      : Kevin Xu
// Version     : 1.0
// Copyright   : AL UR CODE BELAONGS TO ME! !1 1
// Description : class CheckersBoard that is designed to be used to play a game of checkers.
//============================================================================


import java.util.*;

public class CheckersBoard {


    private int [][] board ={
            {2,0,2,0,2,0,2,0},
            {0,2,0,2,0,2,0,2},
            {2,0,2,0,2,0,2,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1}
    };

    private static final int BLACK = 1;
    private static final int RED = 2;


//    public boolean move() {
//
//    }

    // question: do we pass in a string?
    public int count(int color) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                if (board[i][j] == color) {
                    count++;
                }
            }
        }
        return count;
    }


    /*
    example

+---+---+---+---+---+---+---+---+
| B |   | B |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   | B |   | B |   |   |   |   |
+---+---+---+---+---+---+---+---+
| B |   | B |   | B |   | R |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   | R |   |   |   | B |   |
+---+---+---+---+---+---+---+---+
|   | R |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| R |   | R |   | R |   | R |   |
+---+---+---+---+---+---+---+---+
|   | R |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+

     */
    public void display() {

        for (int t = 0; t<17; t++) {
            if (t % 2 == 0) {
                System.out.println("+---+---+---+---+---+---+---+---+");
            }

            else {
                for (int i=7; i>=0; i--){
                    System.out.print("");

            }
        }




    }
}
}
