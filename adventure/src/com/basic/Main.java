package com.basic;

/**
 * 
 * @author Mina.H
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Cat cat = new Cat("すみお");
		Fish fish = new Fish();
		ToyBird toy = new ToyBird();
		
		System.out.println("ネコチャン大冒険　超短編\n");
		
		cat.catPunch(fish);

		cat.bite(toy);
		
		cat.result();
	}

}
