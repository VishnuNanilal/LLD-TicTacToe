public class TicTacToe
{
    Player player1;
    Player player2;
    Board board;
    TicTacToe(){
        player1=new Player('X');
        player2=new Player('O');
        board = new Board();
    }

    public void startGame(){
        System.out.println("Player 1 has "+player1.playerType);
        System.out.println("Player 2 has "+player2.playerType);
        board.printBoard();
    }
    public boolean makeMove(int turnNum, int cellNum){
        Player player = turnNum%2==0?player1:player2;
        char playerType=player.getType();
        cellNum--;
        int i=cellNum/3;
        int j=cellNum%3;
        board.setCell(playerType, i, j);
        boolean hasWon = checkWinner(i, j);
        if(hasWon){
            System.out.println(playerType+" HAS WON!");
            System.out.print("GAME OVER!!!");
            cleanUp();
            return true;
        }
        board.printBoard();
        return false;
    }

    public void cleanUp(){
        board=new Board();
    }
    public boolean checkWinner(int i, int j){
        return board.checkWinner(i, j);
    }
}
