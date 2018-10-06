 

import java.awt.event.ItemEvent;
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
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        // initialise instance variables
        user = new User();
        accoutInfo = new ArrayList<String>();
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
    		System.out.println("Please");
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
    	String AccountInfo = uName + uPassword;
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
    	
    }
    

}
