package uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

public class AStarSearchOrder implements SearchOrder {


	public void addToFringe(List<FringeNode> frontier, FringeNode parent1,FringeNode parent2, Set<ChildWithCost> children) {
		// Add them at the end, ignoring the cost
				for (ChildWithCost child : children) {
					frontier.add(new FringeNode(child.node, parent1, child.cost));
				}
	}
}

public class AStarStates implements State {

	public void isGoal() {
		if(searchNode.node.getHeuristic == 0) {
			return 1; //CurrentNode is goal node
		} else {
			return 0; //CurrentNode is not goal
		}

	}

	public void getHeuristic() {
		//Manhatten Distance formula, sum of absolute values of 
		//the difference between the goal's coordinates and the current nodes coordinates
		int h;
		h = absolute(node.goal.getValue - searchNode.node.getValue);
		return h;
	}

}
