package tictactoe;

import java.util.Scanner;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			playGame(scanner);
			System.out.println("Game Over!");
			playAnother(scanner);
		}
	}

	public static void playGame(Scanner scanner){
		TicTacToe tictactoe = new TicTacToe();
		while(!tictactoe.isGameOver()){
			System.out.print(tictactoe.getBoard().toString());
			String positionStr = scanner.nextLine();		
			play(tictactoe, positionStr);
		}
		System.out.print(tictactoe.getBoard().toString());
	}
	
	public static void play(TicTacToe tictactoe, String positionStr) {
		try {
			Position position = Position.parse(positionStr);
			tictactoe.play(position);
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid Input: " + e.getMessage() + "!");
		} catch (Exception e){
			System.out.println("Wrong Position!");
		}
	}
	
	public static void playAnother(Scanner scanner){
		System.out.println("Play another?(n for exit)");
		String response = scanner.nextLine();
		if(response.equals("n"))
			System.exit(0);
	}
}
