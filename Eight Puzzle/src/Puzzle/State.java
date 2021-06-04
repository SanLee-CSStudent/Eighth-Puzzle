package Puzzle;

public class State {
	public String[][] state;
	public int size;
	public int row0, col0;
	
	// Copy Constructor
	public State(State copy, int size){
		this.size = size;
		state = new String[size][size];
		
		this.row0 = copy.row0;
		this.col0 = copy.col0;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				this.state[i][j] = copy.state[i][j];
			}
		}
	}
	
	State(String[] input, int size){
		state = new String[size][size];
		this.size = size;
		
		for(int i = 0; i < this.size; i++) {
			int colIndex = 0;
			for(int j = 0; j < (this.size*2 - 1); j++) {
				if(input[i].charAt(j) != ' ') {
					if(input[i].charAt(j) == '0') {
						row0 = i;
						col0 = colIndex;
					}
					state[i][colIndex] = "" + input[i].charAt(j);
					colIndex++;
				}
			}
		}
	}
	
	public void printState() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("");
	}
	
	public boolean isEqual(State goal) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(!(this.state[i][j].equals(goal.state[i][j]))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int[] findPos(String block) {
		int[] pos = new int[2];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(state[i][j].equals(block)) {
					pos[0] = i;
					pos[1] = j;
					
					return pos;
				}
			}
		}
		
		return pos;
	}
	
	public void updateBlank() {
		
	}
}
