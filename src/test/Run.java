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
/*		at.addPlayer("Wesley");
		at.addPlayer("Martijn");
		at.addPlayer("Arjan");
		at.addPlayer("MartijnB");*/
		System.out.println(at.getAllPlayers().toString() + "\n");
		System.out.println("\t");
		System.out.println("Amount of players = " + at.getAllPlayers().size());
//		System.out.println(at.getPlayer("a r J a n")  + "\n");
		System.out.println("\t");
//		at.closeInscription();
		System.out.println("Inscription = " + at.isInscriptionsOpen());
		System.out.println("\t");
		at.closeInscription();
		System.out.println("\t");
		System.out.println("Inscription = " + at.isInscriptionsOpen());
		at.showRounds();
		
			
	}
}
