public class MenuItem {
	private String name;
    private String description;
	private float price;
	// Both of the below can be toggled on or off to prevent them being returned inappropriately.
	private boolean onMenu; // Is this item currently being served?
	private boolean currentSpecial; // Is this item a special?
	
	// Constructor
	public MenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial){
		this.name = name;
		this.description = description;
		this.price = price;
		this.onMenu = onMenu;
		this.currentSpecial = currentSpecial;
	}
	
	// Getters & Setters
	public String getName(){
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
	
	public float getPrice(){
		return this.price;
	}
	
	public void setPrice(float newPrice){
		this.price = newPrice;
	}
	
	public boolean isOnMenu(){
		return this.onMenu;
	}
	
	public void setOnMenu(boolean onMenu){
		this.onMenu = onMenu;
	}
	
	public boolean isSpecial(){
		return this.currentSpecial;
	}
	
	public void setSpecial(boolean special){
		this.currentSpecial = special;
	}
}
