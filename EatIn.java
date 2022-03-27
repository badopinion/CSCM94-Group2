import java.util.ArrayList;

public class EatIn extends Order{
    private Table table;

    public EatIn(Table table, int orderID, Customer customer, String orderNotes, ArrayList<MenuItem> orderedItems){
        super(orderID, customer, orderNotes, orderedItems);
        this.table = table;
    }
}