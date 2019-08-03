package com.babanukicat;

import java.util.ArrayList;

public class Hand {
	/**
	 * 手札のカードを保持するためのリスト
	 */
	private ArrayList hand = new ArrayList();
	
	/**
	 * カードを加える
	 * @param card
	 */
	public void addCard(Card card) {
		hand.add(card);
	}
	
	/**
	 * カードを引く
	 * @return
	 */
	public Card pickCard() {
		Card pickedCard = (Card) hand.remove(0);
		
		return pickedCard;
	}
	
	/**
	 * シャッフル
	 */
	public void shuffle() {
		int number = hand.size();
		
		int pos;
		
		for(int count = 0; count < number * 2; count++) {
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card) hand.remove(pos);
			
			hand.add(pickedCard);
		}
	}
	
	/**
	 * 枚数を数える
	 * @return
	 */
	public int getNumberOfCards() {
		return hand.size();
	}
	
	/**
	 * 同じ数のカードを探す
	 * @return
	 */
	public Card[] findSameNumberCard() {
		int numberOfCards = hand.size();
		Card[] sameCards = null;
		
		if(numberOfCards > 0) {
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand.get(lastIndex);
			
			int lastAddedCardNum = lastAddedCard.getNumber();
			
			for(int index = 0; index < lastIndex; index++) {
				Card card = (Card) hand.get(index);
				if(card.getNumber() == lastAddedCardNum) {
					sameCards = new Card[2];
					sameCards[0] = (Card) hand.remove(lastIndex);
					sameCards[1] = (Card) hand.remove(index);
					
					break;
				}
			}
		}
		return sameCards;
	}
	
	/**
	 * 手札のカードを文字列で表現
	 * @return
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		int size = hand.size();
		if(size > 0) {
			for(int index = 0; index < size; index++) {
				Card card = (Card) hand.get(index);
				string.append(card);
				string.append(" ");
			}
		}
		return string.toString();
	}
}
