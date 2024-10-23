package uk.ac.hw.macs.search;

import examples.IntState;

public class AStar {

	private static Node addChild(int value, boolean goal, Node parent1, Node parent2) {
		Node child = new Node(new IntState(value, goal));
		parent2.addChild(child, 1);
		return child;
	}
	
	public static void main(String[] args) {

		Node OUT = new Node(new IntState(0));
		
		Node S = new Node(new IntState(0));
		Node goal = new Node(new IntState(1,true));
		Node A = addChild(1, false, S, OUT);
		Node B = addChild(0, false, OUT, OUT);
		Node C = addChild(1, false, B, OUT);
		Node D = addChild(1, false, C, OUT);
		Node E = addChild(2, false, S, OUT);
		Node F = addChild(2, false, A, E);
		Node H = addChild(1, false, F, OUT);
		Node I = addChild(1, false, H, B);
		Node J = addChild(1, false, I, C);
		Node K = addChild(1, false, J, D);
		Node L = addChild(2, false, E, OUT);
		Node M = addChild(1, false, F, L);
		Node N = addChild(1, false, I, OUT);
		Node O = addChild(1, false, J, N);
		Node G = addChild(1, true, K, O);
		Node P = addChild(1, false, L, OUT);
		Node Q = addChild(1, false, N, OUT);
		Node R = addChild(1, false, O, Q);
		Node T = addChild(1, false, R, G);
		
		G.addChild(goal, 0);
		
		
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(S);
		
	}

}
