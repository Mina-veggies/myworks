package com.cat.hongawara;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Player {
	public void choice() {
		String a = null;
		
		System.out.println("あなたの名前を入れてください。");
		String name = new java.util.Scanner(System.in).nextLine();
		
//		System.out.println("好きな番号をいれてください。");
//		int choiceNum = new java.util.Scanner(System.in).nextInt();
//		
//			if(choiceNum <= 0 || 5 < choiceNum) {
//			System.out.println("選択可能な数字を入力してください。");
//			}
			
			System.out.println("占いをはじめます……");
			
		int result = new java.util.Random().nextInt(5);

		switch(result){
			case 0:
				a = "大凶";
				break;
			
			case 1:
				a ="凶";
				break;
				
			case 2:
				a = "小吉";
				break;
			
			case 3:
				a = "中吉";
				break;
				
			case 4:
				a = "大吉";
				break;
		}
		
		System.out.println("今日の" + name + "さんの運勢は" + a +"です！");
	
	}
		
	}
	
	
//	public Player(String name) {
//		this.name = name;
//	}

