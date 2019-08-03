package trump;

public interface Table {
	
	/**
	 * カードを置く
	 * 
	 * @param card
	 */
	public void putCard(Card[] card);
	
	/**
	 * カードを見る
	 * 
	 * @return
	 */
	public Card[][] getCards();
}
