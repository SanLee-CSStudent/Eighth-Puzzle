package DataStructures;

import Puzzle.State;

public class Node {
	public Node parent;
	public State state;
	public double cost;
	public int depth;
	public double heuristic;
	public String action;
	
	public Node(State state, int cost){
		this.state = state;
		this.cost = cost;
		this.depth = 0;
		this.parent = null;
		this.heuristic = 0;
	}
	
	public Node(State state, int cost, int depth, Node parent, String action){
		this.state = state;
		this.cost = cost;
		this.depth = depth;
		this.parent = parent;
		this.heuristic = 0;
		this.action = action;
	}
	
	public Node(State state, int cost, int depth, Node parent, double heuristic){
		this.state = state;
		this.cost = cost;
		this.depth = depth;
		this.parent = parent;
		this.heuristic = heuristic;
	}
	
	public Node(State state, double cost, int depth, Node parent, double heuristic, String action){
		this.state = state;
		this.cost = cost;
		this.depth = depth;
		this.parent = parent;
		this.heuristic = heuristic;
		this.action = action;
	}
}
