
/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Cart
{
    // instance variables - replace the example below with your own
    private int x;
    private Customer customer;
    private ArrayList<Product> cartList;
    private float totalPrice;
    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void setCustomer()
    {
        
    }
    
    public Customer getCustomer()
    {
        return customer;
    
    }
    
    public void addCartList()
    {
        
    }
    
    public void setCartList()
    {
        
    }
    
    public void setTotalPrice(float totalprice)
    {
        totalPrice = totalprice;
    }
    
    public float getTotalPrice()
    {
        return totalPrice;
    }
}
