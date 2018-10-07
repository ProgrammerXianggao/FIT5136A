 

import java.util.ArrayList;



public class PurchaseController {

	private static UserInterface ui;
    public static Cart addCartList(Cart cart,int productID,int productNumber,ArrayList<Product> productList)
    {
        for (Product product:productList)
        {
        	if (product.getProductID() == productID)
        	{
        		cart.getCartList().add(product);
        		cart.getNumberList().add(productNumber);
        	}
        }
        return cart;
    }
    
    public static void setCartList()
    {
        
    }
    
    
    
  
}
