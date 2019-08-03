package fantan;

import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

public class Fantan {

	public static void main(String[] args) {
		
		Master master = new FantanMaster();
		
		Table table = new FantanTable();
		
		Rule rule = new FantanRule();
		
		Player cat = new FantanPlayer("ネコ", master, table, rule);
		Player dog = new FantanPlayer("イヌ", master, table, rule);
		Player fox = new FantanPlayer("キツネ", master, table, rule);
		
		master.registerPlayer(cat);
		master.registerPlayer(dog);
		master.registerPlayer(fox);
		
		Hand trump = createTrump();
		
		master.prepareGame(trump);
		
		master.startGame();
	}
	
	private static Hand createTrump() {
		Hand trump = new Hand();
		
		for(int number = 1; number <= Card.CARD_NUM; number++) {
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		return trump;
	}

}
