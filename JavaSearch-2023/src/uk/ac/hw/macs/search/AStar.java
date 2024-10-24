package uk.ac.hw.macs.search;

import java.util.Map;
import java.util.TreeMap;

public class AStar {
	
	public static void main(String[] args) {

		//Node OUT = new Node());
		
		//Grid 1
		Node S = new Node(new AStarStates(0, false));
		Node G = new Node(new AStarStates(1, true));

		final String[] whiteCells = {"a","c","d","h","j","k","l","m","q"};
		final String[] grayCells = {"b","e","f","i","n","o","p","r","t"};
		Map<String, Node>  frontier = new TreeMap<String, Node>();

		//Create Grid
		//20 Nodes including Start and Goal
		//White cells
		for (int i = 0; i < whiteCells.length; i++) {
			frontier.put(whiteCells[i], new Node(new AStarStates(1))); //Creates white cells
		}
		//Gray cells
		for (int i = 0; i < grayCells.length; i++) {
			frontier.put(grayCells[i], new Node(new AStarStates(2))); //Creates gray cells
		}
		
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(null);
		
	}

}
