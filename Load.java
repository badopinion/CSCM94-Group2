import java.io.*;

import java.util.ArrayList;

//Save Class written by SR
public class Load {

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
