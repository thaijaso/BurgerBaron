
public class Main {
	public static void main(String[] args) {
		testMyStack();
		//testBurger(); 
	}
	
	public static void parseLine(String line) {
		
	}
	
	public static void testMyStack() {
		MyStack<Integer> intStack = new MyStack<Integer>();
		intStack.push(3);
		intStack.push(2);
		intStack.push(1);
		System.out.println(intStack);
		intStack.pop();
		intStack.pop();
		intStack.pop();
		System.out.println(intStack);
		
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
		
		System.out.println("Test addCategory(Cheese) for 2 patty chicken burger");
		Burger doubleChickenWithCheese = new Burger(false);
		doubleChickenWithCheese.changePatties("Chicken");
		doubleChickenWithCheese.addPatty();
		System.out.println(doubleChickenWithCheese);
		doubleChickenWithCheese.addCategory("Cheese");
		System.out.println(doubleChickenWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 3 patty chicken burger");
		Burger tripChickenWithCheese = new Burger(false);
		tripChickenWithCheese.changePatties("Chicken");
		tripChickenWithCheese.addPatty();
		tripChickenWithCheese.addPatty();
		System.out.println(tripChickenWithCheese);
		tripChickenWithCheese.addCategory("Cheese");
		System.out.println(tripChickenWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 1 patty veggie burger");
		Burger singleVeggieWithCheese = new Burger(false);
		singleVeggieWithCheese.changePatties("Veggie");
		System.out.println(singleVeggieWithCheese);
		singleVeggieWithCheese.addCategory("Cheese");
		System.out.println(singleVeggieWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 2 patty veggie burger");
		Burger doubleVeggieWithCheese = new Burger(false);
		doubleVeggieWithCheese.changePatties("Veggie");
		doubleVeggieWithCheese.addPatty();
		System.out.println(doubleVeggieWithCheese);
		doubleVeggieWithCheese.addCategory("Cheese");
		System.out.println(doubleVeggieWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 3 patty veggie burger");
		Burger tripVegBur = new Burger(false);
		tripVegBur.changePatties("Veggie");
		tripVegBur.addPatty();
		tripVegBur.addPatty();
		System.out.println(tripVegBur);
		tripVegBur.addCategory("Cheese");
		System.out.println(tripVegBur);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce) for 1 patty beef burger");
		Burger singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addCategory("Sauce");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese), addCategory(Sauce) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addCategory("Cheese");
		singleBeefBurger.addCategory("Sauce");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce), addCategory(Cheese) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addCategory("Sauce");
		singleBeefBurger.addCategory("Cheese");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce) to 2 patty beef burger");
		Burger doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Sauce");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce), addCategory(Cheese) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Sauce");
		doubleBeefBurger.addCategory("Cheese");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese), addCategory(Sauce) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Cheese");
		doubleBeefBurger.addCategory("Sauce");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce) for 3 patty beef burger");
		Burger tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addCategory("Sauce");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce), addCategory(Cheese) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addCategory("Sauce");
		tripBeefBurger.addCategory("Cheese");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese), addCategory(Sauce) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addCategory("Cheese");
		tripBeefBurger.addCategory("Sauce");
		System.out.println(tripBeefBurger);
		System.out.println();
		
	}
}
