package core;

public class run {

	public static void main(String[] args) {
		Match ma = new Match();
		
		ma.addGroup("T");
		ma.addGroup("Te");
		ma.addGroup("Tes");
		ma.addGroup("Test");
		
		ma.addGroup("T e s t");
		System.out.println(" ");
		System.out.println(ma.getAllGroups());
		System.out.println(" ");
		ma.addPlayerToGroup("Piet", "T");
		ma.addPlayerToGroup("Jan", "T");
		ma.addPlayerToGroup("klaas", "Te");
		ma.addPlayerToGroup("Elbert", "Tes");
		ma.addPlayerToGroup("Willy", "Test");
		ma.addPlayerToGroup("Dirk", "Te");
		ma.addPlayerToGroup("Pieter", "Tes");
		ma.addPlayerToGroup("Ruud", "Test");
		ma.addPlayerToGroup("Ruud", "Test");
		
		System.out.println(" ");
		System.out.println(ma.getGroupPlayers("T"));
		
		System.out.println(" ");
		System.out.println(ma.getGroupPlayers("Te"));
		
		System.out.println(" ");
		System.out.println(ma.getGroupPlayers("Tes"));
		
		System.out.println(" ");
		System.out.println(ma.getGroupPlayers("Test"));
		
		System.out.println(" ");
		System.out.println(ma.getGroupPlayers("FOUT"));
	
	}

}
