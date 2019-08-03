package com.jankencat.person;

public class Player {
	public static final int STONE = 0;
	public static final int SCISSORS = 1;
	public static final int PAPER = 2;
	
	private Tactics tactics;
	
//	名前
	private String name;
	
//	勝ち数
	private int winCount = 0;
	
//	手を決める
	public int showHand() {
		
		int hand = tactics.readTactics();
		
//		int hand = 0;
//		
//		double randomNum = Math.random() * 3;
//		
//		if(randomNum < 1) {
//			hand = STONE;
//		}else if(randomNum < 2) {
//			hand = SCISSORS;
//		}else if(randomNum < 3) {
//			hand = PAPER;
//		}
		return hand;
	}
	
//	審判から勝敗を知る
	public void notifyResult(boolean result) {
		if(true == result) {
			winCount += 1;
		}
	}
	
//	勝った回数を答える
	public int getWinCount() {
		return winCount;
	}
	
//	コンストラクタ
	public Player(String name) {
		this.name = name;
	}
	
//	getter setter
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	void setTactics(Tactics tactics) {
		this.tactics = tactics;
	}
}
