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
        int h;
        //h = Math.abs(G.value - this.value))+Math.abs(G.value - this.value));
        
		return 0;
	}

	@Override
	public String toString() {
		return "IntegerState [value=" + value + ", goal=" + goal + "]";
	}

}