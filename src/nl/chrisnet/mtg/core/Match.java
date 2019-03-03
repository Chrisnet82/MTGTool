package nl.chrisnet.mtg.core;

public class Match {
	private int matchId = 0;
	private Player player1;
	private Player player2;
	MatchStatusEnum status;

	public Match(Player player1, Player player2) {
		this.matchId = matchId++;
		this.player1 = player1;
		this.player2 = player2;
		this.status = MatchStatusEnum.NOT_PLAYED;
	}
	
	public MatchStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MatchStatusEnum status) {
		this.status = status;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getMatchId() {
		return matchId;
	}

	@Override
	public String toString() {
		return "" + getPlayer1().getName() + " vs " + getPlayer2().getName() + "\n";
	}
	
}
