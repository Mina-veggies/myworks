package trump;

public interface Rule {
	
	/**
	 * テーブルに置けるカードを探す
	 * 
	 * @param hand
	 * @param table
	 * @return
	 */
	public Card[] findCandidate(Hand hand, Table table);
}
