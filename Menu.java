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
		ArrayList<MenuItem> currentItems = new ArrayList<MenuItem>;
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
	
	public void addItem(MenuItem newItem){
		menuItems.add(newItem);
	}

	// TODO: methods to set items on/off menu and as special or not special.
}