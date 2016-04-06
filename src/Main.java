
public class Main {
	public static void main(String[] args) {
		testBurger(); 
	}
	
	public static void parseLine(String line) {
		
	}
	
	public static void testMyStack() {
		
	}
	
	public static void testBurger() {
		System.out.println("Test changePatty() and addPatty() for regular burger");
		Burger defaultBurger = new Burger(false);
		System.out.println(defaultBurger);
		defaultBurger.changePatties("Chicken");
		System.out.println(defaultBurger);
		defaultBurger.addPatty();
		System.out.println(defaultBurger);
		defaultBurger.addPatty();
		System.out.println(defaultBurger);
		System.out.println();
		
		System.out.println("Test addPatty() and changePatty() for baron burger");
		Burger baronBurger = new Burger(true);
		System.out.println(baronBurger);
		baronBurger.addPatty();
		System.out.println(baronBurger);
		baronBurger.addPatty();
		System.out.println(baronBurger);
		baronBurger.changePatties("Chicken");
		System.out.println(baronBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 1 patty beef burger");
		Burger burgerWithCheese = new Burger(false);
		System.out.println(burgerWithCheese);
		burgerWithCheese.addCategory("Cheese");
		System.out.println(burgerWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 2 patty beef burger");
		Burger doubleBurgerWithCheese = new Burger(false);
		System.out.println(doubleBurgerWithCheese);
		doubleBurgerWithCheese.addPatty();
		System.out.println(doubleBurgerWithCheese);
		doubleBurgerWithCheese.addCategory("Cheese");
		System.out.println(doubleBurgerWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 3 patty beef burger");
		Burger trippleBurgerWithCheese = new Burger(false);
		System.out.println(trippleBurgerWithCheese);
		trippleBurgerWithCheese.addPatty();
		System.out.println(trippleBurgerWithCheese);
		trippleBurgerWithCheese.addPatty();
		System.out.println(trippleBurgerWithCheese);
		trippleBurgerWithCheese.addCategory("Cheese");
		System.out.println(trippleBurgerWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 1 patty chicken burger");
		Burger singleChickenWithCheese = new Burger(false);
		singleChickenWithCheese.changePatties("Chicken");
		System.out.println(singleChickenWithCheese);
		singleChickenWithCheese.addCategory("Cheese");
		System.out.println(singleChickenWithCheese);
		System.out.println();
		

	}
}
