import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.startGame();
        for(int t=0; t<9; t++){
            System.out.println("Player "+((t%2)+1)+"'s turn.");
            System.out.println("Enter next cell num");
            int cellNum = sc.nextInt();
            game.makeMove(t, cellNum);
        }
    }
}