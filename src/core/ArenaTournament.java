package core;

import java.util.ArrayList;

import exceptions.ArenaException;

public class ArenaTournament {
	private ArrayList<Player> players;

	public ArenaTournament() {
		players = new ArrayList<Player>();
	}	

	public ArrayList<String> getAllPlayers() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Player p : players) {
			String e = p.getName();
			lijst.add(e);
		}
		return lijst;
	}

	public String getPlayer(String name) {
		if(playerExist(name)) {
			return name;
		}
		return "Player doenst exist";
	}

	public void addPlayer(String playerName) {
		Player p = new Player(playerName);
		if(!playerExist(playerName) && (!checkPlayerName(playerName) && (!playerName.equals("")))) {
			players.add(p);
		}
		else {
			new ArenaException("Failed to add Player: " + playerName);
		}
	}

	private boolean playerExist(String name) {
		for(Player p : players) {
			if(p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkPlayerName(String name) {
		if(name.contains(" ") || name.contains("_")  || name.equals(null)) {
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