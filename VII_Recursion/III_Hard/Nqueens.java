package VII_Recursion.III_Hard;

import java.util.ArrayList;

//https://leetcode.com/problems/n-queens/
public class Nqueens {
    //Approach 1 using loops for checking the cell is safe or not
    /*
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        helper(n, board, 0, ans);
        System.out.println(ans);
    }

    private static void helper(int n, char[][] board, int col, ArrayList<ArrayList<String>> ans){
        if(col == n){
            ArrayList<String> list = new ArrayList<>();
            for(char[] arr: board){
                list.add(new String(arr));
            }
            ans.add(list);
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                helper(n, board, col+1, ans);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col){
        int dupRow = row;
        int dupCol= col;

        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        col = dupCol;

        while(row< board.length && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

     */

    //Approach 2 using 3 arrays to track the queen placings
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[(2*n)-1];
        int[] upperDiagonal = new int[(2*n)-1];
        helper(n, board, 0, leftRow, lowerDiagonal, upperDiagonal, ans);
        System.out.println(ans);
    }

    private static void helper(int n, char[][] board, int col, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, ArrayList<ArrayList<String>> ans){
        if(col == n){
            ArrayList<String> list = new ArrayList<>();
            for(char[] arr: board){
                list.add(new String(arr));
            }
            ans.add(list);
            return;
        }

        for(int row=0; row<n; row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[(n-1)+(col-row)] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[(n-1)+(col-row)] = 1;
                helper(n, board, col+1, leftRow, lowerDiagonal, upperDiagonal, ans);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[(n-1)+(col-row)] = 0;
            }
        }
    }
}
