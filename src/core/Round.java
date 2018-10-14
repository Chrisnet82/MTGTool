package core;

public class Round {
	private int roundNumber = 0;
	private Group g;
	
	public Round() {
		this.roundNumber++;
	}
	
	public int getRoundNumber() {
		return roundNumber;
	}

	public void nextRound() {
		roundNumber++;		
	}
	
	public void setScheme(int x) {
		int playerSize = g.getAllPlayers().size();
		
		/*switch (playerSize) {
		case 1: maxRounds = 0;
		break;
		case 2: maxRounds = 1;
		break;
		case 3: maxRounds = 2;
		break;
		case 4: maxRounds = 3;
		break;
		default: maxRounds = 0;
		break;
		}*/
	}
}
