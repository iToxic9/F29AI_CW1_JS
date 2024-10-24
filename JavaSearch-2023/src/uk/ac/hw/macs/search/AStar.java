package uk.ac.hw.macs.search;

public class AStar {

	//Node S = new Node(null);
	
	private Grid[][] grid;

	
	

	public AStar(int width, int height, int startX, int startY, int goalX, int goalY) {
        grid = new Grid[width][height];
    }

	
	
	public static void main(String[] args) {

		//Node OUT = new Node());
		
		//Grid 1
		
		
		
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(null);
		
	}

}
