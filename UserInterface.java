 


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
    private ArrayList<String> accoutInfo;
    private ArrayList<Product> productList;
    /**
     * Constructor for objects of class UserInterface
     */
    
    public UserInterface()
    {
    	FileOperation.createFile("AccountInfo.txt");
    	FileOperation.initialAccountFile();
        // initialise instance variables
        user = new User();
        accoutInfo = new ArrayList<String>();
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
			loginInterface();
			break;
		case 2:
			Customer customer = new Customer();
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
    	File file = new File("./ProductInfo");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((productItem = br.readLine()) != null)
			{
				
				productInfo = productItem.split(",");
				Product product = new Product(Integer.parseInt(productInfo[0]),productInfo[1],productInfo[2],Integer.parseInt(productInfo[3]),productInfo[4],productInfo[5],Double.parseDouble(productInfo[6]));
//				Product product = new Product(1,"Apples-Golden-Delicious","Kg",50,"local","Fruit",3.5);
     			productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void displayProduct()
    {
    	for (Product product:productList)
    	{
    		product.displayProductInfo();
    	}
    }
    

}
