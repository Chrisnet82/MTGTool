package core;

import java.util.ArrayList;

public class Round {
	private int roundNumber = 0;
	private int totalMatchPerRound = 0;
	private ArrayList<Match> matches;
	
	public Round(ArrayList<Player> players, int totalMatchPerRound) {
		this.roundNumber++;
		this.matches = new ArrayList<Match>();
		this.totalMatchPerRound = totalMatchPerRound;
	}
		
	public void setRoundNumner(int number) {
		this.roundNumber = number;
	}
	
	public int getRoundNumber() {
		return roundNumber;
	}

	public void nextRound() {
		roundNumber = roundNumber + 1;		
	}
	
	public void previousRound() {
		roundNumber--;
	}

	public void getMatchId() {
		
	}
	
	/**
	 * Returns the list of players currently in this tournament.
	 */
	public ArrayList<String> getAllMatches() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Match m : matches) {
			String e = m.toString();
			lijst.add(e);
		}
		return lijst;
	}
	
	public void addMatch(Player p1, Player p2) {
		Match match = new Match(p1, p2);
		matches.add(match);
	}
	
	public String toString() {
		return "" + roundNumber + " " + getAllMatches();
	}
	
}
