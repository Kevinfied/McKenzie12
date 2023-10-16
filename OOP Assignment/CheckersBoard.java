//============================================================================
// Name        : CheckersBoard.java
// Author      : Kevin Xu
// Version     : 1.0
// Copyright   : AL UR CODE BELAONGS TO ME! !1 1
// Description : class CheckersBoard that is designed to be used to play a game of checkers.
//============================================================================


import java.util.*;

public class CheckersBoard {
    // WHY IS THIS ACTUALLY HARD 😭

    private int[][] board = new int[8][8];

    public CheckersBoard() {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                board[0][i] = 1;
                board[2][i] = 1;
                board[6][i] = 2;
            }
            else {
                board[1][i] = 1;
                board[5][i] = 2;
                board[7][i] = 2;
            }
        }
    }




}
