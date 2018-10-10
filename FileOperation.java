 

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class FileOperation {

	public static void createFile(String fileName)
	{
//		File file = new File("AccountInfo.txt");
		File file = new File(fileName);
		if(file.exists())
		{
//			file.delete();
//			try {
//				file.createNewFile();
//				System.out.println("The accout file is created");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("The file is already exist");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("The accout file is created");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void initialAccountFile()
	{
		File file = new File("./AccountInfo.txt");
		try {
			FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);
			bw.write("storeOwner,123456");
			bw.newLine();
			bw.flush();
			bw.close();
//			System.out.println("The AccountInfo is writen successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addAccountDetails(String userName,String userPassword,String emailAddress,int phoneNumber)
	{
		createFile("AccountDetails.txt");
		File file = new File("./AccountDetails.txt");
		try {
			FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);
			bw.write(userName+","+userPassword+","+emailAddress);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeProductFile(ArrayList<Product> productList)
	{
		File file = new File("./ProductInfo.txt");
		try {
			FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);
			for(Product product:productList)
			{
				String content = product.toString(); 
				bw.write(content);
				bw.newLine();				
			}
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeShelfFile(ArrayList<ProductShelf> productShelfs)
	{
		createFile("Shelf.txt");
		File file = new File("./Shelf.txt");
		try {
			FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);
			
			for(ProductShelf shelf:productShelfs)
			{
				String content = shelf.toString();
				bw.write(content);
				bw.newLine();
			}

			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void writeCusInfoFile(String content)
	{
		File file = new File("./CustomerAccount.txt");
		try {
			FileWriter out = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(out);
			
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveCusInfoFile(ArrayList<Customer> customers)
	{
		File file = new File("./CustomerAccount.txt");
		try {
			FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);
			for(Customer customer:customers)
			{
				bw.write(customer.toString());
				bw.newLine();
			}
				
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readProduct()
    {
    	String productItem;
    	PurchaseController.productList.clear();
    	
//    	int index = 0;
    	String[] productInfo = new String[7];
    	File file = new File("./ProductInfo.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((productItem = br.readLine()) != null)
			{
//				index += 1;
				productInfo = productItem.split(",");
				Product product = new Product(Integer.parseInt(productInfo[0]),productInfo[1],productInfo[2],Integer.parseInt(productInfo[3]),productInfo[4],productInfo[5],Double.parseDouble(productInfo[6]));
				PurchaseController.productList.add(product);
//				ProductShelf productShelf = new ProductShelf(product,new Date(),"available");
//				PurchaseController.productShelfs.add(productShelf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public static void readShelf()
	{
		PurchaseController.productShelfs.clear();
		String shelfInfo = "";
//		int index = 0;
    	String[] shelfInfoList = new String[9];
    	File file = new File("./Shelf.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((shelfInfo = br.readLine()) != null)
			{
//				index += 1;
				shelfInfoList = shelfInfo.split(",");
				Product product = new Product(Integer.parseInt(shelfInfoList[0]),shelfInfoList[1],shelfInfoList[2],Integer.parseInt(shelfInfoList[3]),shelfInfoList[4],shelfInfoList[5],Double.parseDouble(shelfInfoList[6]));
//				PurchaseController.productList.add(product);
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				Date date = df.parse(shelfInfoList[7]);
				ProductShelf productShelf = new ProductShelf(product,date,shelfInfoList[8],shelfInfoList[9]);
				PurchaseController.productShelfs.add(productShelf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
