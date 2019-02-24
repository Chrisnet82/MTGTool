package core;

import java.util.ArrayList;
import java.util.Iterator;
import exceptions.ArenaException;

public class ArenaTournament {
	private ArrayList<Player> players;
	private ArrayList<Round> rounds;
	private int maxRounds = 0;
	private boolean inscriptionsOpen;
	private int totalMatchPerRound = 0;
	
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

	/**
	 * Werkt DIT?, nee!
	 * @return
	 */
	public ArrayList<String> showRounds(){
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
	 */
	public void closeInscription() {
		this.inscriptionsOpen = false;
		this.rounds = new ArrayList<Round>();
		setMaxRounds();
		AddByePlayerIfNeeded();
		scheduleTournament(players.size(), maxRounds);
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
			bye.setPoints(0);
			bye.setSeat("Z");
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
			throw new ArenaException("Minimal amount of players needs to be 3.");
		}
	}
	
	/**
	 * Set the integer value of amount of matches in this tournament.
	 * @return
	 * @throws ArenaException
	 */
	private int setTotalMatchPerRound() throws ArenaException {
		if(isInscriptionsOpen()) {
			throw new ArenaException("Inscription must be closed before setting rounds.");
		}else {
			return players.size() / 2;
		}
	}
	
	/**
	 * FOUND ONLINE TESTING: https://sites.google.com/site/mywaydevilsway/round-robin-scheduling-algorithm 
	 * @param teams = Players.size?
	 * @param round = amound of rounds?
	 */
	private void scheduleTournament(int teams, int round) {
		if (((teams%2 != 0) && (round != teams - 1))||(teams <= 0))
			throw new IllegalArgumentException();
		int[] cycle = new int[teams];
		int n = teams /2;
		for (int i = 0; i < n; i++) {				
			cycle[i] = i + 1;
			cycle[teams - i - 1] = cycle[i] + n;
		}			
				
		for(int d = 1; d <= round; d++) {
			System.out.println(String.format("Round %d", d));
			for (int i = 0; i < n; i++) {					
				System.out.println(String.format("Player %d - Player %d",cycle[i],cycle[teams - i - 1]));					 
			}	
			int temp = cycle[1];
			for (int i = 1; i < teams - 1; i++) {
				int pr = cycle[i+1];
				cycle[i+1] = temp;
				temp = pr;
			}
			cycle[1] = temp;		
		}
	}
	

}