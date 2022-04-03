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
	
	// Constructor
	public Menu(){
		
	}


	
	public ArrayList<MenuItem> getAllItems(){
		return menuItems;
	}
	
	// Returns only those items that are currently being served (onMenu is true) - JB
	// This also returns current specials (all items that are onMenu)
	public ArrayList<MenuItem> getCurrentItems(){
		ArrayList<MenuItem> currentItems = new ArrayList<MenuItem>();
		for(MenuItem item : menuItems){
			if(item.isOnMenu()){
				currentItems.add(item);
			}
		}
		return currentItems;
	}

	// Returns only those items that are currently being served, and are not specials - OJ
	public ArrayList<MenuItem> getCurrentNonSpecials(){
		ArrayList <MenuItem> currentNonSpecs = getCurrentItems();
		for(MenuItem item : currentNonSpecs){
			if(!(item.isSpecial())){
				currentNonSpecs.add(item);
			}
		}
		return currentNonSpecs;
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
    // returns string of all menuitems - useful for testing
	public String returnMenuItems(){
		String listMenuItems = "";
		for(MenuItem item : menuItems){
			listMenuItems = listMenuItems + item.getName();
		}
		return listMenuItems;
	}

	// Method to add a new item to menu - JB
	public void addItem(MenuItem newItem){
		menuItems.add(newItem);
	}

	//Creates a menuItem object and adds to arrayList of menu items - OJ
	public void createAndAddMenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial, MenuItemType menuItemType){
		MenuItem newItem = new MenuItem(name, description, price, onMenu, isSpecial, menuItemType);
		addItem(newItem);
	}

	//Method to return menuItem by name - returns null if no matching item exists - OJ
	//Any method using this must handle a potential null return
	//IF EVER CONFLICT RESOLVING THIS IN GIT, use .equals() and not == . With ==, stuff breaks after save/load - JB
	public MenuItem returnMenuItemByName (String desiredMenuItemName){
		for (MenuItem menuItem : menuItems){
			if (menuItem.getName().toLowerCase().equals(desiredMenuItemName.toLowerCase())){
				return menuItem;
			}
		}
		return null;
	}

	//Method to return all menuItems by type
	//Takes two arguments: a menuItem ArrayList and a MenuItemType enum
	//Use above methods to generate ArrayList e.g. getCurrentItems()
	//Returns an ArrayList
	//OJ
	public ArrayList<MenuItem> returnMenuItemsByType(ArrayList<MenuItem> menuItems, MenuItemType menuItemType){
		ArrayList<MenuItem> menuItemsOfType = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItems){
			if (menuItem.getMenuItemType() == menuItemType) {
				menuItemsOfType.add(menuItem);
			}
		}
		return menuItemsOfType;
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
		createAndAddMenuItem("Cheese burger", "150g Beef patty with cheddar cheese on a brioche bun", 12.5f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Ham and cheese toastie", "locally sourced ham with cheddar, as a toastie", 8.0f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Mushroom soup", "Mushrooms in a soup served with fresh baguette", 8.0f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("American hot pizza", "The classic, cooked in our new pizza oven", 12.0f, true, true, MenuItemType.FOOD);
		createAndAddMenuItem("Pasta Carbonara", "An italian classic", 12.5f, true, false, MenuItemType.FOOD);
		createAndAddMenuItem("Heineken beer", "One pint 5%", 4.0f, true, false, MenuItemType.DRINK);
		createAndAddMenuItem("Rioja red wine", "175ml glass 13%", 4.0f, true, false, MenuItemType.DRINK);
		createAndAddMenuItem("Flat white coffee", "Two shots of espresso and hot frothy milk", 3.5f,true, false, MenuItemType.COFFEE);
		createAndAddMenuItem("Filter coffee", "Filtered coffee", 3.5f,true, false, MenuItemType.COFFEE);
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






}