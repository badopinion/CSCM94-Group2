import java.util.ArrayList;
import java.util.Date;

/**
 * A menu class that aggrigates menuItems and provides functionality for ordering food / drink
 * @author Oliver Jackson
 * @version 1
 */

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

	//Prints all menuItems - OJ
	public void printMenuItems(){
		for(MenuItem item : menuItems){
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
	// any method using this must handle a potential null return
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

	//TODO - method to place order (creates order with constructor and sends it to restaraunt arraylist of orders
	//and sends it to customer order history)
	//this method uses varags to accept any number of order items beyond the 1st one
	//takes orderNotes argument, if no notes enter empty string

	public void placeEatInOrder(Restaurant restaurant, Customer customer, String orderNotes, Table table, MenuItem menuItem1, MenuItem... menuItems){
		ArrayList<MenuItem> orderedMenuItems = new ArrayList<MenuItem>();
		orderedMenuItems.add(menuItem1);
		for (MenuItem menuItem : menuItems){
			orderedMenuItems.add(menuItem);
		}
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		EatIn eatinOrder = new EatIn(table, restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems);
		restaurant.addOrder(eatinOrder);
	}

	//Method to place takeaway order - OJ
	public void placeTakeawayOrder(Restaurant restaurant, Customer customer, String orderNotes, String pickUpTime, MenuItem menuItem1, MenuItem... menuItems){
		ArrayList<MenuItem> orderedMenuItems = new ArrayList<MenuItem>();
		orderedMenuItems.add(menuItem1);
		for (MenuItem menuItem : menuItems){
			orderedMenuItems.add(menuItem);
		}
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		Takeaway takeawayOrder = new Takeaway(restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems, pickUpTime);
		restaurant.addOrder(takeawayOrder);
	}

	public void placeDeliveryOrder(Restaurant restaurant, Customer customer, String orderNotes, String deliveryAddress, MenuItem menuItem1, MenuItem... menuItems){
		ArrayList<MenuItem> orderedMenuItems = new ArrayList<MenuItem>();
		orderedMenuItems.add(menuItem1);
		for (MenuItem menuItem : menuItems){
			orderedMenuItems.add(menuItem);
		}
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		Delivery deliveryOrder = new Delivery(restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems, deliveryAddress);
		restaurant.addOrder(deliveryOrder);
	}

	//Method to create order (eatin/ takeaway / delivery)







}