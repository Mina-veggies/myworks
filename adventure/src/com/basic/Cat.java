package com.basic;

import java.util.ArrayList;
import java.util.Random;

//ver 1.0
public class Cat implements Creature {
	int hp;
	String name = null;
	
	ArrayList<String> item = new ArrayList<String>();
	
	public void run() {
		System.out.println("ネコチャン:" + name + "は逃げ出した\n");
	}
	
	public void catPunch(Fish f) {
		System.out.println("魚が出てきた！\n");
		System.out.println("ネコチャン:" + name + "のネコパンチ！\n");
		int rn = new Random().nextInt(5) + 1;
		
		System.out.println(rn + "のダメージ！\n");
		
		f.hp -= rn;
		f.setHp(f.hp);
		if(f.getHp() <= 0) {
			System.out.println("ネコチャンは魚をゲットした！\n");
			item.add("魚");
		}else {
			f.run();
			System.out.println("魚を手に入れられなかった……\n");
			System.out.println("そしてネコチャンは新たな冒険に出た……\n");
		}
	}
	
	public void bite(ToyBird tb) {
		System.out.println("鳥のおもちゃが出てきた！\n");
		System.out.println("ネコチャンは噛み付いた！\n");
		System.out.println("10のダメージ！\n");
		System.out.println("鳥のおもちゃは元気に跳ねている！\n");
		System.out.println("10のダメージ！\n");
		System.out.println("鳥のおもちゃを倒した！\n");
		System.out.println("ネコチャンは鶏肉(偽)を手に入れた！\n");
		
		item.add("鶏肉(偽)");
	}
	
	public void result() {
		System.out.println("ネコチャンが手に入れたのは……");
		for(String food :item) {
		System.out.println(food);
		}
		System.out.println("でした！");
	}
	
	public void fight() {
		System.out.println();
	}
	
	public Cat(String name) {
		this.hp = 50;
		this.name = name;
	}
}
