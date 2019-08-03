package fantan;

import trump.Card;
import trump.Table;

public class FantanTable implements Table {
	
//	カードを並べるテーブルを表す二次元配列
	private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];
	
	/**
	 * カードを置く
	 * 
	 * @param card
	 */
	public void putCard(Card[] card) {
		int number = card[0].getNumber();
		int suit = card[0].getSuit();
		
		table_[suit - 1][number -1] = card[0];
	}
	
	/**
	 * カードを見る
	 * 
	 * @return
	 */
	public Card[][] getCards() {
		Card[][] table = new Card[Card.SUIT_NUM][Card.CARD_NUM];
		for(int suit = 0; suit < Card.SUIT_NUM; suit++) {
			System.arraycopy(table_[suit], 0, table[suit], 0, Card.CARD_NUM);
		}
		return table;
	}
	
	/**
	 * テーブルを文字列で表現
	 * 
	 * @return
	 */
	public String toString() {
		
		StringBuffer tableString = new StringBuffer(200);
		
		for(int suit = 0; suit < Card.SUIT_NUM; suit++) {
			for(int number = 0; number < Card.CARD_NUM; number++) {
				if(table_[suit][number] != null) {
					tableString.append(table_[suit][number]);
				}else {
					tableString.append("..");
				}
				tableString.append(" ");
			}
			tableString.append("\n");
		}
		return tableString.toString();
	}
	
}
