package backend;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;

/**
 * A menu class that aggrigates menuItems and provides functionality for ordering food / drink.
 * @author Oliver Jackson, Jo Butler
 * @version 2
 */

public class Menu implements Serializable {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

	/**
	 * Constructor
	 */
	public Menu(){

	}

	public ArrayList<MenuItem> getAllItems(){
		return menuItems;
	}

	/**
	 *  Returns only those items that are currently being served (onMenu is true) - JB
	 * 	This also returns current specials (all items that are onMenu)
	 * @return Returns the current items
	 */
	public ArrayList<MenuItem> getCurrentItems(){
		ArrayList<MenuItem> currentItems = new ArrayList<MenuItem>();
		for(MenuItem item : menuItems){
			if(item.isOnMenu()){
				currentItems.add(item);
			}
		}
		return currentItems;
	}

	/**
	 * Returns only those items that are currently being served, and are not specials
	 * @return non specials  currents
	 */
	public ArrayList<MenuItem> getCurrentNonSpecials(){
		ArrayList <MenuItem> currentNonSpecs = getCurrentItems();
		for(MenuItem item : currentNonSpecs){
			if(!(item.isSpecial())){
				currentNonSpecs.add(item);
			}
		}
		return currentNonSpecs;
	}

	/**
	 * Returns only those items that are currently being served, and are specials.
	 * @return Returns the current specials
	 */
	public ArrayList<MenuItem> getCurrentSpecials(){
		ArrayList <MenuItem> currentSpecs = getCurrentItems();
		for(MenuItem item : currentSpecs){
			if(item.isSpecial()){
				currentSpecs.add(item);
			}
		}
		return currentSpecs;
	}

	/**
	 *Prints all menuItems
	 */
	public void printMenuItems(){
		for(MenuItem item : menuItems){
			System.out.println(item);
		}
	}

	/**
	 * returns string of all menuitems - useful for testing
	 * @return Returns menu items
	 */
	public String returnMenuItems(){
		String listMenuItems = "";
		for(MenuItem item : menuItems){
			listMenuItems = listMenuItems + item.getName();
		}
		return listMenuItems;
	}

	/**
	 *  Method to add a new item to menu
	 * @param newItem Adding new item to menu
	 */
	public void addItem(MenuItem newItem){
		menuItems.add(newItem);
	}

	/**
	 * Creates a menuItem object and adds to arrayList of menu items
	 * @param name  Name of Menu Item
	 * @param description Description of menu Items
	 * @param price Price of Items
	 * @param onMenu on the menu
	 * @param isSpecial Specials on Menu
	 * @param menuItemType Type of Menu
	 */
	public void createAndAddMenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial, MenuItemType menuItemType){
		MenuItem newItem = new MenuItem(name, description, price, onMenu, isSpecial, menuItemType);
		addItem(newItem);
	}

	/**
	 * 	Any method using this must handle a potential null return
	 * 	IF EVER CONFLICT RESOLVING THIS IN GIT, use .equals() and not == . With ==, stuff breaks after save/load
	 * @param desiredMenuItemName Desired items on the menu
	 * @return Returns menu items by name or returns null if no matching item exists
	 */
	public MenuItem returnMenuItemByName (String desiredMenuItemName){
		for (MenuItem menuItem : menuItems){
			if (menuItem.getName().toLowerCase().equals(desiredMenuItemName.toLowerCase())){
				return menuItem;
			}
		}
		return null;
	}

	/**
	 * Method to return all menuItems by type
	 * 	Takes two arguments: a menuItem ArrayList and a MenuItemType enum
	 * 	Use above methods to generate ArrayList e.g. getCurrentItems()
	 * @param menuItems Items on the Menu
	 * @param menuItemType Item types on the Menu
	 * @return Returns item types of menu
	 */
	public ArrayList<MenuItem> returnMenuItemsByType(ArrayList<MenuItem> menuItems, MenuItemType menuItemType){
		ArrayList<MenuItem> menuItemsOfType = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItems){
			if (menuItem.getMenuItemType() == menuItemType) {
				menuItemsOfType.add(menuItem);
			}
		}
		return menuItemsOfType;
	}

	/**
	 * Method to calculate price of an order from names of menuItems
	 * 	taking ArrayList<String> as an argument
	 * @param stringList menuItems
	 * @return Returns the calcuated sum of items
	 */
	public float calculatePriceOfItemNames(ArrayList<String> stringList){
		float sum = 0f;
		for (String item : stringList){
			MenuItem menuItem = returnMenuItemByName(item);
			sum += menuItem.getPrice();
		}
		return sum;
	}

	/**
	 * Method to set menu item as special or not (true = special)
	 * @param menuItemName Name of Item on Menu
	 * @param isSpecial Specials on the Menu
	 */
	public void setMenuItemSpecialOrNot(String menuItemName, boolean isSpecial){
		MenuItem menuItem = returnMenuItemByName(menuItemName);
		if (menuItem == null){
			System.out.println("Menu item not found.");
		} else {
			menuItem.setSpecial(isSpecial);
		}
	}

	/**
	 * Method to set menu item as on or off (true = on)
	 * @param menuItemName Name of Item on Menu
	 * @param isOn if item is on menu
	 */
	public void setMenuItemIsOnOrOff(String menuItemName, boolean isOn){
		MenuItem menuItem = returnMenuItemByName(menuItemName);
		if (menuItem == null){
			System.out.println("Menu item not found.");
		} else {
			menuItem.setOnMenu(isOn);
		}
	}


	/**
	 * This method populates the menu
	 */
	public void populateMenu(){
		createAndAddMenuItem("Cheese burger", "150g Beef patty with cheddar cheese on a brioche bun", 12.5f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Ham and cheese toastie", "locally sourced ham with cheddar, as a toastie", 8.0f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Mushroom soup", "Mushrooms in a soup served with fresh baguette", 8.0f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("American hot pizza", "The classic, cooked in our new pizza oven", 12.0f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Pan fried sea bass", "Catch of the day", 15.0f, true, true, MenuItemType.FOOD);
		createAndAddMenuItem("Pasta Carbonara", "An italian classic", 12.5f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Heineken beer", "One pint 5%", 4.0f, true, false, MenuItemType.DRINK);
		createAndAddMenuItem("Rioja red wine", "175ml glass 13%", 4.0f, true, false, MenuItemType.DRINK);
		createAndAddMenuItem("Flat white coffee", "Two shots of espresso and hot frothy milk", 3.5f,true, false, MenuItemType.COFFEE);
		createAndAddMenuItem("Filter coffee", "Filtered coffee", 3.5f,true, false, MenuItemType.COFFEE);
	}


	/**
	 * methods to place orders (creates order with constructor and sends it to restaraunt arraylist of orders)
	 * 	takes orderNotes argument, if no notes enter empty string
	 * @param restaurant The restaurant place to eat
	 * @param customer The customer id
	 * @param orderNotes The notes on the order
	 * @param table The table of the restaurant
	 * @param orderedMenuItems The ordered items on the menu
	 */
	public void placeEatInOrder(Restaurant restaurant, Customer customer, String orderNotes, Table table, ArrayList<MenuItem> orderedMenuItems){
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		EatIn eatinOrder = new EatIn(table, restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems);
		restaurant.addOrder(eatinOrder);
	}

	/**
	 * Method to place takeaway order
	 * @param restaurant  The restaurant
	 * @param customer The customer id
	 * @param orderNotes The notes on the order
	 * @param pickUpTime The pickup time for delivery
	 * @param orderedMenuItems The ordered items on the menu
	 */
	public void placeTakeawayOrder(Restaurant restaurant, Customer customer, String orderNotes, String pickUpTime, ArrayList<MenuItem> orderedMenuItems){
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		Takeaway takeawayOrder = new Takeaway(restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems, pickUpTime);
		restaurant.addOrder(takeawayOrder);
	}

	public void placeDeliveryOrder(Restaurant restaurant, Customer customer, String orderNotes, String deliveryAddress, ArrayList<MenuItem> orderedMenuItems){
		restaurant.setOrderCounter(restaurant.getOrderCounter() + 1);
		Delivery deliveryOrder = new Delivery(restaurant.getOrderCounter(), customer, orderNotes, orderedMenuItems, deliveryAddress);
		restaurant.addOrder(deliveryOrder);
	}


}