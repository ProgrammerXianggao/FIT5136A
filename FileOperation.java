 

import java.io.*;
import java.util.ArrayList;


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
	
	
}
