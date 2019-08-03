package trump;

import java.util.ArrayList;

public class Master {
	
//	プレイヤーリスト
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * ゲームの準備をする
	 * 
	 * @param cards
	 */
	public void prepareGame(Hand cards) {
		System.out.println("【カードを配ります】");
		
		cards.shuffle();
		
		int numberOfCards = cards.getNumberOfCards();
		
		int numberOfPlayers = players.size();
		
		for(int index = 0; index < numberOfCards; index++) {
			Card card = cards.pickCard(0);
			
			Player player = (Player)players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}
	
	/**
	 * ゲームを開始する
	 */
	public void startGame() {
		System.out.println("\n【ゲームを開始します】");
		
		for(int count = 0; players.size() > 1; count++) {
			int playerIndex = count % players.size();
			int nextPlayerIndex = (count + 1) % players.size();
			
			Player player = (Player)players.get(playerIndex);
			
			Player nextPlayer = (Player)players.get(nextPlayerIndex);
			
			System.out.println("\n" + player + "さんの番です。");
			player.play(nextPlayer);
		}
		System.out.println("【ゲームを終了しました】");
	}
	
	/**
	 * 	上がりを宣言
	 * 
	 * @param winner
	 */
	public void declareWin(Player winner) {
		System.out.println(" " + winner + "さんが上がりました！");
		deregisterPlayer(winner);
	}
	
	/**
	 * 参加するプレイヤーを登録
	 * 
	 * @param player
	 */
	public void registerPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * 勝ったプレイヤーをリストから抜く
	 * 
	 * @param player
	 */
	public void deregisterPlayer(Player player) {
		players.remove(players.indexOf(player));
		
		if(players.size() == 1) {
			Player loser = (Player)players.get(0);
			System.out.println(" " + loser + "さんの負けです！");
		}
	}

}
