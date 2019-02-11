package core;

import java.util.ArrayList;

public class Match {
	private int matchId = 0;
	private Player[] players;
	MatchStatusEnum status;

	public Match(Player player1, Player player2) {
		this.matchId = matchId++;
		this.players = new Player[2];
		this.players[0] = player1;
		this.players[1] = player2;
		this.status = MatchStatusEnum.NOT_PLAYED;
	}

	/**
	 * Returns the list of players currently in this tournament.
	 */
	public ArrayList<String> getPlayers() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Player p : players) {
			String e = p.getName();
			lijst.add(e);
		}
		return lijst;
	}
	
	public int getMatchId() {
		return matchId;
	}

	public String toString() {
		return "" + matchId + " " + getPlayers() + " " + status;
	}
	
}
