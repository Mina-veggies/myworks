package fantan;

import trump.Master;

public class FantanMaster extends Master {
	
//	パスできる回数
	public static final int PASS_LIMIT = 3;
	
	/**
	 * パスの宣言
	 * 
	 * @param player
	 */
	public void pass(FantanPlayer player) {
		System.out.println(" " + player + "さんは" + player.getPass() + "回目のパスしました！");
		
		if(player.getPass() > PASS_LIMIT) {
			System.out.println(" " + player + "さんは負けです！");
			deregisterPlayer(player);
		}
	}

}
