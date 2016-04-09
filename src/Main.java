import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final String CUSTOMER_TEXT_FILE = "customer.txt";
	
	public static void main(String[] args) {
		//testMyStack();
		//testBurger(); 
		readCustomerTextFile();
	}
	
	public static void parseLine(String line) {
		String[] lineArray = line.split(" ");
		
		int pattyCount = 1;
		String pattyType = "Beef";
		List<String> omissions = new ArrayList<String>();
		List<String> additions = new ArrayList<String>();
		
		if (line.contains("Baron ")) {  // space so it doesn't mistake Baron for Baron-Sauce
			
			//determine patty count
			if (line.contains("Double")) {
				pattyCount = 2;
			} else if (line.contains("Triple")) {
				pattyCount = 3;
			}
			
			//determine patty type
			for (int i = 0; i < lineArray.length; i++) {
				String item = lineArray[i];
				
				if (item.equals("Chicken")) {
					pattyType = "Chicken";
				} else if (item.equals("Veggie")) {
					pattyType = "Veggie";
				}
			}
			
			
			if (line.contains("with")) {
				
				if (line.contains("no")) {	
					//determine omissions
					for (int i = Arrays.asList(lineArray).indexOf("no") + 1; i < lineArray.length; i++) {
						String item = lineArray[i];
						
						if (item.equals("but")) {
							break;
						}
						
						omissions.add(item);
					}
				}
				
				if (line.contains("but")) {
					//determine additions
					for (int i = Arrays.asList(lineArray).indexOf("but") + 1; i < lineArray.length; i++) {
						String item = lineArray[i];
						additions.add(item);
					}
				}
			}
			
			Burger baronBurger = new Burger(false);
			
			if (pattyCount == 2) {
				baronBurger.addPatty();
			} else if (pattyCount == 3) {
				baronBurger.addPatty();
			}
			
			if (pattyType.equals("Chicken")) {
				baronBurger.changePatties("Chicken");
			} else if(pattyType.equals("Veggie")) {
				baronBurger.changePatties("Veggie");
			}
			
			for (int i = 0; i < omissions.size(); i++) {
				
				if (omissions.get(i).equals("Cheese")) {
					baronBurger.removeCategory("Cheese");
				} else if (omissions.get(i).equals("Sauce")) {
					baronBurger.removeCategory("Sauce");
				} else if (omissions.get(i).equals("Veggies")) {
					baronBurger.removeCategory("Veggies");
				} else {
					baronBurger.removeIngredient(omissions.get(i));
				}	
			}
			
			for (int i = 0; i < additions.size(); i++) {
				
				if (additions.get(i).equals("Cheese")) {
					baronBurger.addCategory("Cheese");
				} else if (additions.get(i).equals("Sauce")) {
					baronBurger.addCategory("Sauce");
				} else if (additions.get(i).equals("Veggies")) {
					baronBurger.addCategory("Veggies");
				} else {
					baronBurger.addIngredient(additions.get(i));
				}		
			}
			
			System.out.println(baronBurger);
			
		} else {
			
			//determine patty count
			if (line.contains("Double")) {
				pattyCount = 2;
			} else if (line.contains("Triple")) {
				pattyCount = 3;
			}
			
			//determine patty type
			for (int i = 0; i < lineArray.length; i++) {
				String item = lineArray[i];
				
				if (item.equals("Chicken")) {
					pattyType = "Chicken";
				} else if (item.equals("Veggie")) {
					pattyType = "Veggie";
				}
			}
		}
	}
	
	private static void readCustomerTextFile() {
		Scanner inputFile;
		int orderNumber = 0;
		
		
		try {
			inputFile = new Scanner(new File(CUSTOMER_TEXT_FILE));
			
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				System.out.println("Processing Order " + orderNumber + ": " + line);
				parseLine(line);
				System.out.println();
				orderNumber++;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
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
		defaultBurger.addPatty();
		defaultBurger.addPatty();
		System.out.println(defaultBurger);
		System.out.println();
		
		System.out.println("Test addPatty() and changePatty() for baron burger");
		Burger baronBurger = new Burger(true);
		System.out.println(baronBurger);
		baronBurger.addPatty();
		baronBurger.addPatty();
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
		doubleBurgerWithCheese.addCategory("Cheese");
		System.out.println(doubleBurgerWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 3 patty beef burger");
		Burger trippleBurgerWithCheese = new Burger(false);
		System.out.println(trippleBurgerWithCheese);
		trippleBurgerWithCheese.addPatty();
		trippleBurgerWithCheese.addPatty();
		trippleBurgerWithCheese.addCategory("Cheese");
		System.out.println(trippleBurgerWithCheese);
		System.out.println();
		
		System.out.println("Test addCategory(Cheese) for 1 patty chicken burger");
		Burger singleChickenWithCheese = new Burger(false);
		System.out.println(singleChickenWithCheese);
		singleChickenWithCheese.changePatties("Chicken");
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
		
		System.out.println("Test addCategory(Veggies) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addCategory("Veggies");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce), addCategory(Veggies) for 1 patty beef burger");
		Burger singleBeefBurgerWithSauceAndVeggies = new Burger(false);
		System.out.println(singleBeefBurgerWithSauceAndVeggies);
		singleBeefBurgerWithSauceAndVeggies.addCategory("Sauce");
		System.out.println(singleBeefBurgerWithSauceAndVeggies);
		singleBeefBurgerWithSauceAndVeggies.addCategory("Veggies");
		System.out.println(singleBeefBurgerWithSauceAndVeggies);
		System.out.println();
		
		System.out.println("Test addCategory(Sauce), addCategory(Cheese), addCategory(Veggies) for 1 patty beef burger");
		Burger singleBeefWithSauceCheeseAndVeggies = new Burger(false);
		System.out.println(singleBeefWithSauceCheeseAndVeggies);
		singleBeefWithSauceCheeseAndVeggies.addCategory("Sauce");
		singleBeefWithSauceCheeseAndVeggies.addCategory("Cheese");
		singleBeefWithSauceCheeseAndVeggies.addCategory("Veggies");
		System.out.println(singleBeefWithSauceCheeseAndVeggies);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Veggies");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies), addCategory(Sauce) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Veggies");
		doubleBeefBurger.addCategory("Sauce");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies), addCategory(Sauce), addCategory(Cheese) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Veggies");
		doubleBeefBurger.addCategory("Sauce");
		doubleBeefBurger.addCategory("Cheese");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCateogry(Cheese), addCategory(Sauce), addCategory(Veggies) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addCategory("Cheese");
		doubleBeefBurger.addCategory("Sauce");
		doubleBeefBurger.addCategory("Veggies");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		tripBeefBurger.addCategory("Veggies");
		System.out.println(tripBeefBurger);
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies), addCategory(Cheese) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addCategory("Veggies");
		tripBeefBurger.addCategory("Cheese");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addCategory(Veggies), addCategory(Cheese), addCategory(Sauce) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addCategory("Veggies");
		tripBeefBurger.addCategory("Sauce");
		tripBeefBurger.addCategory("Cheese");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Cheese) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		singleBeefBurger.addCategory("Cheese");
		System.out.println(singleBeefBurger);
		singleBeefBurger.removeCategory("Cheese");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Cheese) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		doubleBeefBurger.addCategory("Cheese");
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.removeCategory("Cheese");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Cheese) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		tripBeefBurger.addCategory("Cheese");
		System.out.println(tripBeefBurger);
		tripBeefBurger.removeCategory("Cheese");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Sauce) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		singleBeefBurger.addCategory("Sauce");
		System.out.println(singleBeefBurger);
		singleBeefBurger.removeCategory("Sauce");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCateogry(Sauce) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		doubleBeefBurger.addCategory("Sauce");
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.removeCategory("Sauce");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Sauce) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		tripBeefBurger.addCategory("Sauce");
		System.out.println(tripBeefBurger);
		tripBeefBurger.removeCategory("Sauce");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Veggies) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		singleBeefBurger.addPatty();
		singleBeefBurger.addCategory("Veggies");
		System.out.println(singleBeefBurger);
		singleBeefBurger.removeCategory("Veggies");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Veggies) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		doubleBeefBurger.addCategory("Veggies");
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.removeCategory("Veggies");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeCategory(Veggies) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		tripBeefBurger.addCategory("Veggies");
		System.out.println(tripBeefBurger);
		tripBeefBurger.removeCategory("Veggies");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Ketchup) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		singleBeefBurger.addIngredient("Ketchup");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Ketchup) for 2 patty beef burger");
		doubleBeefBurger = new Burger(false);
		doubleBeefBurger.addPatty();
		System.out.println(doubleBeefBurger);
		doubleBeefBurger.addIngredient("Ketchup");
		System.out.println(doubleBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Ketchup) for 3 patty beef burger");
		tripBeefBurger = new Burger(false);
		tripBeefBurger.addPatty();
		tripBeefBurger.addPatty();
		System.out.println(tripBeefBurger);
		tripBeefBurger.addIngredient("Ketchup");
		System.out.println(tripBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Mustard) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addIngredient("Mustard");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Ketchup), addIngredient(Mustard), addIngredient(Mayonnaise), addIngredient(Baron-Sauce) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addIngredient("Ketchup");
		singleBeefBurger.addIngredient("Mustard");
		singleBeefBurger.addIngredient("Mayonnaise");
		singleBeefBurger.addIngredient("Baron-Sauce");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Pepperjack), addIngredient(Mozzarella), addIngredient(Cheddar) for 1 patty chicken burger");
		Burger singleChickenBurger = new Burger(false);
		singleChickenBurger.changePatties("Chicken");
		System.out.println(singleChickenBurger);
		singleChickenBurger.addIngredient("Pepperjack");
		singleChickenBurger.addIngredient("Mozzarella");
		singleChickenBurger.addIngredient("Cheddar");
		System.out.println(singleChickenBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Pepperjack), addIngredient(Cheddar), addIngredient(Mozzarella) for 2 patty chicken burger");
		Burger doubleChickenBurger = new Burger(false);
		doubleChickenBurger.changePatties("Chicken");
		doubleChickenBurger.addPatty();
		System.out.println(doubleChickenBurger);
		doubleChickenBurger.addIngredient("Pepperjack");
		doubleChickenBurger.addIngredient("Cheddar");
		doubleChickenBurger.addIngredient("Mozzarella");
		System.out.println(doubleChickenBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Pepperjack), addIngredient(Cheddar), addIngredient(Mozzarella) for 3 patty chicken burger");
		Burger tripChickenBurger = new Burger(false);
		tripChickenBurger.changePatties("Chicken");
		tripChickenBurger.addPatty();
		tripChickenBurger.addPatty();
		System.out.println(tripChickenBurger);
		tripChickenBurger.addIngredient("Pepperjack");
		tripChickenBurger.addIngredient("Cheddar");
		tripChickenBurger.addIngredient("Mozzarella");
		System.out.println(tripChickenBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Mushrooms), addIngredient(Lettuce), addIngredient(Tomato), addIngredient(Onions) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		System.out.println(singleBeefBurger);
		singleBeefBurger.addIngredient("Mushrooms");
		singleBeefBurger.addIngredient("Lettuce");
		singleBeefBurger.addIngredient("Tomato");
		singleBeefBurger.addIngredient("Onions");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(Mushrooms), addIngredient(Lettuce), addIngredient(Onions), addIngredient(Tomato), addIngredient(Pickle) for 2 patty veggie burger");
		Burger doubleVeggieBurger = new Burger(false);
		doubleVeggieBurger.addPatty();
		doubleVeggieBurger.changePatties("Veggie");
		System.out.println(doubleVeggieBurger);
		doubleVeggieBurger.addIngredient("Mushrooms");
		doubleVeggieBurger.addIngredient("Lettuce");
		doubleVeggieBurger.addIngredient("Onions");
		doubleVeggieBurger.addIngredient("Tomato");
		doubleVeggieBurger.addIngredient("Pickle");
		System.out.println(doubleVeggieBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(All ingredients) for 1 patty burger");
		baronBurger = new Burger(false);
		System.out.println(baronBurger);
		baronBurger.addIngredient("Pickle");
		baronBurger.addIngredient("Mayonnaise");
		baronBurger.addIngredient("Baron-Sauce");
		baronBurger.addIngredient("Lettuce");
		baronBurger.addIngredient("Tomato");
		baronBurger.addIngredient("Onions");
		baronBurger.addIngredient("Pepperjack");
		baronBurger.addIngredient("Mozzarella");
		baronBurger.addIngredient("Cheddar");
		baronBurger.addIngredient("Mushrooms");
		baronBurger.addIngredient("Mustard");
		baronBurger.addIngredient("Ketchup");
		System.out.println(baronBurger);
		System.out.println();
		
		System.out.println("Test addIngredient(All ingredients) for 2 patty beef burger)");
		Burger doubleBaronBurger = new Burger(false);
		doubleBaronBurger.addPatty();
		System.out.println(doubleBaronBurger);
		doubleBaronBurger.addIngredient("Pickle");
		doubleBaronBurger.addIngredient("Mayonnaise");
		doubleBaronBurger.addIngredient("Baron-Sauce");
		doubleBaronBurger.addIngredient("Lettuce");
		doubleBaronBurger.addIngredient("Tomato");
		doubleBaronBurger.addIngredient("Onions");
		doubleBaronBurger.addIngredient("Pepperjack");
		doubleBaronBurger.addIngredient("Mozzarella");
		doubleBaronBurger.addIngredient("Cheddar");
		doubleBaronBurger.addIngredient("Mushrooms");
		doubleBaronBurger.addIngredient("Mustard");
		doubleBaronBurger.addIngredient("Ketchup");
		System.out.println(doubleBaronBurger);
		System.out.println();
		
		System.out.println("Test removeIngredient(Cheddar) for 1 patty beef burger");
		singleBeefBurger = new Burger(false);
		singleBeefBurger.addIngredient("Cheddar");
		singleBeefBurger.addIngredient("Mozzarella");
		singleBeefBurger.addIngredient("Pepperjack");
		System.out.println(singleBeefBurger);
		singleBeefBurger.removeIngredient("Cheddar");
		System.out.println(singleBeefBurger);
		System.out.println();
		
		System.out.println("Test removeIngredient(Mayonnaise), removeIngredient(Pickle), removeIngredient(Mozarella), removeIngredient(Tomato) for 1 patty baron burger");
		Burger singleBaronBurger = new Burger(true);
		System.out.println(singleBaronBurger);
		singleBaronBurger.removeIngredient("Mayonnaise");
		singleBaronBurger.removeIngredient("Pickle");
		singleBaronBurger.removeIngredient("Mozzarella");
		singleBaronBurger.removeIngredient("Tomato");
		System.out.println(singleBaronBurger);
		System.out.println();
		
		System.out.println("Test removeIngredient(Cheddar), removeIngredient(Mushrooms) for 2 patty baron burger");
		doubleBaronBurger = new Burger(true);
		doubleBaronBurger.addPatty();
		System.out.println(doubleBaronBurger);
		doubleBaronBurger.removeIngredient("Cheddar");
		doubleBaronBurger.removeIngredient("Mushrooms");
		System.out.println(doubleBaronBurger);
		System.out.println();
	}
}
