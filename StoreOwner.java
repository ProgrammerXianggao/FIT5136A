
/**
 * Write a description of class StoreOwner here.
 *
 * @author (Team 41)
 * @version (3/10/2018)
 */
public class StoreOwner extends User
{
    private String emailAddress;
    private String phoneNumber;

    /**
     * Constructor for objects of class StoreOwner
     */
    public StoreOwner(int ownerID, String ownerName, String ownerAuthority, String ownerPassword)
    {
        super(ownerID, ownerName, ownerAuthority, ownerPassword);
        emailAddress = "email@example.com";
        phoneNumber = "012345678";
    }
    
    public StoreOwner(int ownerID, String ownerName, String ownerAuthority, String ownerPassword, String email, String phone)
    {
        super(ownerID, ownerName, ownerAuthority, ownerPassword);
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
