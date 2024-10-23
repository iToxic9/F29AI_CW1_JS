package uk.ac.hw.macs.search;

import uk.ac.hw.macs.search.Node;
import uk.ac.hw.macs.search.SearchOrder;
import uk.ac.hw.macs.search.SearchProblem;

public class AStar {

	private static Node addChild(int value, boolean goal, Node parent1, Node parent2) {
		Node child = new Node(new IntState(value, goal));
		parent2.addChild(child, 1);
		return child;
	}
	
	public static void main(String[] args) {

		Node OUT = new Node(new IntState(0));
		
		//Grid 1
		Node S = new Node(0);
		Node goal = new Node(1);
		/*Node A = addChild();
		Node B = addChild();
		Node C = addChild();
		Node D = addChild();
		Node E = addChild();
		Node F = addChild();
		Node H = addChild();
		Node I = addChild();
		Node J = addChild();
		Node K = addChild();
		Node L = addChild();
		Node M = addChild();
		Node N = addChild();
		Node O = addChild();
		Node G = addChild();
		Node P = addChild();
		Node Q = addChild();
		Node R = addChild();
		Node T = addChild();
		*/
		G.addChild(goal, 0);
		
		
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(S);
		
	}

}
