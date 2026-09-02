package VII_Recursion.III_Hard;
//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        //Approach 1
        solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    //Approach 1
    public static void solveSudoku(char[][] board) {
        helper(board);
    }
    public static boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char ch='1'; ch<='9'; ch++ ){

                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;
                            if(helper(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }

            }
        }

        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0; i<9; i++){
            if(board[row][i] == ch) return false;
            if(board[i][col] == ch) return false;
            if(board[ (3*(row/3)) + (i/3) ][ (3*(col/3)) + (i%3) ] == ch) return false;
        }

        return true;
    }
}
