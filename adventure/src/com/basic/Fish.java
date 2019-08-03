package com.basic;

public class Fish implements Creature {
	int hp = 3;

	public void run() {
		System.out.println("魚は水へと逃げ込んだ！\n");
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
