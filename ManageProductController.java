 

import java.util.Date;
import java.util.Scanner;


public class ManageProductController {

//	private static UserInterface ui;
	private static PurchaseController pc;
	
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
		pc.productList.add(product);
		ProductShelf productShelf = new ProductShelf(product,new Date(),"available");
		pc.productShelfs.add(productShelf);
		FileOperation.writeProductFile(pc.productList);
		FileOperation.writeShelfFile(pc.productShelfs);
	}
	
	public static void deleteProduct()
	{
		System.out.println("Please input the number of product you want to delete");
		Scanner input = new Scanner(System.in);
		int productNumber = input.nextInt();
		for(int i = 0;i < pc.productList.size();i++)
		{
			if(pc.productList.get(i).getProductID() == productNumber)
			{
				pc.productList.remove(i);
				pc.productShelfs.remove(i);
			}
		}
		FileOperation.writeProductFile(pc.productList);
		FileOperation.writeShelfFile(pc.productShelfs);
	}
	
	public static void editProduct()
	{
		System.out.println("Please input the number of product you want to edit");
		Scanner input = new Scanner(System.in);
		int productNumber = input.nextInt() - 1;
		System.out.println("The selected product is : " + pc.productList.get(productNumber).getProductName());
		System.out.println("Choose what you want to edit");
		System.out.println("1:product name 2:saleMethod 3:shelfLife 4:source 5:category 6:price 7:status");
		Scanner input2 = new Scanner(System.in);
		int option = input2.nextInt();
		switch (option) {
		case 1:
			System.out.println("Please input new product name");
			Scanner input3 = new Scanner(System.in);
			String newProductName = input3.nextLine();
			pc.productList.get(productNumber).setProductName(newProductName);
			break;
		case 2:
			System.out.println("Please input new saleMethod");
			Scanner input4 = new Scanner(System.in);
			String newSaleMethod = input4.nextLine();
			pc.productList.get(productNumber).setSaleMethod(newSaleMethod);
			break;
		case 3:
			System.out.println("Please input new shelfLife");
			Scanner input5 = new Scanner(System.in);
			int newShelfLife = input5.nextInt();
			pc.productList.get(productNumber).setShelfLife(newShelfLife);
			break;
		case 4:
			System.out.println("Please input new source");
			Scanner input6 = new Scanner(System.in);
			String newSource = input6.nextLine();
			pc.productList.get(productNumber).setSource(newSource);
			break;
		case 5:
			System.out.println("Please input new category");
			Scanner input7 = new Scanner(System.in);
			String newCategory = input7.nextLine();
			pc.productList.get(productNumber).setCategory(newCategory);
			break;
		case 6:
			System.out.println("Please input new price");
			Scanner input8 = new Scanner(System.in);
			int newPrice = input8.nextInt();
			pc.productList.get(productNumber).setPrice(newPrice);
			break;
		case 7:
			if (pc.productShelfs.get(productNumber).equals("available"))
			{
				pc.productShelfs.get(productNumber).setStatus("out of stack");
			}
			else {
				pc.productShelfs.get(productNumber).setStatus("available");
			}
			System.out.println("Change status successful!");
			break;
		default:
			break;
		}
		System.out.println("Modification is success!");
		FileOperation.writeProductFile(pc.productList);
		FileOperation.writeShelfFile(pc.productShelfs);
//		ui.displayProduct();
//		ui.displayShelf();
	}
	
	
}
