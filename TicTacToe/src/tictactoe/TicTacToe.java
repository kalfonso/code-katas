package tictactoe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		System.out.println(getWelcomeMessage());
		Scanner scanner = new Scanner(System.in);
		do 
			playGame(scanner);
		while(wantToPlay(scanner));
	}

	private static void playGame(Scanner scanner) {
		GameParser game = new GameParser();
		System.out.println(game.boardToString());
		while(!game.isGameOver()) {
			String line = scanner.nextLine().trim();
			processInput(game, line);
		}
		System.out.println("GAME OVER!! \n" + game.getResult() + "\n");
	}
	
	private static void processInput(GameParser game, String line) {
		if(line.equalsIgnoreCase("exit"))
			System.exit(0);
		String output = game.processPosition(line);
		System.out.println(output);
	}
	
	private static boolean wantToPlay(Scanner scanner) {
		System.out.println("Play another game? (y to play, Enter to exit)");
		String line = scanner.nextLine();
		if(line.trim().equalsIgnoreCase("y"))
			return true;
		return false;
	}
	
	public static String getWelcomeMessage() {
		String message = "Hello!\nWelcome to Tic Tac Toe Game \n";
		message += "exit or Ctrl C: for exit \n";
		return message;
	}
}
