package trump;

import java.util.ArrayList;

public class Hand {
	
//	手札を保持するリスト
	private ArrayList hand = new ArrayList();
	
	/**
	 * カードを追加
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
//		カードをリストの最後に追加
		hand.add(card);
	}
	
	/**
	 * カードを見る
	 * 
	 * @param position カードの位置
	 * @return 
	 */
	public Card lookCard(int position) {
		Card lookingCard = null;
		
		if((0 <= position) && (position < hand.size())) {
			lookingCard = (Card)hand.get(position);
		}
		return lookingCard;
	}
	
	/**
	 * カードを引く
	 * 
	 * @param position
	 * @return
	 */
	public Card pickCard(int position) {
		Card pickedCard = null;
		
		if((0 <= position) && (position < hand.size())) {
			pickedCard = (Card)hand.remove(position);
		}
		return pickedCard;
	}
	
	/**
	 * シャッフル
	 */
	public void shuffle() {
		int number = hand.size();
		
		//	カードを抜き出す位置
		int pos;
		
		for(int count = 0; count < number * 2; count++) {
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card)hand.remove(pos);
			
			hand.add(pickedCard);
		}
	}
	
	/**
	 * 枚数を数える
	 * 
	 * @return
	 */
	public int getNumberOfCards() {
		return hand.size();
	}
	
	/**
	 * 手札にあるカードを文字列で表示
	 * 
	 * @return
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		int size = hand.size();
		if(size > 0) {
			for(int index = 0; index < size; index++) {
				Card card = (Card)hand.get(index);
				string.append(card);
				string.append(" ");
			}
		}
		return string.toString();
	}
}
