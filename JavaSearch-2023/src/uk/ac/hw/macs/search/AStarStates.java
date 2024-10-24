package uk.ac.hw.macs.search;

public class AStarStates implements State {

    public Grid[][] grid;

    private int startX, startY;

	private int goalX, goalY;
    
    //Run in main to assign H value to nodes
    public int getHeuristic() {
            //Manhatten Distance formula, sum of absolute values of 
            //the difference between the goal's coordinates and the current nodes coordinates
            int h = 0; //temp
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    grid[i][j] = new Grid(i, j);
                    grid[i][j].heuristicCost = Math.abs(i - goalX) + Math.abs(j - goalY);
                    grid[i][j].solution = false;
                }
            }

            return h;
    }


    //check if current node solution is true
    //TODO Fix this return to work
	public boolean isGoal(int i, int j) {
		return grid[i][j].solution;
	}
    
    @Override
    public boolean isGoal() {
        return false;
    }

}