package core;

import java.util.ArrayList;
import java.util.Iterator;
import exceptions.ArenaException;

public class ArenaTournament {
	private ArrayList<Player> players;
	private ArrayList<Round> rounds;
	private int maxRounds = 0;
	private boolean inscriptionsOpen;

	/**
	 * Constructor of this Tournament, that generates a empty list of players and a instance of round 1. 
	 */
	public ArenaTournament() {
		this.players = new ArrayList<Player>();
		this.inscriptionsOpen = true;
	}	

	/**
	 * Returns the list of players currently in this tournament.
	 */
	public ArrayList<String> getAllPlayers() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Player p : players) {
			String e = p.getName();
			lijst.add(e);
		}
		return lijst;
	}

	/**
	 * Clears all players in the list of this tournament.
	 */
	private void removeAllPlayers() {
		players.clear();
	}

	/**
	 * Search player list of the given String.
	 * If it finds a match, gives back the name from the playerlist.
	 */
	public String getPlayer(String name) {
		String n = name.toUpperCase().replaceAll("[0-9_ ]", "");
		Iterator<String> it = getAllPlayers().iterator();
		while(it.hasNext()) {
			String playerName = it.next();
			String n2 = playerName.toUpperCase();
			if(n.equals(n2)) {
				return playerName;
			}
		}
		return "Player not found";
	}

	/**
	 * Add a player to the player list of this tournament.
	 * @Var enter String value of the Players name, that can only be letters, and no spaces.
	 */
	public void addPlayer(String playerName) throws ArenaException {
		if(!playerExist(playerName) && (!checkPlayerName(playerName)) && (inscriptionsOpen)) {
			Player p = new Player(playerName);
			players.add(p);
		}else {
			throw new ArenaException("Inscription to this tournament isn't open."); 
		}
	}

	public String amountOfPlayers() {
		return "" + players.size();
	}
	
	/**
	 * Werkt DIT?, niet wat ik verwacht!! genereerd een lijst met intern rounds, maar toont ze niet!.
	 * @return
	 */
	public ArrayList<String> getRounds(){
		ArrayList<String> lijst = new ArrayList<String>();
		for(Round r : rounds) {
			lijst.add(r.toString());
		}
		return lijst;
	}

	/**
	 * @return the value of the maximum rounds to be played.
	 */
	public int getMaxRounds() {
		return maxRounds;
	}

	/**
	 * AutoSet the maximum rounds of this Tournament.
	 * Max rounds is determined by the amount of players -1, you can't play yourself.
	 */
	private void setMaxRounds() {
		maxRounds = players.size()-1;
	}

	/**
	 * getter is InscriptionsOpen()?
	 * @return true if so.
	 */
	public boolean isInscriptionsOpen() {
		return inscriptionsOpen;
	}

	/**
	 * Players are added to tournament and is set to start.
	 * InscriptionOpen get status 'closed'.
	 * @throws ArenaException 
	 */
	public void closeInscription() throws ArenaException {
		this.inscriptionsOpen = false;
		checkPlayerSize();
		AddByePlayerIfNeeded();
		setMaxRounds();
		scheduleTournamentTest(players);
	}

	/**
	 * Players are all removed from tournament and is reset.
	 * InscriptionOpen get status 'Open'.
	 */
	public void openInscription() {
		removeAllPlayers();
		this.inscriptionsOpen = true;
	}

	/**
	 * Check if the string value is already present in list of players.
	 * @return exception if name is found.
	 * @return false if name isn't found.
	 */
	private boolean playerExist(String name) throws ArenaException {
		for(Player p : players) {
			if(p.getName().equals(name)) {
				throw new ArenaException("Player with name " + name + " already exist.");
			}
		}
		return false;
	}

	/**
	 * Check if the string name uses right characters.
	 * @return exception if name uses false characters or is a empty string.
	 * @return false is name has no false characters.
	 */
	private boolean checkPlayerName(String name) throws ArenaException {
		if(!name.matches("[a-zA-Z0-9]+")|| name.contains(" ") || name.equals(null) || name.equals("")) {
			throw new ArenaException("The name " + name + " is not valid as a name.");
		}
		return false;
	}

	/**
	 * Checks if the amount of players in tournament is uneven.
	 * If so adds a player "Bye".
	 */
	private void AddByePlayerIfNeeded() {
		if((players.size()%2) == 1) {
			Player bye = new Player("Bye");
			players.add(bye);
		}
	}

	/**
	 * Checks if the amount of players is lager then 2.
	 * @return
	 * @throws ArenaException
	 */
	private boolean checkPlayerSize() throws ArenaException {
		if(players.size() > 2) {
			return true;
		}else {
			throw new ArenaException("Minimum number of players needs to be 3.");
		}
	}

	/**
	 * Generates the tournament schedule that lets every player vs other player in this tournament.
	 * @param players
	 * @return List of Rounds and Matches.
	 * @resource https://sites.google.com/site/mywaydevilsway/round-robin-scheduling-algorithm 
	 */
	public ArrayList<Round> scheduleTournamentTest(ArrayList<Player> players) {
		int amountOfPlayers = players.size();
		int amountOfRounds = players.size()-1;
		//ArrayList<Round> roundTest = new ArrayList<Round>();
		this.rounds = new ArrayList<Round>();

		if (((amountOfPlayers%2 != 0) && (amountOfRounds != amountOfPlayers - 1))||(amountOfPlayers <= 0)) { 
			throw new IllegalArgumentException();
		}

		int[] cycle = new int[amountOfPlayers]; //create a integer array the size of the amount of players.
		int amountOfMatchesPerRound = amountOfPlayers /2; // amount of matches per Round.

		//set a Array of integers to create list of player ids.
		for (int i = 0; i < amountOfMatchesPerRound; i++) {	
			cycle[i] = i + 1;
			cycle[amountOfPlayers - i - 1] = cycle[i] + amountOfMatchesPerRound;
		}		
		
		//loop to set every round .
		for(int d = 1; d <= amountOfRounds; d++) {
			Round r = new Round(d);

			//set players from the Integer Array list in position
			ArrayList<Player> newListPlayers = new ArrayList<Player>();	
			for(int j : cycle) {
				newListPlayers.add(players.get(j-1));
			}
			
			// Loop in this round loop to set players in Matches.
			for (int i = 0; i < amountOfMatchesPerRound; i++) {						
				r.addMatch(newListPlayers.get(i), newListPlayers.get(amountOfPlayers - i - 1));
			}
			rounds.add(r);

			//Move integers array around to get players on new positions for next round.
			int temp = cycle[1];
			for (int i = 1; i < amountOfPlayers - 1; i++) {
				int pr = cycle[i+1];
				cycle[i+1] = temp;
				temp = pr;
			}
			cycle[1] = temp;
		}
		//System.out.println(rounds.toString());
		return rounds;
	}

}