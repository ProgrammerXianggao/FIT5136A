 


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;

import java.util.ArrayList;


/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
	
    // instance variables - replace the example below with your own
    private User user;
    private StoreOwner storeOwner;
    private Customer customer;
    private ArrayList<String> accoutInfo;
    private String userStatus;
    public static ArrayList<Product> productList;
    /**
     * Constructor for objects of class UserInterface
     */
    
    public UserInterface()
    {
    	FileOperation.createFile("AccountInfo.txt");
//    	FileOperation.createFile("ProductInfo.txt");
    	FileOperation.initialAccountFile();
        // initialise instance variables
        accoutInfo = new ArrayList<String>();
        productList = new ArrayList<Product>();
    }
    public void main() {
    	initialInterface();
    	if(userStatus.equals("storeOwner")) 
    	{
    		menu();
        	for(Product product:productList)
        	{
        		product.displayProductInfo();
        	}
    	}
    	
    }
    
    public void initialInterface()
    {
        // put your code here
        boolean inputResonable = false;
        int option = 0;
        while (!inputResonable)
        {
            System.out.println("Welcome to MFVs!");
            System.out.println("Press 1 to login as store owner");
            System.out.println("Press 2 to purchase as a guest");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            if (option == 1 || option == 2)
            {
                inputResonable = true;
            }
            else {
            	System.out.println("You can only input 1 or 2!");
            }
        }
        switch (option) {
		case 1:
			userStatus = "storeOwner";
			loginInterface();
			break;
		case 2:
			userStatus = "customer";
			user = new User();
			Customer customer = new Customer();
			System.out.println(customer.getName());
//			Customer customer = new Customer(customerID, customerName, customerAuthority, customerPassword)
			break;
		default:
			break;
		}
    }
    
    public void loginInterface()
    {
    	String userName;
    	String passWord;
    	boolean flag = false;
    	Scanner input = new Scanner(System.in);
    	System.out.println("This is login page!");
    	while(!flag)
    	{
    		System.out.println("Please input your username:");
    		userName = input.nextLine();
    		System.out.println("Please input your password");
    		passWord = input.nextLine();
    		if(testLogin(userName,passWord))
    		{
    			flag = true;
    		}
    		else {
    			System.out.println("your account information is wrong!");
    		}
    	}
		showShelfInterface();
    }
    
    public boolean testLogin(String uName,String uPassword)
    {
    	String AccountInfo = uName +"," + uPassword;
    	String item;
    	boolean find = false;
    	File file = new File("./AccountInfo.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((item = br.readLine()) != null)
			{
				if (item.equals(AccountInfo))
				{
					find = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return find;
    }
    
    
    public void showShelfInterface()
    {
    	
    	readProduct();
    	displayProduct();
    }
    
    public void readProduct()
    {
    	String productItem;
    	String[] productInfo = new String[7];
    	File file = new File("./ProductInfo.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((productItem = br.readLine()) != null)
			{
				
				productInfo = productItem.split(",");
				Product product = new Product(Integer.parseInt(productInfo[0]),productInfo[1],productInfo[2],Integer.parseInt(productInfo[3]),productInfo[4],productInfo[5],Double.parseDouble(productInfo[6]));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void displayProduct()
    {
    	System.out.println("----------ProductList--------");
    	for (Product product:productList)
    	{
    		product.displayProductInfo();
    	}
    }
    
    public void menu()
    {
    	boolean exist = false;
    	while(!exist)
    	{
    		boolean valid = false;
        	while(!valid) {
        		System.out.println("Please input your options:");
            	System.out.println("Press 1 to add product");
            	System.out.println("Press 2 to delete product");
            	System.out.println("Press 3 to edit product");
            	System.out.println("Press 4 to log out");
            	Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option >= 1 && option <= 4)
                {
                    valid = true;
                }
                else {
                	System.out.println("You can only input 1 to 4!");
                }
            
        	    switch (option) {
        		case 1:
        			ManageProductController.addProduct();
        			break;
        		case 2:
        			ManageProductController.deleteProduct();
        			break;
        		case 3:
        			ManageProductController.editProduct();
        			break;
        		case 4:
        			
//        			AccountController.logOut();
        			AccountController.deleteAccount();
        			break;
        		case 5:
        			exist = true;
        			break;
        		default:
        			break;
        	    	
        	    }
        	}
    	}	
    }
}
