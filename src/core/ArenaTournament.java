package core;

import java.util.ArrayList;

public class ArenaTournament {
	private ArrayList<Group> Group;

	public ArenaTournament() {
		Group = new ArrayList<Group>();
	}	

	public ArrayList<String> getGroupPlayers(Group p) {
		return p.getNames();
	}

	public ArrayList<String> getGroupPlayers(String group){
		if(!checkGroupName(group)) {
			for(Group p : Group) {
				if(p.getName().equals(group)) {
					return p.getNames();
				}
			}
			System.out.println("Groupname: " + "'" + group + "'" + " not found");
			return null;
		}else {
			System.out.println("Error in Groupname: " + "'" + group + "'");
			return null;	
		}
	}

	public ArrayList<String> getAllGroups() {
		ArrayList<String> lijst = new ArrayList<String>();
		for(Group g : Group) {
			String e = g.getName();
			lijst.add(e);
		}
		return lijst;
	}

	public void addGroup(String name) {
		if(!groupExist(name) && (!checkGroupName(name))) {
			Group g = new Group(name);
			Group.add(g);
		}else{
			System.out.println("Error in Groupname: " + "'" + name + "'");
		}
	}

	public String getGroup(String name) {
		if(groupExist(name)) {
			return name;
		}
		return "Group doenst exist";
	}

	public void addPlayerToGroup(String playerName, String groupName) {
		if(groupExist(groupName) && (!checkGroupName(groupName))) {
			for(Group p : Group) {
				if(p.getName().equals(groupName)) {
					p.addPlayer(playerName, p);
					System.out.println("Player: " + "'" + playerName + "'" + " added Succesfully to Group: " + p.toString());
				}
			}
		}
		else {
			System.out.println("Player: " + playerName + " failed to added to the group: " + groupName);
		}
	}

	private boolean groupExist(String name) {
		for(Group group : Group) {
			if(group.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkGroupName(String name) {
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
//	rowData[0] = list.get(i).name;
//	rowData[0] = list.get(i).nogiets;
//	model.addRow(rowData);
//}
//}