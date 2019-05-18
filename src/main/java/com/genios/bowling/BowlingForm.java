package com.genios.bowling;

import java.util.List;
import java.util.Map;

public class BowlingForm {
	
	private String playerName;
	private Map<Integer, Frame> bowlingFrames;
	private Integer score;
	private boolean isGameOver;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Map<Integer, Frame> getBowlingFrames() {
		return bowlingFrames;
	}
	public void setBowlingFrames(Map<Integer, Frame> bowlingFrames) {
		this.bowlingFrames = bowlingFrames;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	
	
	
	

}
