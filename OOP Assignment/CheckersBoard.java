//============================================================================
// Name        : CheckersBoard.java
// Author      : Kevin Xu
// Version     : 4.0
// Description : class CheckersBoard that is designed to be used to play a game of checkers.
// There are 3 methods in this class: count, display, and move.
// Count counts the number of pieces of a given color on the board (pass in 1 or 2).
// Display prints out ASCII version of the board.
// Move moves a piece from one square to another if it is valid and returns either true or false.
//============================================================================

class CheckersBoard {

    public static final int EMPTY = 0;
    public static final int RED = 2;
    public static final int BLACK = 1;
    // private String path = "";

    /*
    The black pieces should be in rows 0-2, and red should be in rows 5-7.
     */

    private int [][] board = {
        // 0, 0
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
                            // 8, 8
};


    public int count(int color) {
        // loop thru every square and count how many pieces are of the given color
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j=0; j < 8; j++) {
                if (board[i][j] == color) {
                    count++;
                }
            }
        }

        return count;
    }

    public void display() {
        System.out.println("+---+---+---+---+---+---+---+---+");

        // loop thru every square and print it
        for(int i=0; i<8; i++){
            System.out.print("|");
            for(int j=0; j<8; j++){
                // if black print B

                if (board[i][j] == BLACK){
                    System.out.print(" B ");
                }
                // if red print R
                else if (board[i][j] == RED){
                    System.out.print(" R ");
                }
                // if empty print space
                else{
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
    }


    public boolean valid(int x, int y) {
        // a square is valid iff it is on the board and empty
        boolean flag = (x>=0 && x<8 && y>=0 && y<8 && board[x][y]==0);
        return flag;
    }


    public int get(int x,int y){
        // get color of the piece at x,y
        if(x<=7 && y<=7 && y>=0 && x>=0){
            return board[x][y];
        }
            return -1;
    }

    // BASIC MOVING
    public boolean basicMove(int x1, int y1, int x2, int y2) {
        int col = board[x1][y1];
        // int other = RED + BLACK - col;

        int moving = col == BLACK ? 1 : -1; // if Black then going up so +1 if red going down so -1

        // basic moving
        if (valid(x1 + moving, y1 + 1) && x1 + moving == x2 && y1 + 1 == y2) {
            // if the target adjacent square is empty, move there
            board[x1][y1] = EMPTY;
            board[x2][y2] = col;
            return true;
        } 
        else if (valid(x1 + moving, y1 - 1) && x1 + moving == x2 && y1 - 1 == y2) {
            board[x1][y1] = EMPTY;
            board[x2][y2] = col;
            return true;
        }

        // if cant move to neither of the adjacent squares, cannot make basic move
        return false;

    }

    // call this method to move a piece
    public boolean move(int x1, int y1, int x2, int y2) {
        
        int col = board[x1][y1];
        // int other = RED + BLACK - col;

        // ENTRY CONDITIONS
        if (x1 == x2 && y1 == y2) { 
            return false; // didnt move
        }

        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7) {
            return false; // out of bounds
        }

        if (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
            return false; // out of bounds
        }

        if (board[x2][y2] != EMPTY) {
            return false; // destination not empty
        }

        if (board[x1][y1] == EMPTY) {
            return false; // source is empty
        }

        if (col == RED) {
            if (x1 >= x2) {
                return false; // red can only move down
            }
        }

        else {
            if (x1 <= x2) {
                return false; // black can only move up
            }
        }

        if (((x1 + y1) % 2) != ((x2 + y2) % 2)) {
            return false; // move not on same color square. impossible
        }


        // if all of the entry conditions are met, then we can move
        return move(x1, y1, x2, y2, true);
    }

    // |
    // V

    public boolean move(int x1, int y1, int x2, int y2, boolean basic) {
        
        int col = board[x1][y1];
        int other = RED + BLACK - col;

        int moving = col == BLACK ? 1 : -1; // if Black then going up so +1 if red going down so -1

        // basic moving
        if (basicMove(x1, y1, x2, y2) && basic) {
            return true;
        }

        // base case
        if (x1 == x2 && y1 == y2) { 
            return true; // position reached
        }


        // recursive case
        // check if the piece can jump
        if (valid(x1+(moving*2), y1+2) && board[x1+moving][y1+1] == other) {
            // if the target adjacent square is empty, move there
            board[x1][y1] = EMPTY;
            board[x1+moving][y1+1] = EMPTY;
            board[x1+(moving*2)][y1+2] = col;

            // if the move succeeded, return true
            if (move(x1+(moving*2), y1+2, x2, y2, false)) {
                return true;
            }

            // if the move failed, undo it
            board[x1][y1] = col;
            board[x1+moving][y1+1] = other;
            board[x1+(moving*2)][y1+2] = EMPTY;
        } 

        else if (valid(x1+(moving*2), y1-2) && board[x1+moving][y1-1] == other) {
            // other direction
            board[x1][y1] = EMPTY;
            board[x1+moving][y1-1] = EMPTY;
            board[x1+(moving*2)][y1-2] = col;
            if (move(x1+(moving*2), y1-2, x2, y2, false)) {
                return true;
            }
            board[x1][y1] = col;
            board[x1+moving][y1-1] = other;
            board[x1+(moving*2)][y1-2] = EMPTY;
        }


        return false;
    }
}
