package trump;

public class Joker extends Card {
	
	/**
	 * コンストラクタ
	 * 0を返す
	 */
	public Joker() {
		super(0, 0);
	}
	
	/**
	 * 数を変更
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * スートを変更
	 * 
	 * @param suit
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	/**
	 * カードを文字列で表現
	 */
	public String toString() {
		return "JK";
	}
	
}
