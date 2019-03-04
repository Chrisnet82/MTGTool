package nl.chrisnet.mtg.core;

import java.util.ArrayList;

public class Round {
	private int roundNumber = 0;
	private ArrayList<Match> matches;
	
	public Round(int roundNumber) {
		this.roundNumber = roundNumber;
		this.matches = new ArrayList<Match>();
	}
			
	public int getRoundNumber() {
		return roundNumber;
	}

	public String getMatch(int index) {
		if(index < matches.size()) {
		return matches.get(index).toString();
		}
		return null;
	}
	
	/**
	 * Returns the list of matches and players currently in this round.
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
	
	public void addMatch(Match m) {
		matches.add(m);
	}
		
	public String printPlayer1Name(int matchIndex) {
		return matches.get(matchIndex).getPlayer1().getName();
	}
	
	public String printPlayer2Name(int matchIndex) {
		return matches.get(matchIndex).getPlayer2().getName();
	}
	
	@Override
	public String toString() {
		return "Round " + roundNumber + ": " +"\n" + getAllMatches() + "\n";
	}
	
}
