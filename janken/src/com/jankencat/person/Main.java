package com.jankencat.person;

//写経　『なぜ、あなたはjavaでオブジェクト指向開発ができないのか』より

public class Main {

	public static void main(String[] args) {
		Judge cat = new Judge();
		
		Player crow = new Player("カラスさん");
		
		Tactics crowTactics = new AskTactics();
		crow.setTactics(crowTactics);
		
		Player swallow = new Player("ツバメさん");
		Tactics swallowTactics = new RandomTactics();
		swallow.setTactics(swallowTactics);
		
		cat.startJanken(crow, swallow);

	}

}
