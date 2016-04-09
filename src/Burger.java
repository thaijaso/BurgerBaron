public class Burger {
	
	private MyStack<String> myBurger;
	
	private String myPatty;
	
	private int myPattyCount;
	
	private boolean myBurgerHasAllCheese;
	
	private boolean myBurgerHasAllSauces;
	
	private boolean myBurgerHasAllVeggies;
		
	public Burger(boolean theWorks) {
		myPattyCount = 1;
		myPatty = "Beef";
		
		myBurger = new MyStack<String>();
		myBurger.push("Bun");
		
		if (theWorks) {
			myBurger.push("Ketchup");
			myBurger.push("Mustard");
			myBurger.push("Mushrooms");
			myBurger.push(myPatty);
			myBurger.push("Cheddar");
			myBurger.push("Mozzarella");
			myBurger.push("Pepperjack");
			myBurger.push("Onions");
			myBurger.push("Tomato");
			myBurger.push("Lettuce");
			myBurger.push("Baron-Sauce");
			myBurger.push("Mayonnaise");
			myBurger.push("Bun");
			myBurger.push("Pickle");
			
			myBurgerHasAllCheese = true;
			myBurgerHasAllSauces = true;
			myBurgerHasAllVeggies = true;
		} else {
			myBurger.push(myPatty);
			myBurger.push("Bun");
			
			myBurgerHasAllCheese = false;
			myBurgerHasAllSauces = false;
			myBurgerHasAllVeggies = false;
		}
	}
	
	public void changePatties(String pattyType) {
		MyStack<String> temp = new MyStack<String>();
		myPatty = pattyType;
		
		while (!myBurger.isEmpty()) {
			String item = myBurger.pop();
			
			if (item.equals("Beef") || item.equals("Chicken") || item.equals("Veggie")) {
				item = myPatty;
			}
			
			temp.push(item);
		}
		
		while (!temp.isEmpty()) {
			String item = temp.pop();
			myBurger.push(item);
		}
	}
	
	public void addPatty() {
		myPattyCount++;
		MyStack<String> temp = new MyStack<String>();
		
		String item = myBurger.pop();
		
		if (myBurgerHasAllCheese) {
			//leave cheese on burger, add extra patty to temp to get cheese in between patties?
			while (!item.equals("Cheddar") && !item.equals("Mozzarella") && !item.equals("Pepperjack")) {
				temp.push(item);
				item = myBurger.pop();
			}
			
			temp.push(myPatty);
			temp.push(item);
		} else {
			while(!item.equals("Beef") && !item.equals("Chicken") && !item.equals("Veggie")) {
				temp.push(item);
				item = myBurger.pop();
			}
			
			temp.push(myPatty);
			temp.push(myPatty);
		}
		
		reStackBurger(myBurger, temp);
	}
	
	public void addCategory(String type) {
		MyStack<String> temp = new MyStack<String>();
		String item = myBurger.pop();
		
		if (type.equals("Cheese"))  {
			
			myBurgerHasAllCheese = true;
			
			while(!item.equals("Beef") && !item.equals("Chicken") && !item.equals("Veggie")) {
				temp.push(item);
				item = myBurger.pop();
			}
			
			if (myPattyCount == 3) {	
				temp.push(item);
				temp.push(myBurger.pop());	//add second patty to temp
			} else if (myPattyCount == 2) {					
				temp.push(item);					
			} else {						
				myBurger.push(item);
			}
			
			addCheeseToTempStack(temp);
			reStackBurger(myBurger, temp);
		
		} else if (type.equals("Sauce")) {
			
			myBurgerHasAllSauces = true;
			
			while (myBurger.size() != 1) {
				temp.push(item);
				
				if (item.equals("Bun")) {
					temp.push("Mayonnaise");
					temp.push("Baron-Sauce");
				}
				
				item = myBurger.pop();
			}
			
			temp.push(item);
			temp.push("Mustard");
			temp.push("Ketchup");
			
			reStackBurger(myBurger, temp);
			
		} else if (type.equals("Veggies")) {
			
			myBurgerHasAllVeggies = true;
			
			temp.push("Pickle");
			temp.push(item);		//take off bun and put in temp
			
			if (myBurgerHasAllSauces) {
				temp.push(myBurger.pop());		//Mayo
				temp.push(myBurger.pop());		//Baron-Sauce
			} 
				
			temp.push("Lettuce");
			temp.push("Tomato");
			temp.push("Onions");
			
			
			
			if (myPattyCount == 1) {
				
				if (myBurgerHasAllCheese) {
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
				}
				
				item = myBurger.pop();
				temp.push(item);
				temp.push("Mushrooms");
				
			} else if (myPattyCount == 2) {
				
				if (myBurgerHasAllCheese) {
					temp.push(myBurger.pop());		//patty
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
				}
					
				temp.push(myBurger.pop());			//patty
				temp.push(myBurger.pop());
				temp.push("Mushrooms");
			} else {
				
				if (myBurgerHasAllCheese) {
					temp.push(myBurger.pop());		//patty
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
					temp.push(myBurger.pop());
				}
				
				temp.push(myBurger.pop());
				temp.push(myBurger.pop());
				temp.push(myBurger.pop());
				temp.push("Mushrooms");
			}
			
			reStackBurger(myBurger, temp);
			
		}
	}
	
	private void reStackBurger(MyStack<String> theBurger, MyStack<String> theTemp) {
		while(!theTemp.isEmpty()) {
			String item = theTemp.pop();
			theBurger.push(item);
		}
	}
	
	private void addCheeseToTempStack(MyStack<String> theTemp) {
		theTemp.push("Pepperjack");
		theTemp.push("Mozzarella");
		theTemp.push("Cheddar");
	}
	
	public void removeCategory(String type) {
		MyStack<String> temp = new MyStack<String>();
		
		
		
		while (!myBurger.isEmpty()) {
			
			String item = myBurger.peek();
			
			if (type.equals("Cheese")) {
				
				myBurgerHasAllCheese = false;
				
				if (item.equals("Pepperjack") || item.equals("Mozzarella") || item.equals("Cheddar")) {
					myBurger.pop();
				} else {
					temp.push(myBurger.pop());
				}
				
			} else if (type.equals("Sauce")) {
				
				myBurgerHasAllSauces = false;
				
				if (item.equals("Mayonnaise") || item.equals("Baron-Sauce") 
						|| item.equals("Mustard") || item.equals("Ketchup")) {
					
					myBurger.pop();
				
				} else {
					temp.push(myBurger.pop());
				}
				
			} else if (type.equals("Veggies")) {
				
				myBurgerHasAllVeggies = false;
				
				if (item.equals("Pickle") || item.equals("Lettuce") || item.equals("Mushrooms")
						|| item.equals("Tomato") || item.equals("Onions")) {
					
					myBurger.pop();
					
				} else {
					temp.push(myBurger.pop());
				}
			}
		}
		
		reStackBurger(myBurger, temp);
		
	}
	
	public void addIngredient(String type) {
		
		String target = type;
		
		MyStack<String> baronRecipe = new MyStack<String>();
		baronRecipe.push("Bun");
		baronRecipe.push("Ketchup");
		baronRecipe.push("Mustard");
		baronRecipe.push("Mushrooms");
		baronRecipe.push(myPatty);
		baronRecipe.push("Cheddar");
		baronRecipe.push("Mozzarella");
		baronRecipe.push("Pepperjack");
		
		if (myPattyCount == 2) {
			baronRecipe.push(myPatty);
		} else if (myPattyCount == 3) {
			baronRecipe.push(myPatty);
			baronRecipe.push(myPatty);
		}
		
		baronRecipe.push("Onions");
		baronRecipe.push("Tomato");
		baronRecipe.push("Lettuce");
		baronRecipe.push("Baron-Sauce");
		baronRecipe.push("Mayonnaise");
		baronRecipe.push("Bun");
		baronRecipe.push("Pickle");
		
		MyStack<String> recipeStack = new MyStack<String>();	
		MyStack<String> temp = new MyStack<String>();
		
		String recipeItem = baronRecipe.peek();
		String burgerItem = myBurger.peek();
		
		while (!recipeItem.equals(target)) {
			
			if (recipeItem.equals(burgerItem)) {
				recipeStack.push(baronRecipe.pop());
				temp.push(myBurger.pop());
				recipeItem = baronRecipe.peek();
				burgerItem = myBurger.peek();	
			} else {
				recipeStack.push(baronRecipe.pop());
				recipeItem = baronRecipe.peek();
			}
		}
		
		temp.push(target);
		reStackBurger(myBurger, temp);
		
	}
	
	public void removeIngredient(String type) {
		MyStack<String> temp = new MyStack<String>();
		String target = type;
		String item = myBurger.peek();
		
		while(!item.equals(target)) {
			temp.push(myBurger.pop());
			item = myBurger.peek();
		}
		
		myBurger.pop();
		reStackBurger(myBurger, temp);	
	}
	
	@Override
	public String toString() {
		return myBurger.toString();
	}
}
