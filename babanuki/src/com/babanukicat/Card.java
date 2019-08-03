package com.babanukicat;

public class Card {
	
	public static final int JOKER = 0;
	
	public static final int SUIT_SPADE = 1;
	
	public static final int SUIT_DIAMOND = 2;
	
	public static final int SUIT_CLUB = 3;
	
	public static final int SUIT_HEART = 4;
	
	private int suit;
	
	private int number;
	
	
	/**
	 * コンストラクタ
	 * 
	 * @param suit
	 * @param number
	 */
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}
	

	/**
	 * 数字を見る
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	

	/**
	 * カードを文字列で表示
	 * ObjectクラスのtoStringメソッドをoverride
	 * 
	 * @return カード文字表現
	 */
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		
//	スートの表示
		if(number > 0) {
			switch(suit) {
				case SUIT_SPADE:
					string.append("S");
					break;
				
				case SUIT_DIAMOND:
					string.append("D");
					break;
					
				case SUIT_CLUB:
					string.append("C");
					break;
					
				case SUIT_HEART:
					string.append("H");
					break;
				
				default:
					break;
			}
//	数の表示
			switch(number) {
			case 1:
				string.append("A");
				break;
				
			case 10:
				string.append("T");
				break;
				
			case 11:
				string.append("J");
				break;
			
			case 12:
				string.append("Q");
				break;
				
			case 13:
				string.append("K");
				break;
				
			default:
				string.append(number);
				break;
			}
//	ジョーカー
		}else {
			string.append("JK");
		}
		return string.toString();
	}
}
