package com.genios.bowling;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

public class BowlingForm {

	private String playerName;

	@Valid
	private List<Frame> bowlingFrames;

	private String errorMessage;



	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private Integer score;
	private boolean isGameOver;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List< Frame> getBowlingFrames() {
		return bowlingFrames;
	}
	public void setBowlingFrames(List<Frame> bowlingFrames) {
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
