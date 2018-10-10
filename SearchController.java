 


public class SearchController {

//	private static UserInterface ui;
	private static PurchaseController pc;
	public static void  searchProduct(String keyword)
	{
		for(ProductShelf shelf : pc.productShelfs)
		{
			if(shelf.getProduct().getProductName().toLowerCase().contains(keyword.toLowerCase()))
			{
				shelf.displayShelfInfo();
			}
		}
	}
}
