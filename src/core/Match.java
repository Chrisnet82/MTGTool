package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Match {
	private ArrayList<Player> Players = new ArrayList<Player>();
	private Timer timer = null;
//	private TimerTask task = new TimerTask();
	
	public String getPlayer(String name) {
		for(Player player : Players) {
			if(player.getName().equals(name)) {
				return player.getName();
			}
		}
		return null;
	}

	public void addPlayer(String name) {
		if(getPlayer(name) == null) {
			Player player = new Player(name);
			Players.add(player);
		}
	}

	public String timerElapsed() {
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;
		while (elapsedTime < 2*60*1000) {
			//perform db poll/check
			elapsedTime = (new Date()).getTime() - startTime;
			return "" + elapsedTime;
		}
		return "" + elapsedTime;
	}

}
