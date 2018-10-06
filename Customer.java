
/**
 * Write a description of class Customer here.
 *
 * @author (Team 41)
 * @version (3/10/2018)
 */
public class Customer extends User
{
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
	super(1, "defaultCustomer", "customerAuthority", "123456");
    }
	
    public Customer(int customerID, String customerName, String customerAuthority, String customerPassword)
    {
        super(customerID, customerName, customerAuthority, customerPassword);
    }
}

