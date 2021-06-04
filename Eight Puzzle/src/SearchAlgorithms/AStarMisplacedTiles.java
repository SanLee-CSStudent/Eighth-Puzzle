package SearchAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import DataStructures.Node;
import Puzzle.Operators;
import Puzzle.State;

public class AStarMisplacedTiles extends Search {

	public AStarMisplacedTiles(State i, State g, Operators o) {
		super(i, g, o);
		// System.out.println("h(n) = " + MisplacedTile(this.initialState));
	}
	
	// Add misplaced tile and Euclidean distance function
	private int MisplacedTile(State curr) {
		int h = 0;
		
		for(int i = 0; i < curr.size; i++) {
			for(int j = 0; j < curr.size; j++) {
				// ignore blank space = 0
				if(!curr.state[i][j].equals(goalState.state[i][j]) && !curr.state[i][j].equals("0")) {
					h++;
				}
			}
		}
		
		return h;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Initial State: ");
		initialState.printState();
		Node root = new Node(initialState, 0, 0, null, (double)MisplacedTile(initialState));
		numNodes++;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(11, nc);
		// initialize frontiers based on path cost, which is depth in uniform cost search
		// use possible operations(ignore those return null state) create new method?
		frontier.add(root);
		
		ArrayList<Node> explored = new ArrayList<Node>();
		
		// add loop
		while(true) {
			if(frontier.size() > this.maxSizeQueue) {
				this.maxSizeQueue = frontier.size();
			}
			// check if frontier is empty, if it is, exit
			if(frontier.isEmpty()) {
				System.out.println("Frontier is empty. There exists no solution to the puzzle");
				printResult();
				return;
			}
			// Node = frontier.poll()
			Node curr = frontier.poll();
			
			// if Node is Goal, printResult and return
			if(goalState.isEqual(curr.state)) {
				this.numSteps = curr.depth;
				printTrace(curr);
				System.out.println("Reached Goal State: ");
				curr.state.printState();
				printResult();
				return;
			}
			// if not, put Node to explored
			explored.add(curr);
			
			// propagate child nodes depending on the action == initializing frontier
			// if child.state is not in explored or frontier(linear search)
			// frontier.add(child)
			// else if identical child.state is in frontier with higher cost
			// replace the identical state with child.state
			frontier = expand(frontier, curr, explored);
		}
	}

	@Override
	PriorityQueue<Node> expand(PriorityQueue<Node> pq, Node curr, ArrayList<Node> set) {
		// TODO Auto-generated method stub
		State childU = new State(curr.state, 3);
		State childD = new State(curr.state, 3);
		State childL = new State(curr.state, 3);
		State childR = new State(curr.state, 3);
		State[] directions = new State[] {ops.up(childU), ops.down(childD), ops.left(childL), ops.right(childR)};
		
		Node[] frontier = pq.toArray(new Node[] {});
		int sizeF = pq.size();
		Node[] explored = set.toArray(new Node[] {});
		int sizeE = set.size();
		
		for(int i = 0; i < 4; i++) {
			if(directions[i] != null) {
				// Debug print statement
				// System.out.println("Expanding to " + i + " with f(n)");
				// directions[i].printState();
				int g = curr.depth + 1;
				int h = MisplacedTile(directions[i]);
				Node child = new Node(directions[i], g+h, curr.depth+1, curr, h, op[i]);
				if(!inFrontier(frontier, directions[i], sizeF) && !inFrontier(explored, directions[i], sizeE)) {
					pq.add(child);
				}
				else if(inFrontier(frontier, directions[i], sizeF)) {
					Node existingChild = findNode(frontier, directions[i], sizeF);
					if(existingChild.cost > child.cost) {
						pq.remove(existingChild);
						pq.add(child);
					}
				}
				
				// System.out.println("h(n) = " + child.cost);
				
				this.numNodes++;
			}
		}

		return pq;
	}
	
}
