package uk.ac.hw.macs.search;

public class AStarGrid2 {

	public static void main(String[] args) {
		
		//Values for the fringes on grid
		final int whiteValue = 1;
		final int grayValue = 2;
		
		//Grid 1 ================ This is where you can setup different grid arrangements ================
		// ================ You can change these VV ================
		//IMPORTANT: Change these values to set the goal node (x,y)=(3,4).
		//Keep in mind it starts at 0
		final int endX = 3;
		final int endY = 4;
		// ================ Don't change these VV ================

		int heuristic = Math.abs(endX) + Math.abs(endY); //Gives heuristic value for starting node
		
		Node root = new Node(new AStarStates(heuristic, false)); //root Node has heuristic value (in this case 9)
		Node G = new Node(new AStarStates(0, true)); //Goal Node has heuristic of zero
		
		// ================ Don't change these ^^^ =================

		// Create Grid Manually
		// (x,y)
		// (0,0) Start
		// root Node
		// (0,1) D
		heuristic = getHeuristic(0,1, endX, endY);
		Node D = new Node(new AStarStates(heuristic, false));
		root.addChild(D, grayValue);
		// (0,2) J
		heuristic = getHeuristic(0,2, endX, endY);
		Node J = new Node(new AStarStates(heuristic, false));
		D.addChild(J, whiteValue);
		// (0,3) N
		heuristic = getHeuristic(0,3, endX, endY);
		Node N = new Node(new AStarStates(heuristic, false));
		J.addChild(N, grayValue);
		// (0,4) T
		heuristic = getHeuristic(0,4, endX, endY);
		Node T = new Node(new AStarStates(heuristic, false));
		N.addChild(T, grayValue);
		// (1,0) A
		heuristic = getHeuristic(1,0, endX, endY);
		Node A = new Node(new AStarStates(heuristic, false));
		root.addChild(A, whiteValue);
		// (1,1) E
		heuristic = getHeuristic(1,1, endX, endY);
		Node E = new Node(new AStarStates(heuristic, false));
		A.addChild(E, whiteValue);
		D.addChild(E, whiteValue);
		// (1,2) K
		heuristic = getHeuristic(1,2, endX, endY);
		Node K = new Node(new AStarStates(heuristic, false));
		E.addChild(K, whiteValue);
		J.addChild(K, whiteValue);
		// (1,3) O
		heuristic = getHeuristic(1,3, endX, endY);
		Node O = new Node(new AStarStates(heuristic, false));
		K.addChild(O, whiteValue);
		N.addChild(O, whiteValue);
		// (1,4) null
		
		// (2,0) null

		// (2,1) F
		heuristic = getHeuristic(2,1, endX, endY);
		Node F = new Node(new AStarStates(heuristic, false));
		E.addChild(F, whiteValue);
		// (2,2) null
		
		// (2,3) P
		heuristic = getHeuristic(2,3, endX, endY);
		Node P = new Node(new AStarStates(heuristic, false));
		O.addChild(P, grayValue);
		// (2,4) null
		
		// (3,0) B
		heuristic = getHeuristic(3,0, endX, endY);
		Node B = new Node(new AStarStates(heuristic, false));
		// (3,1) H
		heuristic = getHeuristic(3,1, endX, endY);
		Node H = new Node(new AStarStates(heuristic, false));
		F.addChild(H, grayValue);
		B.addChild(H, grayValue);
		// (3,2) L
		heuristic = getHeuristic(3,2, endX, endY);
		Node L = new Node(new AStarStates(heuristic, false));
		H.addChild(L, whiteValue);
		// (3,3) Q
		heuristic = getHeuristic(3,3, endX, endY);
		Node Q = new Node(new AStarStates(heuristic, false));
		L.addChild(Q, whiteValue);
		P.addChild(Q, whiteValue);
		// (3,4) Goal!
		Q.addChild(G, whiteValue);
		// (4,0) C
		heuristic = getHeuristic(4,0, endX, endY);
		Node C = new Node(new AStarStates(heuristic, false));
		B.addChild(C, whiteValue);
		// (4,1) I
		heuristic = getHeuristic(4,1, endX, endY);
		Node I = new Node(new AStarStates(heuristic, false));
		H.addChild(I, whiteValue);
		C.addChild(I, whiteValue);
		// (4,2) M
		heuristic = getHeuristic(4,2, endX, endY);
		Node M = new Node(new AStarStates(heuristic, false));
		I.addChild(M, whiteValue);
		L.addChild(M, whiteValue);
		// (4,3) R
		heuristic = getHeuristic(4,3, endX, endY);
		Node R = new Node(new AStarStates(heuristic, false));
		M.addChild(R, grayValue);
		Q.addChild(R, grayValue);
		// (4,4) U
		heuristic = getHeuristic(4,4, endX, endY);
		Node U = new Node(new AStarStates(heuristic, false));
		R.addChild(U, grayValue);
		G.addChild(U, grayValue);


		// ================ Run A* Search ================

		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(root);

	}

	/**
	 * @param x
	 * @param y
	 * @param endX
	 * @param endY
	 * @return
	 */
	private static int getHeuristic(int x, int y, int endX, int endY) {
		int h = Math.abs(endX - x) + Math.abs(endY - y);
		return h;
	}

}
