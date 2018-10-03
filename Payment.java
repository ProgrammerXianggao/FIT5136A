
/**
 * Write a description of class Payment here.
 *
 * @author (Team 41)
 * @version (3/10/2018)
 */
public class Payment
{
    private String recipientName;
    private String emailAddress;
    private String phoneNumber;
    private String deliveryAddress;

    /**
     * Constructor for objects of class Payment
     */
    public Payment()
    {
        recipientName = "Recipient";
        emailAddress = "email@example.com";
        phoneNumber = "012345678";
        deliveryAddress = "Blank";
    }
    
    public Payment(String name, String email, String phone, String address)
    {
        recipientName = name;
        emailAddress = email;
        phoneNumber = phone;
        deliveryAddress = address;
    }

    public String getRecipentName()
    {
        return recipientName;
    }
    
    public void setRecipientName(String name)
    {
        recipientName = name;
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
    
    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }
    
    public void setDeliveryAddress(String address)
    {
        deliveryAddress = address;
    }
}
