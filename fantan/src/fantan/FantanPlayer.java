package fantan;

import trump.Card;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

public class FantanPlayer extends Player {

	private int pass;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 * @param rule
	 */
	public FantanPlayer(String name, Master master, Table table, Rule rule) {
		super(name, master, table, rule);
	}
	
	/**
	 * カードを配る
	 * 
	 * @param card
	 */
	public void receiveCard(Card card) {
		if(card.getNumber() == 7) {
			System.out.println(name + ":" + card + "を置きました。");
			table.putCard(new Card[] { card });
		}else {
			super.receiveCard(card);
		}
	}
	
	/**
	 * 順番を指名
	 * 
	 * @param nextPlayer
	 */
	public void play(Player nextPlayer) {
		System.out.println(" " + myHand);
		
		Card[] candidate = rule.findCandidate(myHand, table);
		
		if(candidate != null) {
			System.out.println(" " + candidate[0] + "を置きました。\n");
			table.putCard(candidate);
			
			System.out.println(table);
			
			if(myHand.getNumberOfCards() == 0) {
				master.declareWin(this);
			}
		}else {
			pass++;
			((FantanMaster)master).pass(this);
			
			if(pass > FantanMaster.PASS_LIMIT) {
				int numberOfHand = myHand.getNumberOfCards();
				for(int count = 0; count < numberOfHand; count++) {
					table.putCard(new Card[] { myHand.pickCard(0) });
				}
			}
		}
	}
	
	/**
	 * パス回数を数える
	 * 
	 * @return
	 */
	public int getPass() {
		return pass;
	}
}
