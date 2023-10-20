//============================================================================
// Name        : CheckersBoard.java
// Author      : Kevin Xu
// Version     : 1.0
// Copyright   : AL UR CODE BELAONGS TO ME! !1 1
// Description : class CheckersBoard that is designed to be used to play a game of checkers.
//============================================================================


import java.util.*;

public class CheckersBoard {


    private int [][] board = {
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


    public boolean move() {

        

        return true;
    }


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

    public void display() {
        System.out.println("+---+---+---+---+---+---+---+---+");
        for(int i=0; i<8; i++){
            System.out.print("|");
            for(int j=0; j<8; j++){   
                if (board[i][j] == BLACK){
                    System.out.print(" B ");
                }
                else if (board[i][j] == RED){
                    System.out.print(" R ");
                }
                else{
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
    }



}
