package com.cat;

public class Main {
	public static void main (String[] args) {
		System.out.println("私の名前は・・・");
		@SuppressWarnings("resource")
		String name = new java.util.Scanner(System.in).nextLine();
		System.out.println("私の名前は" + name + "です。");

	}

}
