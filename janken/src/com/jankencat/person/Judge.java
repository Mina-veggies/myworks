package com.jankencat.person;

public class Judge {
	
//	じゃんけん開始
	public void startJanken(Player player1, Player player2) {
		System.out.println("【じゃんけん開始】\n");
		
		for(int cnt = 0; cnt < 3; cnt++) {
			System.out.println("【"+ (cnt + 1) +"回戦目】");
			
			Player winner = judgeJanken(player1, player2);
			
			if(winner != null) {
				System.out.println(winner.getName() + "が勝ちました！\n");
				winner.notifyResult(true);
			}else {
				System.out.println("引き分けです！\n");
			}
		}
		
		System.out.println("【じゃんけん終了】\n");
		
		Player finalWinner = judgeFinalWinner(player1, player2);
		
		System.out.print(player1.getWinCount() + "対" + player2.getWinCount() + "で");
		
		if(finalWinner != null) {
			System.out.println(finalWinner.getName() + "の勝ちです！\n");
			finalWinner.notifyResult(true);
		}else {
			System.out.println("引き分けです！\n");
		}
	}
	
	
//	判定する
	private Player judgeJanken(Player player1, Player player2) {
		Player winner = null;
	
//	手をだす
		int player1hand = player1.showHand();
		int player2hand = player2.showHand();
		
//	それぞれの手
		printHand(player1hand);
		System.out.println(" vs. ");
		printHand(player2hand);
		System.out.println("\n");
		
//	プレイヤー1の勝利
		if((player1hand == Player.STONE && player2hand == Player.SCISSORS) 
			|| (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
			|| (player1hand == Player.PAPER && player2hand == Player.STONE)) {
			winner = player1;
			
//	プレイヤー2の勝利
		}else if((player1hand == Player.STONE && player2hand == Player.PAPER)
			||(player1hand == Player.SCISSORS && player2hand == Player.STONE)
			||(player1hand == Player.PAPER && player2hand == Player.SCISSORS)) {
			winner = player2;
	}
		return winner;
}
	
//	最終的な勝者
	private Player judgeFinalWinner(Player player1, Player player2) {
		Player winner = null;
		
		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();
		
		if(player1WinCount > player2WinCount) {
			winner = player1;
		}else if(player1WinCount < player2WinCount) {
			winner = player2;
		}
//	どちらでもなければnull(引き分け)
		return winner;
	}
	
//	じゃんけんの手を表示
	private void printHand(int hand) {
		
	switch(hand) {
		case Player.STONE:
			System.out.println("グー");
			break;
		
		case Player.SCISSORS:
			System.out.println("チョキ");
			break;
		
		case Player.PAPER:
			System.out.println("パー");
			break;
			
		default:
			break;
		}
	}
}
