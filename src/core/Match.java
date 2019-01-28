package core;

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

	public int getMatchId() {
		return matchId;
	}

	
}
