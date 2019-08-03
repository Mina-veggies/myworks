package com.babanukicat;

import java.util.ArrayList;

public class Master {

	/**
	 * プレイヤーリスト
	 */
	private ArrayList players = new ArrayList();
	
	/**
	 * ゲームの準備
	 * 
	 * @param cards
	 */
	public void prepareGame(Hand cards) {
		System.out.println("【カードを配ります】");
		
		cards.shuffle();
		
		int numberOfCards = cards.getNumberOfCards();
		
		int numberOfPlayers = players.size();
		
		for(int index = 0; index < numberOfCards; index++) {
			Card card = cards.pickCard();
			
			Player player = (Player) players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}
	
	/**
	 * ゲームを開始
	 */
	public void startGame() {
		System.out.println("\n【ばば抜きを開始します】");
		
		for(int count = 0; players.size() > 1; count++) {
			int playerIndex = count % players.size();
			int nextPlayerIndex = (count + 1) % players.size();
			
			Player player = (Player) players.get(playerIndex);
			
			Player nextPlayer = (Player) players.get(nextPlayerIndex);
			
			System.out.println("\n" + player + "さんの番です");
			player.play(nextPlayer);
		}
		System.out.println("【ばば抜きを終了しました】");
	}
	
	/**
	 * 上がりを宣言
	 * 
	 * @param winner
	 */
	public void declareWin(Player winner) {
		System.out.println(winner + "さんが上がりました！");
		
		players.remove(players.indexOf(winner));
		
		if(players.size() == 1) {
			Player loser = (Player) players.get(0);
			System.out.println(loser + "さんの負けです！");
		}
	}
	
	/**
	 * ゲームに参加するプレイヤーを登録
	 * 
	 * @param player
	 */
	public void registerPlayer(Player player) {
		players.add(player);
	}
}
