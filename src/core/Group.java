package core;

import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Player> Players;
	private Match match = null;
	
	public Group(String name) {
		this.name = name;
		Players = new ArrayList<Player>();
		match = new Match();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			
	public void addPlayer(String name, Group g) {
		if(!playerExist(name)) {
			Player player = new Player(name, g);
			Players.add(player);
		}
	}

	public ArrayList<Player> getAllPlayers(){
		return this.Players;
	}
	
	public ArrayList<String> getNames() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Player p : Players) {
			String e = p.getName();
			lijst.add(e);
		}
		return lijst;
	}
	
	private ArrayList<Integer> getPoints() {
		ArrayList<Integer> lijst = new ArrayList<Integer>();
		for(Player p : Players) {
			int e = p.getPoints();
			lijst.add(e);
		}
		return lijst;
	}
	
	private ArrayList<String> getSeats() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Player p : Players) {
			String e = p.getSeat();
			lijst.add(e);
		}
		return lijst;
	}
		
	private boolean playerExist(String name) {
		for(Player player : Players) {
			if(player.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return name + " - " + Players.toString();
	}
}
