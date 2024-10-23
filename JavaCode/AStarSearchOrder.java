package uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

public class AStarSearchOrder implements SearchOrder{


	public void addToFringe(List<FringeNode> frontier, FringeNode parent1,FringeNode parent2, Set<ChildWithCost> children) {
		// Add them at the end, ignoring the cost
				for (ChildWithCost child : children) {
					frontier.add(new FringeNode(child.node, parent1, child.cost));
				}
	}
}