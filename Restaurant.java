
public class Restaurant {
    public Restaurant() {
    }

    //This method populates the menu - OJ
    public void populateMenu(){
        Menu.createAndAddMenuItem("Cheese Burger", "150g Beef patty with cheddar cheese on a brioche bun", 12.50, true, false);
        Menu.createAndAddMenuItem("Ham and Cheese Toastie", "locally sourced ham with cheddar, as a toastie", 8.00, true, false);
        Menu.createAndAddMenuItem("Mushroom soup", "Mushrooms in a soup served with fresh baguette", 8.00, true, false);
        Menu.createAndAddMenuItem("American Hot Pizza", "The classic, cooked in our new pizza oven", 12.00, true, true);
    }

    public static void main(String[] args) {
        Table table1 = new Table(1, 6);
        System.out.println(table1.getTableNumber());

        populateMenu();
        Menu.printMenuItems(Menu.getCurrentItems());

    }
}