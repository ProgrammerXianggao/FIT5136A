 


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
    private String cardNumber;
    private String cvvCode;
    private String validDateStart;
    private String validDateEnd;

    
    
    public Payment()
    {
        recipientName = "Recipient";
        emailAddress = "email@example.com";
        phoneNumber = "012345678";
        deliveryAddress = "Blank";
        cardNumber = "123456789876";
        cvvCode = "123";
        validDateStart = "11/17";
        validDateEnd = "11/20";
        
    }
    
    public Payment(String name, String email, String phone, String address,String number,String code,String start,String end)
    {
        recipientName = name;
        emailAddress = email;
        phoneNumber = phone;
        deliveryAddress = address;
        cardNumber = number;
        cvvCode = code;
        validDateStart = start;
        validDateEnd = end;
    }
    
    
    
    public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}



	public String getValidDateStart() {
		return validDateStart;
	}

	public void setValidDateStart(String validDateStart) {
		this.validDateStart = validDateStart;
	}

	public String getValidDateEnd() {
		return validDateEnd;
	}

	public void setValidDateEnd(String validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
     * Constructor for objects of class Payment
     */


    public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getRecipientName() {
		return recipientName;
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
