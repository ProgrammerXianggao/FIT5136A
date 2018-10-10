 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class AccountController {

	public static ArrayList<String> accoutInfo;
	public static User user;
	public static Customer customer;
	public static ArrayList<Customer> customers;
	
	
	public AccountController()
	{
		user = new User();
		customer = new Customer();
		accoutInfo = new ArrayList<String>();
		customers = new ArrayList<Customer>(); 
	}
	
	public static void logOut() 
	{
		
	}
	
	public static void deleteAccount()
	{
		String cusAccountInfo;
    	int index = 0;
    	String[] cInfo = new String[4];
    	File file = new File("./CustomerAccount.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((cusAccountInfo = br.readLine()) != null)
			{
				cInfo = cusAccountInfo.split(",");
				Customer cus = new Customer(Integer.parseInt(cInfo[0]),cInfo[1],cInfo[2],cInfo[3]);
				customers.add(cus);
				System.out.println("Account ID: " + cInfo[0] + " Customer Name: " + cInfo[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	System.out.println("Please select one customer account you want delete");
    	Scanner input = new Scanner(System.in);
    	index = input.nextInt() - 1;
    	customers.remove(index);
    	
    	FileOperation.saveCusInfoFile(customers);
    	
	}
	
	public static void regist()
	{
		String itemInfo;
		int id = 0;
		boolean find = false;
		FileOperation.createFile("CustomerAccount.txt");
		String[] cusAccountInfo = new String[4];
		
		
		System.out.println("Please input your customer Name");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("Please input your account password");
		Scanner input2 = new Scanner(System.in);
		String password = input.nextLine();
		
		File file = new File("./CustomerAccount.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((itemInfo = br.readLine()) != null && !find)
			{
				cusAccountInfo = itemInfo.split(",");
				if (Integer.parseInt(cusAccountInfo[0]) >= id)
				{
					id = Integer.parseInt(cusAccountInfo[0]) + 1;
				}
				if (cusAccountInfo[1] == name)
				{
					find = true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!find)
		{
			customer = new Customer(id,name,"customerAuthority",password);
			FileOperation.writeCusInfoFile(customer.toString());
		}
		
	}
	
	public static boolean testLogin(String uName,String uPassword)
    {
    	String AccountInfo = uName + "," + uPassword;
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
	
	public static boolean testLoginCustomer(String cName,String cPassword)
	{
		String AccountInfo = cName + "," + cPassword;
    	String item;
    	boolean find = false;
    	File file = new File("./CustomerAccount.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((item = br.readLine()) != null)
			{
				System.out.println(item);
				String[] info = item.split(",");
				if ((info[1]+","+info[3]).equals(AccountInfo))
				{
					find = true;
					customer = new Customer(Integer.parseInt(info[0]),info[1],info[2],info[3]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return find;
	}
}
