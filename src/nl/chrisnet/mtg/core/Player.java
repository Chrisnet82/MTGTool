package nl.chrisnet.mtg.core;

public class Player{
	private String Name = "";
	private int Points = 0;
		
	public Player (String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}
	
	public String toString() {
		return Name;
	}
}
