//============================================================================
// Name        : CheckersBoard.java
// Author      : Kevin Xu
// Version     : 1.0
// Copyright   : AL UR CODE BELAONGS TO ME! !1 1
// Description : class CheckersBoard that is designed to be used to play a game of checkers.
//============================================================================


import java.util.*;

public class CheckersBoard2 {


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

    private String path = "";
    private static final int OPEN = 0;
    private static final int BLACK = 1;
    private static final int RED = 2;

    public int get(int x,int y){
        if (x<=7 && y<=7 && y>=0) { // checks if out of bound
            return board[x][y];
        }
        return -1;
    }

    public boolean move(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2){ // in the case where they start when they finish, its invalid.
            return false;
        }
        if((x1>7 || x1<0) || (y1>7 || y1<0) || (x2>7 || x2<0) || (y2>7 || y2<0)){ // if any of the values are out of bounds then invalid
            return false;
        }
        int col = board[x1][y1];
        int other = RED+BLACK-col;
        int m = col==BLACK ? 1 : -1; // if Black then going up so +1 if red going down so -1
        //checking 1 move jumps
        if(x1+m == x2 && y1+1 == y2){
            board[x1][y1] = OPEN;
            board[x2][y2] = col;
            return true;
        }
        else if(x1+m == x2 && y1-1 == y2){
            board[x1][y1] = OPEN;
            board[x2][y2] = col;
            return true;
        }
        else{
            //checking captures
            capture(x1,y1,x2,y2,col,path);
            String ans = path;
            if(ans.length() == 0){ // if no suitable path then false
                return false;
            }
            else{
                //change start pos to OPEN and end pos with capturing piece
                board[x1][y1] = OPEN;
                board[x2][y2] = col;  //"2143" 03

                if(path.length() == 6){ // if there are 3 jumps
                    int cap1 = (x1+Integer.parseInt(path.substring(0,1)))/2; // getting the average of the next jump and current pos because that gets the square
                    //in between which is the enemy piece.
                    int cap2 = (y1+Integer.parseInt(path.substring(1,2)))/2;
                    int cap3 = (Integer.parseInt(path.substring(0,1))+Integer.parseInt(path.substring(2,3)))/2;
                    int cap4 = (Integer.parseInt(path.substring(1,2))+Integer.parseInt(path.substring(3,4)))/2;
                    int cap5 = (Integer.parseInt(path.substring(2,3))+Integer.parseInt(path.substring(4,5)))/2;
                    int cap6 = (Integer.parseInt(path.substring(3,4))+Integer.parseInt(path.substring(5,6)))/2;
                    // enemy piece is captured so the squares that they are on all become open
                    board[cap1][cap2] = OPEN;
                    board[cap3][cap4] = OPEN;
                    board[cap5][cap6] = OPEN;
                }
                if(path.length() == 4){
                    int caP1 = (x1+Integer.parseInt(path.substring(0,1)))/2;
                    int caP2 = (y1+Integer.parseInt(path.substring(1,2)))/2;
                    int caP3 = (Integer.parseInt(path.substring(0,1))+Integer.parseInt(path.substring(2,3)))/2;
                    int caP4 = (Integer.parseInt(path.substring(1,2))+Integer.parseInt(path.substring(3,4)))/2;
                    board[caP1][caP2] = OPEN;
                    board[caP3][caP4] = OPEN;
                }
            }
            if(path.length()== 2){
                int cAP1 = (x1+Integer.parseInt(path.substring(0,1)))/2;
                int cAP2 = (y1+Integer.parseInt(path.substring(1,2)))/2;
                board[cAP1][cAP2] = OPEN;
            }
            // reseting path cuz its a global
            path = "";
            return true;
        }
    }


    public void capture(int x1, int y1, int x2, int y2,int col, String path) {
        if (x1 == x2 && y1 == y2) { //useless statment just there because void type so nothing to return when base case is met.
            this.path = path;
        } else {
            if (col == BLACK) {
                if (get(x1 + 1, y1 + 1) == RED && get(x1 + 2, y1 + 2) == OPEN) { // checking if adjacent square is enemy and square next to that is open.
                    capture(x1 + 2, y1 + 2, x2, y2, BLACK, path + String.valueOf(x1 + 2) + String.valueOf(y1 + 2));
                }
                if (get(x1 + 1, y1 - 1) == RED && get(x1 + 2, y1 - 2) == OPEN) {
                    capture(x1 + 2, y1 - 2, x2, y2, BLACK, path + String.valueOf(x1 + 2) + String.valueOf(y1 - 2));
                }
            } else if (col == RED) {
                if (get(x1 - 1, y1 + 1) == BLACK && get(x1 - 2, y1 + 2) == OPEN) {
                    capture(x1 - 2, y1 + 2, x2, y2, BLACK, path + String.valueOf(x1 - 2) + String.valueOf(y1 + 2));
                }
                if (get(x1 - 1, y1 - 1) == BLACK && get(x1 - 2, y1 - 2) == OPEN) {
                    capture(x1 - 2, y1 - 2, x2, y2, BLACK, path + String.valueOf(x1 - 2) + String.valueOf(y1 - 2));
                }
            }
        }
    }
//    public boolean move(int x1, int y1, int x2, int y2) {
//        int currentPlayer = board[x1][y1]; // Determine current player based on the piece being moved
//
//        if (validMove(x1, y1, x2, y2, currentPlayer)) {
//            // Update the board with the new position
//            board[x2][y2] = board[x1][y1];
//            board[x1][y1] = 0;
//
//            // If it's a capture, remove the captured piece
//            if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 2) {
//                int midX = (x1 + x2) / 2;
//                int midY = (y1 + y2) / 2;
//                board[midX][midY] = 0;
//            }
//
//            return true;
//        }
//
//        return false;
//    }
//
//
//
//
////    public boolean valid() {
//        /* valid moves:
//            Basic move:
//            any piece can move to any open diagonally adjacent square:
//            black pieces advance up, and red pieces advance down.
//
//            Capture:
//            A piece can capture an opponent's piece by jumping over it to an empty square immediately beyond.
//
//            If after capturing one enemy the piece is set-up to capture another it may.
//            When the move method is called only the start of the move and the end of the move
//            specified your program must be consider multiple captures when evaluating if a move is valid or not.
//
//            Kings:
//            for the sake of simplicity, we will ignore the effects of kings in this class.
//        */
//
//
//    //    }
//    public boolean validMove(int x1, int y1, int x2, int y2, int currentPlayer) {
//        // Check if the start and end positions are within bounds
//        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 ||
//                x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
//            return false;
//        }
//
//        // Check if the end position is empty
//        if (board[x2][y2] != 0) {
//            return false;
//        }
//
//        // Check if the move is diagonal
//        if (Math.abs(x1 - x2) != 1 || Math.abs(y1 - y2) != 1) {
//            return false;
//        }
//
//        // Check if the current player is trying to move their own piece
//        if (board[x1][y1] != currentPlayer) {
//            return false;
//        }
//
//        // Check if the piece is moving in the correct direction based on player
//        if (currentPlayer == 1 && y2 <= y1) {
//            return false;
//        } else if (currentPlayer == 2 && y2 >= y1) {
//            return false;
//        }
//
//        // Check if a capture is being attempted
//        if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 2) {
//            int midX = (x1 + x2) / 2;
//            int midY = (y1 + y2) / 2;
//
//            // Check if the middle position contains an opponent's piece
//            if (board[midX][midY] != (3 - currentPlayer)) {
//                return false;
//            }
//        }
//
//        return true;
//    }


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

    public int getColour(int x, int y){
        return board[x][y];
    }

}
