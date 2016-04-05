public class Burger {
	
	private MyStack<String> myBurger;
	
	private String myPatty;
	
	private boolean myBurgerHasCheese;
		
	public Burger(boolean theWorks) {
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
			
			myBurgerHasCheese = true;
		} else {
			myBurger.push(myPatty);
			myBurger.push("Bun");
			
			myBurgerHasCheese = false;
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
		MyStack<String> temp = new MyStack<String>();
		
		String item = myBurger.pop();
		
		if (myBurgerHasCheese) {
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
		
		
		
		while(!temp.isEmpty()) {
			item = temp.pop();
			myBurger.push(item);
		}
	}
	
	public void addCategory(String type) {
		if (type.equals("Cheese")) {
			
		} else if (type.equals("Sauce")) {
			
		} else if (type.equals("Veggies")) {
			
		}
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
