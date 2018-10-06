 

import java.util.Scanner;


public class ManageProductController {

	private static UserInterface ui;
	public ManageProductController()
	{
//		ui = new UserInterface();
	}
	public static void addProduct()
	{
		String productInfo;
		String[] productInfoList = new String[7];
		System.out.println("Please input product information");
		System.out.println("The format is id,productName,saleMethod,shelfLife,source,category,price");
		Scanner input = new Scanner(System.in);
		
		productInfo = input.nextLine();
		productInfoList = productInfo.split(",");
		Product product = new Product(Integer.parseInt(productInfoList[0]),productInfoList[1],productInfoList[2],Integer.parseInt(productInfoList[3]),productInfoList[4],productInfoList[5],Double.parseDouble(productInfoList[6]));
		ui.productList.add(product);
	}
	
	public static void deleteProduct()
	{
		
	}
	
	public static void editProduct()
	{
		
	}
}
