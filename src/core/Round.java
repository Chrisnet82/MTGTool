package core;

public class Round {
	private int roundNumber = 0;
	private int maxRounds = 0;
	
	public Round() {
		this.roundNumber++;
	}
	
	public int getMaxRounds() {
		return maxRounds;
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
	
	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

}
