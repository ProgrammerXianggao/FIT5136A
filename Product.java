 

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private int productID;
    private String productName;
    private String saleMethod;
    private int shelfLife;
    private String source;
    private String category;
    private double price;
//    private int quantity;
//    private Date expiryDate;
    
    /**
     * Constructor for objects of class Product
     */
    public Product()
    {

    }
    
    public Product(int productID,String productName,String saleMethod,int shelfLife,String source,String category,double price)
    {
    	this.productID = productID;
        this.productName = productName;
        this.saleMethod = saleMethod;
        this.shelfLife = shelfLife;
        this.source = source;
        this.category = category;
        this.price = price;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
