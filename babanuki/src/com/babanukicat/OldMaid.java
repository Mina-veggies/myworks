package com.babanukicat;

//写経

public class OldMaid {

	public static void main(String[] args) {
		Master master = new Master();
		
		Table field = new Table();
		
		Player crow = new Player("カラス", master, field);
		Player cat = new Player("ネコ", master, field);
		Player dog = new Player("イヌ", master, field);
		
		master.registerPlayer(crow);
		master.registerPlayer(cat);
		master.registerPlayer(dog);
		
		Hand trump = createTrump();
		
		master.prepareGame(trump);
		
		master.startGame();

	}
	
	/**
	 * 53枚のトランプを生成
	 * 
	 * @return
	 */
	private static Hand createTrump() {
		Hand trump = new Hand();
		
//		各スート13枚+ジョーカー作成
		for(int number = 1; number <= 13; number++) {
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		trump.addCard(new Card(0, Card.JOKER));
		return trump;
	}

}
