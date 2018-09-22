package core;

import java.util.ArrayList;

public class Player {
	private static int Id = 0;
	private String Name = "";
	private int Points = 0;
	
	public Player (String name) {
		this.Id = Id+1;
		this.Name = name;
		this.Points = 0;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}
