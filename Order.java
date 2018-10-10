 

/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Order
{
    // instance variables - replace the example below with your own
    private Cart cart;
    private Date orderTime;
    private String orderCondition;
    private Payment payment;
    /**https://www.cnblogs.com/remember-forget/p/6098462.html datetime
     * Constructor for objects of class Order
     */
    public Order()
    {
        // initialise instance variables
        orderTime = new Date();
    }
    
    public Order(Cart cart,Date orderTime, String orderCondition,Payment payment)
    {
    	this.cart = cart;
    	this.orderTime = orderTime;
    	this.orderCondition = orderCondition;
    	this.payment = payment;
    }
    
    
    public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

    
    public void displayTime ()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
    }
    
    public Date getTime()
    {
        return orderTime;
    }
    
    public void setOrderCondition(String orderCon)
    {
        orderCondition = orderCon;
    }
    
    public String getOrderCondition()
    {
        return orderCondition;
    }

    
    public Payment getPayment()
    {
        return payment;
    }
    

}
