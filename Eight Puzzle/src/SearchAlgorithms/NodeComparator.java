package SearchAlgorithms;

import java.util.Comparator;

import DataStructures.Node;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.cost < o2.cost) {
			return -1;
		}
		if(o1.cost > o2.cost) {
			return 1;
		}
		
		return 0;
	}

}
