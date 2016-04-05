
public class Main {
	public static void main(String[] args) {
		testBurger(); 
	}
	
	public static void parseLine(String line) {
		
	}
	
	public static void testMyStack() {
		
	}
	
	public static void testBurger() {
		Burger defaultBurger = new Burger(false);
		System.out.println(defaultBurger);
		
		defaultBurger.changePatties("Chicken");
		System.out.println(defaultBurger);
		
		defaultBurger.addPatty();
		System.out.println(defaultBurger);
		
		defaultBurger.addPatty();
		System.out.println(defaultBurger);
		
		System.out.println();
		
		Burger baronBurger = new Burger(true);
		System.out.println(baronBurger);
		
		baronBurger.addPatty();
		System.out.println(baronBurger);
		
		baronBurger.addPatty();
		System.out.println(baronBurger);
		
		Burger burgerWithNoCheese = new Burger(false);
	}
}
