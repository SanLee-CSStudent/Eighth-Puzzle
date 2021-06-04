package SearchAlgorithms;

import DataStructures.Node;
import Puzzle.Operators;
import Puzzle.State;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UniformCostSearch extends Search {
	private int uniformCost = 1;
	
	public UniformCostSearch(State i, State g, Operators o) {
		super(i, g, o);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Initial State: ");
		initialState.printState();
		Node root = new Node(initialState, 0);
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
				// depth of the resulting tree will be 31
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
	
	public PriorityQueue<Node> expand(PriorityQueue<Node> pq, Node curr, ArrayList<Node> set) {
		// TODO Auto-generated method stub
		// Debug print statement
		// System.out.println("Expand with explored set.");
		// curr.state.printState();
		
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
				// System.out.println("Expanding to " + i);
				// directions[i].printState();
				
				Node child = new Node(directions[i], (int)curr.cost+uniformCost, curr.depth+1, curr, op[i]);
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
				this.numNodes++;
			}
		}
		return pq;
	}
}
