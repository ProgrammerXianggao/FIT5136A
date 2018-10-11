 


public class SearchController {

//  private static UserInterface ui;
    private static PurchaseController pc;
    public static void  searchProduct(String keyword)
    {
        boolean isFalse = false;
        for(ProductShelf shelf : pc.productShelfs)
        {
            if(shelf.getProduct().getProductName().toLowerCase().contains(keyword.toLowerCase()))
            {
                shelf.displayShelfInfo();
                isFalse = true;
            }
            
        }
        if (isFalse == false)
        {
            System.out.println("Incorrect input");
        }
    }
}
