
public class EatIn extends Order{
    private Table table;

    public EatIn(Table table, int orderID, Customer customer, String orderNotes){
        super(orderID, customer, orderNotes);
        this.table = table;
    }


}