// Kevinfied

// Method6 but with dynamic programming instead of recursion
import java.util.*;
import java.io.*;
public class Method6DP {

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

	int [][]grid =
	{
		{ 0,21,20, 5,25,25,35,15},
		{12,26,43,29,15,26,15,12},
		{ 7,18,23,28,36,32,12,18},
		{43,34,35,18,25,18,21,25},
		{32,41,23, 9,21,17,24,14},
		{12, 9,20,42, 9,19,26,22},
		{30,17,17,35,14,25,14,21},
		{15,21,37,24,19,15,35,15}
	};
        
    	int dp[][] = new int[8][8];
    	String dir[][] = new String[8][8];
    	dp[0][0] = grid[0][0];
	dir[0][0] = "";	
	for (int i=1; i<8; i++){
	
	    dp[0][i] = dp[0][i-1] + grid[0][i];
	    dp[i][0] = dp[i-1][0] + grid[i][0];
	
	    dir[0][i] = dir[0][i-1] + "D";
	    dir[i][0] = dir[i-1][0] + "R";
	}

        for (int i=1; i<8; i++){
            for (int j=1; j<8; j++){
                if (dp[i-1][j] < dp[i][j-1]) {
                    dir[i][j] = dir[i-1][j] + "R";
                } 
                
                else {
                    dir[i][j] = dir[i][j-1] + "D";
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
		
        System.out.println(dp[7][7]);
        System.out.println(dir[7][7]);
		
		

    }
}


