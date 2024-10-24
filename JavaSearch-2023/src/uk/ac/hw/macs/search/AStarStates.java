package uk.ac.hw.macs.search;

public class AStarStates implements State {

    private int value;
	private boolean goal;
	
	public AStarStates (int value) {
		this(value, false);
	}
	
	public AStarStates (int value, boolean goal) {
		this.value = value;
		this.goal = goal;
	}

	@Override
	public boolean isGoal() {
        return this.goal;
	}

	@Override
	public int getHeuristic() {
		return this.value; //heuristic calculation done in AStar.java --> Create grid
	}

	@Override
	public String toString() {
		return "IntegerState [value=" + value + ", goal=" + goal + "]";
	}

}