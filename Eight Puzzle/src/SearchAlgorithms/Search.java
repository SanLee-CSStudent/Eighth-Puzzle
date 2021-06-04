package SearchAlgorithms;

import Puzzle.State;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

import DataStructures.Node;
import Puzzle.Operators;

public abstract class Search {
	State initialState;
	State goalState;
	Operators ops;
	NodeComparator nc;
	String[] op = {"blank_up", "blank_down", "blank_left", "blank_right"};
	ArrayList<String> actions;
	
	int numNodes = 0, numSteps = 0;
	int maxSizeQueue = 0;
	
	public Search(State i, State g, Operators o) {
		this.initialState = i;
		this.goalState = g;
		this.ops = o;
		
		nc = new NodeComparator();
		actions = new ArrayList<String>();
	}
	
	public abstract void run();
	
	public void printResult() {
		System.out.println("Number of Expanded Nodes: " + numNodes);
		System.out.println("Maximum Size of Queue:    " + maxSizeQueue);
		System.out.println("Number of Steps Taken:    " + numSteps);
	}
	
	public void printTrace(Node goal) {
		Node curr = goal;
		Stack<Node> trace = new Stack<Node>();
		while(curr != null) {
			trace.add(curr);
			if(curr.parent != null) {
				actions.add(curr.action);
			}
			curr = curr.parent;
		}
		
		while(trace.size() > 0) {
			Node traced = trace.pop();
			System.out.println("The best state to expand with g(n) = " + traced.depth + ", h(n) = " + traced.heuristic + " is...");
			traced.state.printState();
		}
		
		System.out.println("Sequence of action is...");
		for(int i = actions.size()-1; i >= 0; i--) {
			System.out.println(actions.get(i));
		}
		System.out.println();
	}
	
	abstract PriorityQueue<Node> expand(PriorityQueue<Node> pq, Node curr, ArrayList<Node> set);
	
	public boolean inFrontier(Node[] frontier, State child, int sizeF) {
		// linear search on frontier
		for(int i = 0; i < sizeF; i++) {
			if(frontier[i].state.isEqual(child)) {
				return true;
			}
		}
		return false;
	}
	
	public Node findNode(Node[] frontier, State child, int sizeF) {
		for(int i = 0; i < sizeF; i++) {
			if(frontier[i].state.isEqual(child)) {
				return frontier[i];
			}
		}
		
		return null;
	}
}
