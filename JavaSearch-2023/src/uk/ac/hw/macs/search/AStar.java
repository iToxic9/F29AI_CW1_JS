package uk.ac.hw.macs.search;

import java.util.HashMap;
import java.util.Map;

public class AStar {

	public static void main(String[] args) {

		//Values for the fringes on grid
		final int whiteValue = 1;
		final int grayValue = 2;

		//Grid Map
		Map<String, Node> nodeNames = new HashMap<String, Node>();
		Map<Node, int[][]> grid = new HashMap<Node, int[][]>();
		
		//Grid 1 ================ This is where you can setup different grid arrangements ================
		// ================ You can change these VV ================
		//IMPORTANT: Change these values to set the goal node (x,y)=(6,3).
		
		final int endX = 6;
		final int endY = 3;
		/*
		final int gridX = 6;
		final int gridY = 4;

		//20 Nodes including root (s) and goal (g)
		final String[] whiteCells = {"a","c","d","h","j","k","l","m","q"};
		final String[] grayCells = {"b","e","f","i","n","o","p","r","t"};

		//This is used to create naming scheme for cells. Technically unnecessary
		final String[][] cells = {whiteCells, grayCells};
	
		//Black Squares Coords (starting from 0 thus -1 to all values)
		int[][] XY = new int[endX+1][endY+1];
		XY[3-1][1-1] = -1;
		XY[3-1][3-1] = -1;
		XY[2-1][4-1] = -1;
		XY[3-1][4-1] = -1;
		XY[endX-1][endY-1] = -1; //denotes goal node
		*/
		// ================ Don't change these VV ================
		// (this isn't actually used as fringe cost as state contains it), can mainly be displayed

		int heuristic = Math.abs(endX) + Math.abs(endY); //Gives heuristic value for starting node
		
		Node root = new Node(new AStarStates(heuristic, false)); //root Node has heuristic value (in this case 9)
		Node G = new Node(new AStarStates(0, true)); //Goal Node has heuristic of zero
		
		// ================ Don't change these ^^^ =================

		// Create Grid Manually
		// (x,y)
		// (0,0) Start
		// root Node
		// (0,1) E
		heuristic = getHeuristic(0,1, endX, endY);
		Node E = new Node(new AStarStates(heuristic, false));
		root.addChild(E, grayValue);
		// (0,2) L
		heuristic = getHeuristic(0,2, endX, endY);
		Node L = new Node(new AStarStates(heuristic, false));
		root.addChild(L, whiteValue);
		// (0,3) P
		heuristic = getHeuristic(0,3, endX, endY);
		Node P = new Node(new AStarStates(heuristic, false));
		L.addChild(P, grayValue);
		// (1,0) A
		heuristic = getHeuristic(1,0, endX, endY);
		Node A = new Node(new AStarStates(heuristic, false));
		root.addChild(A, whiteValue);
		// (1,1) F
		heuristic = getHeuristic(1,1, endX, endY);
		Node F = new Node(new AStarStates(heuristic, false));
		A.addChild(F, grayValue);
		E.addChild(F, grayValue);
		// (1,2) M
		heuristic = getHeuristic(1,2, endX, endY);
		Node M = new Node(new AStarStates(heuristic, false));
		F.addChild(M, grayValue);
		L.addChild(M, grayValue);
		// (1,3) null

		// (2,0) null

		// (2,1) H
		heuristic = getHeuristic(2,1, endX, endY);
		Node H = new Node(new AStarStates(heuristic, false));
		F.addChild(H, whiteValue);
		// (2,2) null

		// (2,3) null

		// (3,0) B
		heuristic = getHeuristic(3,0, endX, endY);
		Node B = new Node(new AStarStates(heuristic, false));
		// (3,1) I
		heuristic = getHeuristic(3,1, endX, endY);
		Node I = new Node(new AStarStates(heuristic, false));
		H.addChild(I, grayValue);
		B.addChild(I, grayValue);
		// (3,2) N
		heuristic = getHeuristic(3,2, endX, endY);
		Node N = new Node(new AStarStates(heuristic, false));
		I.addChild(N, grayValue);
		// (3,3) Q
		heuristic = getHeuristic(3,3, endX, endY);
		Node Q = new Node(new AStarStates(heuristic, false));
		N.addChild(F, whiteValue);
		// (4,0) C
		heuristic = getHeuristic(4,0, endX, endY);
		Node C = new Node(new AStarStates(heuristic, false));
		B.addChild(C, whiteValue);
		// (4,1) J
		heuristic = getHeuristic(4,1, endX, endY);
		Node J = new Node(new AStarStates(heuristic, false));
		C.addChild(J, whiteValue);
		I.addChild(J, whiteValue);
		// (4,2) O
		heuristic = getHeuristic(4,2, endX, endY);
		Node O = new Node(new AStarStates(heuristic, false));
		J.addChild(O, grayValue);
		N.addChild(O, grayValue);
		// (4,3) R
		heuristic = getHeuristic(4,3, endX, endY);
		Node R = new Node(new AStarStates(heuristic, false));
		O.addChild(R, grayValue);
		Q.addChild(R, grayValue);
		// (5,0) D
		heuristic = getHeuristic(5,0, endX, endY);
		Node D = new Node(new AStarStates(heuristic, false));
		C.addChild(D, whiteValue);
		// (5,1) K
		heuristic = getHeuristic(5,1, endX, endY);
		Node K = new Node(new AStarStates(heuristic, false));
		D.addChild(K, whiteValue);
		J.addChild(K, whiteValue);
		// (5,2) Goal!
		K.addChild(G, whiteValue);
		O.addChild(G, whiteValue);
		// (5,3) T
		heuristic = getHeuristic(5,3, endX, endY);
		Node T = new Node(new AStarStates(heuristic, false));
		G.addChild(T, grayValue);
		R.addChild(T, grayValue);


		/*
		// ================       Create grid      =================
		for (int x = 0; x < gridX; x++) {
			for (int y = 0; y < gridY; y++) {
				if (XY[x][y] != -1) {
					//Create alphabet grid
					for (String[] i : cells) {
						for (String j : i) {
							int[][] temp = {{x},{y}}; //coordinates to grid position
							heuristic = Math.abs(endX - x) + Math.abs(endY - y);
							tempParent = tempNode;
							if (i.equals(whiteCells)){
								//Assign fringe value
								XY[x][y] = whiteValue;
								//create node
								tempNode = new Node(new AStarStates(heuristic, false));
								tempParent.addChild(tempNode, whiteValue);
								tempParent = tempNode;
								//Insert into grid HashMap
								grid.put(tempNode, temp);
								//Insert into nodeNames Hashmap for lookup
								nodeNames.put(j, tempNode);
							} else if (i.equals(grayCells)) {
								//Assign fringe value
								XY[x][y] = grayValue;
								//create node
								tempNode = new Node(new AStarStates(heuristic, false));
								//Add this node to parent node
								tempParent.addChild(tempNode, grayValue);
								tempParent = tempNode;
								//Insert into grid HashMap
								grid.put(tempNode, temp);
								//Insert into nodeNames Hashmap for lookup
								nodeNames.put(j, tempNode);
							}
						}
					}
				} else if (x == endX - 1 && y == endY - 1) {
					//goal node, in this case its white
					tempParent.addChild(G, whiteValue);
				} else {
					//Add null node indicating black square
					tempParent = null;
					//Since node is null there is no worry that agent uses it
				}
			}			
		}
		*/
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
