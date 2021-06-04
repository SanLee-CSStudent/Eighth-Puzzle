package Puzzle;

import SearchAlgorithms.AStarEuclideanDist;
import SearchAlgorithms.AStarMisplacedTiles;
import SearchAlgorithms.Search;
import SearchAlgorithms.UniformCostSearch;

public class EightPuzzle {
	private State initial;
	private State goal;
	private Operators op;
	
	public Search search;
	private Search[] searches;
	
	public EightPuzzle(String[] initial, int size){
		// Hardcoded the goal, change if necessary
		String[] goalStr = new String[] {"1 2 3", "4 5 6", "7 8 0"};
		
		this.initial = new State(initial, size);
		this.goal = new State(goalStr, size);
		
		op = new Operators(size);
		
		searches = new Search[3];
		searches[0] = new UniformCostSearch(this.initial, this.goal, this.op);
		searches[1] = new AStarMisplacedTiles(this.initial, this.goal, this.op);
		searches[2] = new AStarEuclideanDist(this.initial, this.goal, this.op);
	}
	
	public void runSearch(String s) {
		int algorithmIndex = Integer.parseInt(s) - 1;
		if(algorithmIndex > 2 || algorithmIndex < 0) {
			System.out.println("Invalid response of " + s + ". Terminating...");
			System.exit(0);
		}
		
		searches[algorithmIndex].run();
	}
}
