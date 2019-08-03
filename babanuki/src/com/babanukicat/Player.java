package com.babanukicat;

public class Player {
	
	private Master master;
	
	private Table table;
	
	private Hand myHand = new Hand();
	
	private String name;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 */
	public Player(String name, Master master, Table table) {
		this.name = name;
		this.master = master;
		this.table = table;
	}
	
	/**
	 * 順番を指名する
	 * 
	 * @param nextPlayer
	 */
	public void play(Player nextPlayer) {
		Hand nextHand = nextPlayer.showHand();
		
		Card pickedCard = nextHand.pickCard();
		
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		
		dealCard(pickedCard);
		
		if(myHand.getNumberOfCards() == 0) {
			master.declareWin(this);
		}else {
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
	}
	
	/**
	 * 手札を見せる
	 * 
	 * @return
	 */
	public Hand showHand() {
		if(myHand.getNumberOfCards() == 1) {
			master.declareWin(this);
		}
		myHand.shuffle();
		return myHand;
	}
	
	/**
	 * カードを受け取る
	 * 
	 * @param card
	 */
	public void receiveCard(Card card) {
		dealCard(card);
	}
	
	/**
	 * 自分の手札にカードを足し、同じカードがあれば捨てる
	 * 
	 * @param card
	 */
	private void dealCard(Card card) {
		myHand.addCard(card);
		
		Card[] sameCards = myHand.findSameNumberCard();
		
		if(sameCards != null) {
			System.out.println(this + ":");
			table.disposedCard(sameCards);
		}
	}
	
	/**
	 * プレイヤーの名前を返す
	 */
	public String toString() {
		return name;
	}

}
