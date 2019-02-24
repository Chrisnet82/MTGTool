package test;

import core.ArenaTournament;
import exceptions.ArenaException;

public class Run {

	public static void main(String[] args) throws ArenaException {
		ArenaTournament at = new ArenaTournament();
		at.addPlayer("Player1");
		at.addPlayer("Player2");
		at.addPlayer("Player3");
		at.addPlayer("Player4");
		at.addPlayer("Player5");
		at.addPlayer("Player6");
		at.addPlayer("Player7");
		at.addPlayer("Player8");
		at.addPlayer("Player9");
		at.addPlayer("Player10");
//		at.addPlayer("Player11");
//		at.addPlayer("Player12");
//		at.addPlayer("Player13");
//		at.addPlayer("Player14");
//		at.addPlayer("Player15");
//		at.addPlayer("Player16");
		System.out.println(at.getAllPlayers() + "\n");
		System.out.println("Amount of players = " + at.getAllPlayers().size());
		System.out.println("\t");
		at.closeInscription();

	}
}
