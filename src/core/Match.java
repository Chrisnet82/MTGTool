package core;

import java.util.ArrayList;

import exceptions.ArenaException;

public class Match {
	private Round round;
	private int maxRounds = 0;
	
	public Match() {
		this.round = new Round();
	}

	public void startMatch(Group group) {
		int r = round.getRoundNumber();

		if(r <= 0) {
			new ArenaException("round did not generate correctly.");
		}else if(r >= 1) {
			nextRound();
		}
	}		
	
	private void nextRound() {
		round.nextRound();
	}


}
