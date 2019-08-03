package com.basic;

import java.util.Random;

public class ToyBird {
	int hp;
	
	public ToyBird() {
		int fHp = new Random().nextInt(35) + 10;
		this.hp = fHp;
	}
}
