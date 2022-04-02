import java.io.*;

/**
 * A menuItem class (food and drink that can be ordered).
 * menuItems can be special or not, on or off service.
 * @author Oliver Jackson, Jo Butler
 * @version 1
 */

public class CafeMenuItem implements Serializable {
	private String name;
    private String description;
	private float price;
	// Both of the below can be toggled on or off to prevent them being returned inappropriately.
	private boolean onMenu; // Is this item currently being served?
	private boolean currentSpecial; // Is this item a special?
	private MenuItemType menuItemType;
	
	// Constructor
	public CafeMenuItem(String name, String description, float price, boolean onMenu, boolean isSpecial, MenuItemType menuItemType){
		this.name = name;
		this.description = description;
		this.price = price;
		this.onMenu = onMenu;
		this.currentSpecial = isSpecial;
		this.menuItemType = menuItemType;
	}
	
	// Getters &
	public String getName(){
		return this.name;
	}

	public String getDescription(){
		return this.description;
	}

	public float getPrice(){
		return this.price;
	}

	public boolean isOnMenu(){
		return this.onMenu;
	}

	public boolean isSpecial(){
		return this.currentSpecial;
	}

	public MenuItemType getMenuItemType() {
		return menuItemType;
	}

	//Setters

	public void setName(String newName){
		this.name = newName;
	}
	
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
	
	public void setPrice(float newPrice){
		this.price = newPrice;
	}
	
	public void setOnMenu(boolean onMenu){
		this.onMenu = onMenu;
	}
	
	public void setSpecial(boolean special){
		this.currentSpecial = special;
	}

	public void setMenuItemType(MenuItemType menuItemType) {
		this.menuItemType = menuItemType;
	}

	//toString Method - OJ

	public String toString(){
		return name + ", " + description + ", " + price + ", " + "on menu: " + onMenu + ", " + "is special: " + currentSpecial;
	}
}
