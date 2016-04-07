public class Burger {
	
	private MyStack<String> myBurger;
	
	private String myPatty;
	
	private int myPattyCount;
	
	private boolean myBurgerHasAllCheeses;
	
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
			myBurger.push("Baron Sauce");
			myBurger.push("Mayonnaise");
			myBurger.push("Bun");
			myBurger.push("Pickle");
			
			myBurgerHasAllCheeses = true;
			myBurgerHasAllSauces = true;
			myBurgerHasAllVeggies = true;
		} else {
			myBurger.push(myPatty);
			myBurger.push("Bun");
			
			myBurgerHasAllCheeses = false;
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
		
		if (myBurgerHasAllCheeses) {
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
			
			myBurgerHasAllCheeses = true;
			
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
					temp.push("Baron Sause");
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
		
	}
	
	public void addIngredient(String type) {
		
	}
	
	public void removeIngredient(String type) {
		
	}
	
	@Override
	public String toString() {
		return myBurger.toString();
	}
}
