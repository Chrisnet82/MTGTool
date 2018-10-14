package core;

public class Run {

	public static void main(String[] args) {
		ArenaTournament at = new ArenaTournament();
		
		at.addGroup("T");
		at.addGroup("Te");
		at.addGroup("Tes");
		at.addGroup("Test");

		System.out.println("Current Groups are: " + at.getAllGroups());
		System.out.println(" ");
		at.addPlayerToGroup("Piet", "T");
		at.addPlayerToGroup("Jan", "T");
		at.addPlayerToGroup("klaas", "Te");
		at.addPlayerToGroup("Elbert", "Tes");
		at.addPlayerToGroup("Willy", "Test");
		at.addPlayerToGroup("Dirk", "Te");
		at.addPlayerToGroup("Pieter", "Tes");
		at.addPlayerToGroup("Ruud", "Test");
		at.addPlayerToGroup("Ruud", "Test");
		at.addPlayerToGroup("Pieter", "Test");
		
		System.out.println(" ");
		System.out.println(at.getGroupPlayers("T"));
		
		System.out.println(" ");
		System.out.println(at.getGroupPlayers("Te"));
		
		System.out.println(" ");
		System.out.println(at.getGroupPlayers("Tes"));
		
		System.out.println(" ");
		System.out.println(at.getGroupPlayers("Test"));
		
		System.out.println(" ");
		System.out.println(at.getGroupPlayers("FOUT"));
	
	}

}
