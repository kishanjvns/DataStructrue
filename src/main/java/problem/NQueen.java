package problem;

public class NQueen {
    public static void main(String[] args) {
        NQueen s=new NQueen();
        s.solveNQueens(5);
    }
    public void solveNQueens(int n) {
        int[][] board= new int[n][n];
        if (!solve(board, 0)) {
            System.out.println("No solution exists!");
        }
    }
    public boolean solve(int[][] board,int col){
        if(col == board.length){
            printBoard(board);
            return true;
        }
        for(int row=0;row< board.length; row++){
            if(isValidPlace(board,row,col)){
                //place queen
                board[row][col] = 1;
                if (solve(board, col + 1)) {
                    return true; // Success
                }
                board[row][col] = 0;
            }

        }
        return false;
    }
    public void printBoard(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length; j++){
                if(board[i][j] == 1){
                    System.out.print("* \t");
                }else{
                    System.out.print("- \t");
                }
            }
            System.out.println();
        }
    }
    public boolean isValidPlace(int[][] board,int row,int col){

        //check the current row, two queen can not be in same row
        for(int i=0;i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }
        //check the diagonal from top left to bottom right
        for(int r=row,c=col; r>=0 && c>=0; r--,c--){
            if(board[r][c] == 1){
                return false;
            }
        }

        //check the diagonal from top right to bottom left
        for(int r=row,c=col; r< board.length && c>=0; r++,c--){
            if(board[r][c] == 1){
                return false;
            }
        }
        return true;
    }
}

