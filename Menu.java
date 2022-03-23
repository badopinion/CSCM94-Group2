public class Menu {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	// Constructor
	public Menu(){
		
	}
	
	public ArrayList<MenuItem> getAllItems(){
		return menuItems;
	}
	
	// Returns only those items that are currently being served (onMenu is true)
	public ArrayList<MenuItem> getCurrentItems(){
		ArrayList<MenuItem> currentItems = new ArrayList<MenuItem>();
		for(MenuItem item : menuItems){
			if(item.isOnMenu()){
				currentItems.add(item);
			}
		}
		return currentItems;
	}
	
	// Returns only those items that are currently being served, and are specials.
	public ArrayList<MenuItem> getCurrentSpecials(){
		ArrayList <MenuItem> currentSpecs = getCurrentItems();
		for(MenuItem item : currentSpecs){
			if(item.isSpecial()){
				currentSpecs.add(item);
			}
		}
	}

	//Prints menuItems to console - input required is arrayList (returned by one of above methods) - OJ
	public void printMenuItems(ArrayList <MenuItem> items){
		for(MenuItem item : items){
			System.out.println(item);
		}
	}

	
	public void addItem(MenuItem newItem){
		menuItems.add(newItem);
	}

	//Creates a menuItem object and adds to arrayList of menu items - OJ
	public void createAndAddMenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial){
		menuItem newItem = new menuItem(name, description, price, onMenu, isSpecial);
		addItem(newItem);
	}

	// TODO: methods to set items on/off menu and as special or not special.
	// TODO: create some menu items and add them to array list


	//Method to create some basic menuitems and populate the menu



}