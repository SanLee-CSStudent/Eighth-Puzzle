import java.util.Scanner;

import Puzzle.EightPuzzle;

public class Main {
	static int size = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("8 Puzzle Solver by San Lee(862120749)\n"
				+ "Type 1 to use a default puzzle, or 2 to enter your own puzzle.");
		String selectPuzzle = input.nextLine();
		// initialize default eight puzzle if 1
		// take another user inputs for customized puzzle if 2
		// then initialize custom eight puzzle using object
		String[] inputState = createPuzzle(selectPuzzle, input);
		EightPuzzle problem = new EightPuzzle(inputState, size);
		
		System.out.println("Enter which algorithm to run\n"
				+ "Uniform Cost Search\n"
				+ "A* with the Misplaced Tile Heuristic\n"
				+ "A* with the Euclidean Distance Heuristic");
		String selectAlgor = input.nextLine();
		// using the eight puzzle object initialized above
		// run desired algorithm, which should be defined in the object
		// algorithm methods should print the process...
		
		problem.runSearch(selectAlgor);
	}
	
	// later change this to puzzle object
	private static String[] createPuzzle(String s, Scanner in) {
		String[] rows = new String[size];
		if(s.equals("1")) {
			// default puzzle
			rows[0] = "3 4 5";
			rows[1] = "1 6 8";
			rows[2] = "0 7 2";
		}
		else if(s.equals("2")) {
			// customized puzzle
			System.out.println("Enter your puzzle, use a zero to represent the blank\n"
					+ "Enter the first row, use a space between numbers.");
			rows[0] = in.nextLine();
			rows[0] = rows[0].substring(0, size*2 - 1);
			System.out.println("Enter the second row, use a space between numbers");
			rows[1] = in.nextLine();
			rows[1] = rows[1].substring(0, size*2 - 1);
			System.out.println("Enter the third row, use a space between numbers");
			rows[2] = in.nextLine();
			rows[2] = rows[2].substring(0, size*2 - 1);
			
		}
		else {
			System.out.println("Invalid Response. Terminating...");
			System.exit(-1);
		}
		
		return rows;
	}
}
