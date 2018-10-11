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
        private String userStatus;
        private PurchaseController pc;
        private AccountController ac;
    
        /**
         * Constructor for objects of class UserInterface
         */
        
        public UserInterface()
        {
            FileOperation.createFile("AccountInfo.txt");
            FileOperation.initialAccountFile();
            ac = new AccountController();
            pc = new PurchaseController();
    
        }
        
    
        public void main() {
            initialInterface();
            if(userStatus.equals("storeOwner")) 
            {
                
                menu();
            }
            else if(userStatus.equals("customer"))
            {
                displayCustomerInterface();
                menuCustomer();
            }
            else if(userStatus.equals("leave"))
            {
                System.out.println("Goodbye");
            }
        }
        
        
        public void displayCustomerInterface() 
        {
            System.out.println("Welcome to MVFs! " + ac.customer.getName());
            showShelfInterface();
            System.out.println("");
            System.out.println("");
        }
        
        
        public void initialInterface()
        {
            // put your code here
            boolean inputResonable = false;
            int option = 0;
            System.out.println("Welcome to MFVs!");
            while (!inputResonable)
            {
                System.out.println("----------------------------------------");
                System.out.println("Press 1 to login as store owner");
                System.out.println("Press 2 to view product");
                System.out.println("Press 3 to register an account as customer");
                System.out.println("Press 4 to login as a customer");
                System.out.println("Press 5 to exit");
                Scanner input = new Scanner(System.in);
                while (!input.hasNextInt())
                {
                    System.out.println("Please enter a number");
                    input.next();
                }
                option = input.nextInt();
                if (option >= 1 && option <= 5)
                {
                    inputResonable = true;
                }
                else {
                    System.out.println("You can only input 1 to 5!");
                }
            
            }
            switch (option) 
            {
                case 1:
                    userStatus = "storeOwner";
                    loginInterface(1);
                    break;
                case 2:
                    readProductAndCreateShelf();
                    displayShelf();
                    initialInterface();
                    break;
                case 3:
                    
                    userStatus = "customer";
                    AccountController.regist();
                    break;
                case 4:
                    userStatus = "customer";
                    loginInterface(2);
                    break;
                case 5:
                    userStatus = "leave";
                    break;
                default:
                    break;
            }
    }
    
    
    public void loginInterface(int i)
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
            while (userName.trim().length() < 6 || userName.trim().isEmpty())
            {
                System.out.println("Username must not be empty and has more than 5 characters");
                userName = input.nextLine();
            }
            System.out.println("Please input your password");
            passWord = input.nextLine();
            while (passWord.trim().length() < 6 || passWord.trim().isEmpty())
            {
                System.out.println("Password must not be empty and has more than 5 characters");
                passWord = input.nextLine();
            }
            if(i == 1)
            {
                if(AccountController.testLogin(userName,passWord))
                {
                    flag = true;
                    showShelfInterface();
                }
                else {
                    System.out.println("your account information is wrong!");
                }
            }
            else if(i == 2)
            {
                if(AccountController.testLoginCustomer(userName, passWord))
                {
                    flag = true;
                }
                else {
                    System.out.println("your account information is wrong!");
                }
            }
        }
//      showShelfInterface();
    }
    

    
    public void showShelfInterface()
    {
        FileOperation.readProduct();
        FileOperation.readShelf();
        displayProduct();
        displayShelf();
    }
    
    public void readProductAndCreateShelf()
    {
        String productItem;
        PurchaseController.productList.clear();
        PurchaseController.productShelfs.clear();
//      System.out.println("size:" + PurchaseController.productList.size());
        int index = 0;
        String[] productInfo = new String[7];
        File file = new File("./ProductInfo.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((productItem = br.readLine()) != null)
            {
                index += 1;
                productInfo = productItem.split(",");
                Product product = new Product(Integer.parseInt(productInfo[0]),productInfo[1],productInfo[2],Integer.parseInt(productInfo[3]),productInfo[4],productInfo[5],Double.parseDouble(productInfo[6]));
                PurchaseController.productList.add(product);
                ProductShelf productShelf = new ProductShelf(product,new Date(),"available","no");
                PurchaseController.productShelfs.add(productShelf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayProduct()
    {
        System.out.println("----------ProductList--------");
        for (Product product:PurchaseController.productList)
        {
            product.displayProductInfo();
        }
    }
    
    public void displayShelf()
    {
        System.out.println("----------Shelf----------");
        for(ProductShelf shelf:PurchaseController.productShelfs)
        {
            shelf.displayShelfInfo();
        }
        System.out.println();
    }
    
    
    public void menuCustomer()
    {
        boolean exit = false;
        while(!exit)
        {
            boolean valid = false;
            while(!valid)
            {
                System.out.println("Please input your options");
                System.out.println("Press 0 to search product");
                System.out.println("Press 1 to add product to cart");
                System.out.println("Press 2 to view your cart");
                System.out.println("Press 3 to remove product from your cart");
                System.out.println("Press 4 to check out");
                System.out.println("Press 5 to display product");
                System.out.println("Press 6 to log out");
                Scanner input = new Scanner(System.in);
                while (!input.hasNextInt())
                {
                    System.out.println("Please enter a number");
                    input.next();
                }
                int option = input.nextInt();
                if (option >= 0 && option <= 6)
                {
                    valid = true;
                }
                else {
                    System.out.println("You can only input from 1 to 6");
                }
                switch (option) {
                case 0:
                    System.out.println("Please input product keyword:");
                    Scanner input0 = new Scanner(System.in);
                    String keyword = input0.nextLine();
                    SearchController.searchProduct(keyword);
                    break;
                case 1:
                    String available = "out of stack";
                    int pid = 0;
                    while(available.equals("out of stack"))
                    {
                        System.out.println("Please select product id");
                        Scanner input2 = new Scanner(System.in);
                        pid = input2.nextInt();
                        available = PurchaseController.checkAvailable(pid, PurchaseController.productShelfs);
                        if(available.equals("out of stack"))
                            System.out.println("This product is out of stcak");
                    }
                    
                    
                    System.out.println("Please select product number");
                    Scanner input3 = new Scanner(System.in);
                    int pNumber = input3.nextInt();
                    PurchaseController.cart = PurchaseController.addCartList(PurchaseController.cart,pid,pNumber,PurchaseController.productList);
                    
                    break;
                case 2:
                    PurchaseController.showCartList(PurchaseController.cart);
                    break;
                case 3:
                    PurchaseController.removeCartProduct(PurchaseController.cart);
                    break;
                case 4:
                    PurchaseController.checkOut(PurchaseController.cart);
                    exit = true;
                    break;
                case 5:
                    displayShelf();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    break;
                }
            }
        }

    }
    
    public void menu()
    {
        boolean exit = false;
        while(!exit)
        {
            boolean valid = false;
            while(!valid) {
                System.out.println("Please input your options:");
                System.out.println("Press 1 to add product");
                System.out.println("Press 2 to delete product");
                System.out.println("Press 3 to edit product");
                System.out.println("Press 4 to delete customer account");
                System.out.println("Press 5 to check order information");
                System.out.println("Press 6 to confirm order");
                System.out.println("Press 7 to display product");
                System.out.println("Press 8 to log out");
                Scanner input = new Scanner(System.in);
                while (!input.hasNextInt())
                {
                    System.out.println("Please enter a number");
                    input.next();
                }
                int option = input.nextInt();
                if (option >= 1 && option <= 8)
                {
                    valid = true;
                }
                else {
                	System.out.println("You can only input 1 to 6!");
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
        			displayShelf();
        			break;
        		case 4:
        			
//        			AccountController.logOut();
        			AccountController.deleteAccount();
        			break;
        		case 5 :
        			TransactionController.checkOrderInfo();
        			break;
        		case 6:
        			TransactionController.confirmOrder();
        			break;
        		case 7:
        			displayShelf();
        			break;
        		case 8:
        			exit = true;
        			break;
        		default:
        			break;
        	    	
        	    }
        	}
    	}	
    }
}
