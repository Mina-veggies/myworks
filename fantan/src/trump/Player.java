package trump;

public abstract class Player {

	protected String name;
	
	protected Table table;
	
	protected Hand myHand = new Hand();
	
	protected Master master;
	
	protected Rule rule;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 * @param rule
	 */
	public Player(String name, Master master, Table table, Rule rule) {
		this.name = name;
		this.master = master;
		this.table = table;
		this.rule = rule;
	}
	
	/**
	 * 順番を指名
	 * 
	 * @param nextPlayer
	 */
	public abstract void play(Player nextPlayer);
	
	/**
	 * カードを受け取る
	 * カード受け取り時の機能を拡張する場合
	 * このメソッドをオーバーライド
	 * 
	 * @param card
	 */
	public void receiveCard(Card card) {
		myHand.addCard(card);
	}
	
	/**
	 * プレイヤーの名前を返す
	 * 
	 * @return player's name
	 */
	public String toString() {
		return name;
	}
}
