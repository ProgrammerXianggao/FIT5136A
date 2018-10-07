 


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
    private static Customer customer;
    private ArrayList<Product> cartList;
    private float totalPrice;
    private ArrayList<Integer> numberList;

    public ArrayList<Integer> getNumberList() {
		return numberList;
	}



	public void setNumberList(ArrayList<Integer> numberList) {
		this.numberList = numberList;
	}



	public ArrayList<Product> getCartList() {
		return cartList;
	}



	public void setCartList(ArrayList<Product> cartList) {
		this.cartList = cartList;
	}



	public static void setCustomer(Customer customer) {
		Cart.customer = customer;
	}



	/**
     * Constructor for objects of class Cart
     */
    
    public Cart()
    {
    	
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
