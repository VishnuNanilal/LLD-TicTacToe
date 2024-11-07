import java.util.Arrays;

public class Board {
    char[][] board;
    Board(){
        board=new char[3][3];
        for(int i=0; i<3; i++){
            Arrays.fill(board[i], '-');
        }
    }

    public boolean setCell(char ch, int i, int j){

        if(checkOOB(i, j)){
            return false;
        }
        if(board[i][j]!='-'){
            return false;
        }
        board[i][j]=ch;
        return true;
    }

    public boolean checkWinner(int x, int y) {
        char currChar = board[x][y];
        if (currChar != 'X' && currChar != 'O') {
            throw new IllegalArgumentException("The cell is not set.");
        }
        if(checkVert(currChar, x, y))
            return true;
        if(checkHori(currChar, x, y))
            return true;
        return checkLRDiag(currChar) || checkRLDiag(currChar);
    }

    boolean checkHori(char ch, int x, int y){
        for (int j = 0; j < 3; j++) {
            if (board[x][j] != ch) {
                return false;
            }
        }
        return true;
    }

    boolean checkVert(char ch, int x, int y){
        for (int i = 0; i < 3; i++) {
            if (board[i][y] != ch) {
                return false;
            }
        }
        return true;
    }

    boolean checkLRDiag(char ch){
        for(int i=0; i<3; i++){
            if(board[i][i]!=ch)
                return false;
        }
        return true;
    }
    boolean checkRLDiag(char ch){
        for(int i=2, j=0; i>=0; i--, j++){
            if(board[i][j]!=ch)
                return false;
        }
        return true;
    }

    public void printBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private boolean checkOOB(int i, int j){
        return i < 0 || i >= 3 || j < 0 || j >=3;
    }
}
