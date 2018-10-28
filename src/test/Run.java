package test;

import core.ArenaTournament;
import exceptions.ArenaException;

public class Run {

	public static void main(String[] args) throws ArenaException {
		ArenaTournament at = new ArenaTournament();

		at.addPlayer("Chris");
		at.addPlayer("Yoda");
		at.addPlayer("Mitchel");
		at.addPlayer("Mike");
		at.addPlayer("Wesley");
		at.addPlayer("Martijn");
		at.addPlayer("Arjan");
		at.addPlayer("MAG01NIET");
			
		System.out.println("Players in this Tournament are: " + at.getAllPlayers().toString());
		System.out.println("Amount of players in this Tournament are: " + at.getAllPlayers().size());
		System.out.println(at.getAllPlayers().get(0));
		
		
	}
}
