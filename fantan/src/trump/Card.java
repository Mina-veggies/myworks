package trump;

public class Card {

	public static final int SUIT_SPADE = 1;
	
	public static final int SUIT_DIAMOND = 2;
	
	public static final int SUIT_CLUB = 3;
	
	public static final int SUIT_HEART = 4;
	
	public static final int SUIT_NUM = 4;
	
	public static final int CARD_NUM = 13;
	
	protected int suit;
	
	protected int number;
	
	/**
	 * 
	 * @param suit
	 * @param number
	 */
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}
	
	/**
	 * 数を見る
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * スートを見る
	 * 
	 * @return
	 */
	public int getSuit() {
		return suit;
	}
	
	/**
	 * カードを文字列で表現
	 * 
	 * @return カードの文字表現
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		
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
		
		return string.toString();
	}
}
