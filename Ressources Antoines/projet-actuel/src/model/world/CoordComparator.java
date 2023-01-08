package model.world;

import java.util.Comparator;

import java.lang.Math;

import model.agents.Agent;

public class CoordComparator implements Comparator<Agent> {

	public CoordComparator() {
		
	}

	@Override
	public int compare(Agent o1, Agent o2) {
		if ( o1.getCoord() == o2.getCoord() ) {
			return 0;
		}
		
		int dx = (int) (o1.getCoord().getX() - o2.getCoord().getX());
		if (dx !=0) {
			return (int) Math.signum(dx);
		}
		
		int dy = (int) (o1.getCoord().getY() - o2.getCoord().getY());
		if (dy !=0) {
			return (int) Math.signum(dy);
		}
		return 0;
	}
}
