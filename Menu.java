import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	// Constructor
	public Menu(){
		
	}
	
	public ArrayList<MenuItem> getAllItems(){
		return menuItems;
	}
	
	// Returns only those items that are currently being served (onMenu is true) - JB
	public ArrayList<MenuItem> getCurrentItems(){
		ArrayList<MenuItem> currentItems = new ArrayList<MenuItem>();
		for(MenuItem item : menuItems){
			if(item.isOnMenu()){
				currentItems.add(item);
			}
		}
		return currentItems;
	}
	
	// Returns only those items that are currently being served, and are specials. - JB
	public ArrayList<MenuItem> getCurrentSpecials(){
		ArrayList <MenuItem> currentSpecs = getCurrentItems();
		for(MenuItem item : currentSpecs){
			if(item.isSpecial()){
				currentSpecs.add(item);
			}
		}
		return currentSpecs;
	}

	//Prints menuItems to console - input required is arrayList (returned by one of above methods) - OJ
	public void printMenuItems(ArrayList <MenuItem> items){
		for(MenuItem item : items){
			System.out.println(item);
		}
	}

	// Method to add a new item to menu - JB
	public void addItem(MenuItem newItem){
		menuItems.add(newItem);
	}

	//Creates a menuItem object and adds to arrayList of menu items - OJ
	public void createAndAddMenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial){
		MenuItem newItem = new MenuItem(name, description, price, onMenu, isSpecial);
		addItem(newItem);
	}

	//Method to return menuItem by name - returns null if no matching item exists - OJ
	//TODO - this method returns null if no match is found. is this a problem? if so how to solve it? - OJ
	public MenuItem returnMenuItemByName (String desiredMenuItemName){
		for (MenuItem menuItem : menuItems){
			if (menuItem.getName() == desiredMenuItemName){
				return menuItem;
			}
		}
		return null;
	}

	//Method to set menu item as special or not (true = special) - OJ
	public void setMenuItemSpecialOrNot(String menuItemName, boolean isSpecial){
		MenuItem menuItem = returnMenuItemByName(menuItemName);
		if (menuItem == null){
			System.out.println("Menu item not found.");
		} else {
			menuItem.setSpecial(isSpecial);
		}
	}

	//Method to set menu item as on or off (true = on) - OJ
	public void setMenuItemIsOnOrOff(String menuItemName, boolean isOn){
		MenuItem menuItem = returnMenuItemByName(menuItemName);
		if (menuItem == null){
			System.out.println("Menu item not found.");
		} else {
			menuItem.setOnMenu(isOn);
		}
	}


	//This method populates the menu - OJ
	public void populateMenu(){
		createAndAddMenuItem("Cheese Burger", "150g Beef patty with cheddar cheese on a brioche bun", 12.5f, true, false);
		createAndAddMenuItem("Ham and Cheese Toastie", "locally sourced ham with cheddar, as a toastie", 8.0f, true, false);
		createAndAddMenuItem("Mushroom soup", "Mushrooms in a soup served with fresh baguette", 8.0f, true, false);
		createAndAddMenuItem("American Hot Pizza", "The classic, cooked in our new pizza oven", 12.0f, true, true);
	}





}