package com.genios.bowling;

public class Frame {
	
	private Integer index;
	private Integer roll1;
	private Integer roll2;
	private Integer roll3;
	private Integer score;
	
	private Boolean isStrike;
	private boolean isSpare;
	private boolean isMiss;
	private boolean isLastFrame;
	
	
	private String placeHolder1;
	private String placeHolder2;
	private String playerName;
	private Boolean isComplete;
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getRoll1() {
		return roll1;
	}
	public void setRoll1(Integer roll1) {
		this.roll1 = roll1;
	}
	public Integer getRoll2() {
		return roll2;
	}
	public void setRoll2(Integer roll2) {
		this.roll2 = roll2;
	}
	public Integer getRoll3() {
		return roll3;
	}
	public void setRoll3(Integer roll3) {
		this.roll3 = roll3;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Boolean isStrike() {
		return isStrike;
	}
	public void setStrike(Boolean isStrike) {
		this.isStrike = isStrike;
	}
	public boolean isSpare() {
		return isSpare;
	}
	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}
	public boolean isMiss() {
		return isMiss;
	}
	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}
	public boolean isLastFrame() {
		return isLastFrame;
	}
	public void setLastFrame(boolean isLastFrame) {
		this.isLastFrame = isLastFrame;
	}
	public String getPlaceHolder1() {
		return placeHolder1;
	}
	public void setPlaceHolder1(String placeHolder1) {
		this.placeHolder1 = placeHolder1;
	}
	public String getPlaceHolder2() {
		return placeHolder2;
	}
	public void setPlaceHolder2(String placeHolder2) {
		this.placeHolder2 = placeHolder2;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Boolean isComplete() {
		return isComplete;
	}
	public void setComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	

}
