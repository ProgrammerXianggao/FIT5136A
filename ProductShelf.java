 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProductShelf {

	private  Product product;
	private  Date shelfDate;
	private Date expiryDate;
	private String status;
	private String requirement;
	
    public ProductShelf() {
		
	}

    
	public ProductShelf(Product product, Date shelfDate, String status , String requirement) {
		this.product = product;
		this.shelfDate = shelfDate;
//		this.expiryDate = expiryDate;
		this.status = status;
		this.requirement = requirement;
	}


	public String calculateExpiryDate(int n)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
//	     SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     

	     //System.out.println(df.format(new Date(shelfDate.getTime() + n * 24 * 60 * 60 * 1000L))); 
	     //System.out.println(dd.format(new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L))); 
	      
	     return df.format(new Date(shelfDate.getTime() + n * 24 * 60 * 60 * 1000L));

	}
	
	
	
	public void displayShelfInfo()
	{
		System.out.println(product.info() + "   " + calculateExpiryDate(product.getShelfLife()) + "   " + status + "   " + requirement);
	}
	
	public String toString()
	{
		return product.toString() + "," + calculateExpiryDate(product.getShelfLife() ) + "," + status + "," + requirement;
	}
	

	
	public String getRequirement() {
		return requirement;
	}


	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getShelfDate() {
		return shelfDate;
	}
	public void setShelfDate(Date shelfDate) {
		this.shelfDate = shelfDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
