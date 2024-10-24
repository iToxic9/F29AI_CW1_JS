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

		// ================ Don't change these VV ================
		// (this isn't actually used as fringe cost as state contains it), can mainly be displayed

		int heuristic = Math.abs(endX) + Math.abs(endY); //Gives heuristic value for starting node
		
		Node root = new Node(new AStarStates(heuristic, false)); //root Node has heuristic value (in this case 9)
		Node G = new Node(new AStarStates(0, true)); //Goal Node has heuristic of zero
		
		//temporary nodes for use in grid init
		Node tempNode = root;
		Node tempParent = tempNode;
		// ================ Don't change these ^^^ =================

		

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

		// ================ Run A* Search ================

		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(root);
		


	}

}
