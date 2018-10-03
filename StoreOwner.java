
/**
 * Write a description of class StoreOwner here.
 *
 * @author (Team 41)
 * @version (3/10/2018)
 */
public class StoreOwner extends User
{
    // instance variables - replace the example below with your own
    private String emailAddress;
    private String phoneNumber;

    /**
     * Constructor for objects of class StoreOwner
     */
    public StoreOwner()
    {
        // initialise instance variables
        emailAddress = "email@example.com";
        phoneNumber = "012345678";
    }
    
    public StoreOwner(String email, String phone)
    {
        emailAddress = email;
        phoneNumber = phone;
    }
    
    public String getEmailAddress()
    {
        return emailAddress;
    }
    
    public void setEmailAddress(String email)
    {
        emailAddress = email;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phone)
    {
        phoneNumber = phone;
    }
}
