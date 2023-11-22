import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	
	public static void printMenu() {
		System.out.println("Menu options:");
		System.out.println("P = Play a game of sudoku.");
		System.out.println("Q = Quit game");
		System.out.print("Please enter an option: ");
	}


	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		LinkedList<Sudoku> games = new LinkedList<Sudoku>();
		char option;
		byte numGames = 0;
		
		System.out.println("Hello, welcome to Sudoku in Java!");
		
		
		do {
			
			printMenu();
			
			option = input.next().charAt(0);
			option = Character.toUpperCase(option);
			
			switch (option) {
			
				case 'P' :
				
					games.add(new Sudoku());
					games.get(numGames).fillSudoku();
					games.get(numGames).printSudoku();
					++numGames;
					break;
					
				case 'Q' :
					System.out.println("Thanks for playing");
					break;
				
				default :
					System.out.println("Unknown command");
					
			}
			
			
		} while(option != 'Q');
		
		input.close();
		
	}

}


