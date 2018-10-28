package core;

import java.util.ArrayList;

import exceptions.ArenaException;

public class ArenaTournament {
	private ArrayList<Player> players;
	private Round round;

	/*
	 * Constructor of this Tournament, that generates a empty list of players and a instance of round 1. 
	 */
	public ArenaTournament() {
		players = new ArrayList<Player>();
		this.round = new Round();
	}	

	/*
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

	/*
	 * Clears all players in the list of this tournament.
	 */
	public void removeAllPlayers() {
		players.clear();
	}

	/*
	 * Return string of a existing player name.
	 */
	public String getPlayer(String name) {
		if(playerExist(name)) {
			return name;
		}
		return null;
	}

	/*
	 * Add a player to the player list of this tournament.
	 * @Var enter String value of the Players name, that can only be letters, and no spaces.
	 */
	public void addPlayer(String playerName) throws ArenaException {
		if(!playerExist(playerName) && (!checkPlayerName(playerName))) {
			Player p = new Player(playerName);
			players.add(p);
		} else if(playerExist(playerName)){
			throw new ArenaException("Player with this name " + playerName + " already exist.");			
		}else if(checkPlayerName(playerName)) {
			throw new ArenaException("The name " + playerName + " is not valid as a name.");
		}
	}

	/*
	 * @return the value of the maximum rounds to be played.
	 */
	public int getMaxRounds() {
		return round.getMaxRounds();
	}


	/*
	 * AutoSet the maximum rounds of this Tournament.
	 * Max rounds is determined by the amount of players -1, you cant play yourself.
	 */
	private void setMaxRounds() {
		round.setMaxRounds(players.size()-1);
	}


	/*
	 * Check if the string value is already present in list of players.
	 * @return true if name is found.
	 * @return false if name isn't found.
	 */
	private boolean playerExist(String name) {
		for(Player p : players) {
			if(p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Check if the string name uses right characters.
	 * @return true if name uses false characters or is a empty string.
	 * @return false is name has no false characters.
	 */
	private boolean checkPlayerName(String name) {
		if(!name.matches("[a-zA-Z]+") || name.contains(" ") || name.equals(null) || name.equals("")) {
			return true;
		}
		return false;
	}
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
//}