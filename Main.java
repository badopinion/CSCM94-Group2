
public class Main{



    public static void main (String[] args){
        Table table1 = new Table(1, 6);
        System.out.println("Table number: " + table1.getTableNumber());

        Menu cafe94Menu = new Menu();

        cafe94Menu.populateMenu();
        cafe94Menu.printMenuItems(cafe94Menu.getCurrentItems());
    }
}