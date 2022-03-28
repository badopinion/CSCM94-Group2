import java.io.*;
import java.util.ArrayList;
/**
 * Save class
 * @author Sam Raine
 * @version 1
 */
//Save Class written by SR
public class Save {

    //Save customers to a customer txt (will add rest once you guys approve it)
    public void saveCustomers(ArrayList<Customer> customerList) {
        try {
            FileOutputStream f = new FileOutputStream("customer.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
                for(Customer customer : customerList){
                    o.writeObject(customer);
                    System.out.println("Save");
                }

            o.close();
            f.close();
            }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


}
