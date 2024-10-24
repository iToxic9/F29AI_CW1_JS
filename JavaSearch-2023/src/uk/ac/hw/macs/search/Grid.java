package uk.ac.hw.macs.search;

public class Grid {

    public int h, w; //Height, Width

    public Node parent;

    public int heuristicCost;

    public boolean solution;

    public int fCost;

    public Grid(int h, int w) {
        this.h = h;
        this.w = w;
    }

}