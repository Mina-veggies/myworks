package fantan;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

public class FantanRule implements Rule {
	
	/**
	 * テーブルに置けるカードを探す
	 * 
	 * @param hand
	 * @param table
	 * @return 
	 */
	public Card[] findCandidate(Hand hand, Table table) {
		
		Card[] candidate = null;
		
		int numberOfHand = hand.getNumberOfCards();
		
//		1枚ずつ手札をチェックして、テーブルに置けるか調べる
		for(int position = 0; position < numberOfHand; position++) {
			
//		手札にあるカードを見る
			Card lookingCard = hand.lookCard(position);
			int number = lookingCard.getNumber();
			int suit = lookingCard.getSuit();
			
//		いま見ている手札の左か右にカードがあれば置ける
			int leftNumber = (number != 1) ? number -1 : Card.CARD_NUM;
			int rightNumber = (number != Card.CARD_NUM) ? number + 1 : 1;
			
			if((true == isThereCard(table, suit, leftNumber))
				|| (true == isThereCard(table, suit, rightNumber))) {
				
//		手札からカードを引いて候補
				candidate = new Card[1];
				candidate[0] = hand.pickCard(position);
				break;
			}
		}
		return candidate;
	}
	
	/**
	 * テーブルにカードが置かれているか調べる
	 * 
	 * @param table
	 * @param suit
	 * @param number
	 * @return
	 */
	private boolean isThereCard(Table table, int suit, int number) {
		Card[][] cards = table.getCards();
		if(cards[suit - 1][number - 1] != null) {
			return true;
		}else {
			return false;
		}
	}

}
