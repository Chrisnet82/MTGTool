package core;

import java.util.ArrayList;

public class Round {
	private int roundNumber = 0;
	//private int totalMatchPerRound = amount of player / 2;
	private ArrayList<Match> matches;
	
	public Round() {
		this.roundNumber++;
		this.matches = new ArrayList<Match>();
	}
		
	public int getRoundNumber() {
		return roundNumber;
	}

	public void nextRound() {
		roundNumber++;		
	}
	
	public void previousRound() {
		roundNumber--;
	}

	public void getMatchId() {
		
	}
	
	public void addMatch(Player p1, Player p2) {
		Match match = new Match(p1, p2);
		matches.add(match);
	}
	
	
}
