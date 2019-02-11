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

	/**
	 * Werkt DIT?
	 * @return
	 */
	public ArrayList<String> showRounds(){
		ArrayList<String> lijst = new ArrayList<String>();
		for(Round r : rounds) {
			String x = r.toString();
			lijst.add(x);
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
		generateRounds();
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
		if(!name.matches("[a-zA-Z]+")|| name.contains(" ") || name.equals(null) || name.equals("")) {
			throw new ArenaException("The name " + name + " is not valid as a name.");
		}
		return false;
	}

	/**
	 * Creates a list of rounds for 4 players.
	 * Each round has a internal list of 2 matches.
	 * @return list with rounds and matches.
	 */
	private ArrayList<Round> generateRounds() {
		this.rounds = new ArrayList<Round>();
		Round round = new Round();
		int rn = round.getRoundNumber();
		for(int i=0;i<maxRounds;i++) {		
			if(rn == 1) {
				round.addMatch(players.get(0), players.get(1));
				round.addMatch(players.get(2), players.get(3));
				System.out.println(round.toString());
				rounds.add(round);
				round.nextRound();
			}else if(rn == 2) {
				round.addMatch(players.get(0), players.get(2));
				round.addMatch(players.get(1), players.get(3));
				rounds.add(round);
				round.nextRound();
			}else if(rn == 3) {
				round.addMatch(players.get(0), players.get(3));
				round.addMatch(players.get(1), players.get(2));
				rounds.add(round);
			}		
		}
		return rounds;
	}	

	//public void addRowtoJTable() {
	//DefaultTableModel model = (DefaultTableModel) jTabelx.getModel();
	//ArrayList<Player> pl = Players;
	//Object rowData[] = new Object[3];
	//for(int i = 0; i < pl.size(); i++) {
	//	rowData[0] = list.get(i).id;
	//	rowData[1] = list.get(i).name;
	//	rowData[2] = list.get(i).nogiets;
	//	model.addRow(rowData);
	//}
}