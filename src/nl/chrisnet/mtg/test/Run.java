package nl.chrisnet.mtg.test;

import java.util.ArrayList;

import nl.chrisnet.mtg.core.ArenaException;
import nl.chrisnet.mtg.core.ArenaTournament;

public class Run {

	public static void main(String[] args) throws ArenaException {
		ArenaTournament at = new ArenaTournament();
		at.addPlayer("Chris");
		at.addPlayer("Mitchel");
		at.addPlayer("Yoda");
		at.addPlayer("Mark");
//		at.addPlayer("Martijn5");
//		at.addPlayer("Mike6");
//		at.addPlayer("Chantal7");
//		at.addPlayer("Pieter8");
//		at.addPlayer("Stefan9");
//		at.addPlayer("Dirk10");
//		at.addPlayer("Mathijs11");
//		at.addPlayer("Wil12");
//		at.addPlayer("Kyler13");
//		at.addPlayer("Andre14");
//		at.addPlayer("Freek15");
//		at.addPlayer("Ruud16");
		System.out.println(at.getAllPlayers() + "\n");
		System.out.println("Amount of players = " + at.getAllPlayers().size());
		System.out.println("\t");
		at.closeInscription();
		System.out.println("Amount of players = " + at.getAllPlayers().size());
	}
}
