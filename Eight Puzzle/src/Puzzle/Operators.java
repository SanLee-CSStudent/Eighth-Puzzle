package Puzzle;

public class Operators {
	int size;
	public Operators(int size) {
		this.size = size;
	}
	
	public State up(State curr) {
		if(curr.row0 == 0) {
			// blank at first row cannot go up
			return null;
		}
		
		String swapped = curr.state[curr.row0-1][curr.col0];
		curr.state[curr.row0][curr.col0] = swapped;
		curr.state[curr.row0-1][curr.col0] = "0";
		curr.row0--;
		return curr;
	}
	
	public State down(State curr) {
		if(curr.row0 == (size-1)) {
			// blank at last row cannot go down
			return null;
		}
		
		String swapped = curr.state[curr.row0+1][curr.col0];
		curr.state[curr.row0][curr.col0] = swapped;
		curr.state[curr.row0+1][curr.col0] = "0";
		curr.row0++;
		return curr;
	}
	
	public State left(State curr) {
		if(curr.col0 == 0) {
			// blank at first col cannot go left
			return null;
		}
		
		String swapped = curr.state[curr.row0][curr.col0-1];
		curr.state[curr.row0][curr.col0] = swapped;
		curr.state[curr.row0][curr.col0-1] = "0";
		curr.col0--;
		return curr;
	}
	
	public State right(State curr) {
		if(curr.col0 == (size-1)) {
			// blank at last col cannot go right
			return null;
		}
		
		String swapped = curr.state[curr.row0][curr.col0+1];
		curr.state[curr.row0][curr.col0] = swapped;
		curr.state[curr.row0][curr.col0+1] = "0";
		curr.col0++;
		return curr;
	}
}
