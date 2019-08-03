package com.babanukicat;

import java.util.ArrayList;

public class Table {
	/**
	 * 捨てられたカードを保持しておくリスト
	 */
	private ArrayList disposedCards = new ArrayList();
	
	/**
	 * カードを捨てる
	 * @param card
	 */
	public void disposedCard(Card card[]) {
		for(int index = 0; index < card.length; index++) {
			System.out.println(card[index] + " ");
		}
		System.out.println("を捨てました");
		
		disposedCards.add(card);
	}

}
