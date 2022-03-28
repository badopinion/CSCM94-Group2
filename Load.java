import java.io.*;

import java.util.ArrayList;
/**
 * Load class
 * @author Sam Raine
 * @version 1
 */
//Save Class written by SR
public class Load {
    //load customers from  customer txt (will add rest  once you guys approve it)
    public ArrayList<Customer> loadCustomerList() {
        ArrayList<Customer> customersList = new ArrayList<Customer>();
        try {
            FileInputStream fi = new FileInputStream(new File("customer.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            for (;;) {
                customersList.add((Customer) oi.readObject());
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }       catch (EOFException e) {
            // End of stream
        }
        catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return customersList;

    }

}
