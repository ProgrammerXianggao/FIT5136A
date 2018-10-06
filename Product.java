 

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

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSaleMethod() {
		return saleMethod;
	}

	public void setSaleMethod(String saleMethod) {
		this.saleMethod = saleMethod;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void displayProductInfo()
	{
		System.out.println(productID + productName + saleMethod + shelfLife + source + category + price);
	}
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
