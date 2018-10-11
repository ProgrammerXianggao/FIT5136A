 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class PurchaseController {

    private static UserInterface ui;
    private static Payment payment;
    private static Customer customer;
    private static Order order;
    public static ArrayList<Product> productList;
    public static ArrayList<ProductShelf> productShelfs;
    public static Cart cart;
    private static AccountController ac;
//    public static AccountController ac;
    
    public PurchaseController()
    {
        productList = new ArrayList<Product>(); 
        productShelfs = new ArrayList<ProductShelf>();
        cart = new Cart();
        ac = new AccountController();
    }
    
    public static Cart addCartList(Cart cart,int productID,int productNumber,ArrayList<Product> productList)
    {
        boolean isFail = false;
        for (Product product:productList)
        {
            if (product.getProductID() == productID)
            {
                cart.getCartList().add(product);
                cart.getNumberList().add(productNumber);
                isFail = true;
            }
            
        }
        if (isFail == true)
        {
            System.out.println("Item added");
        }
        else
        {
            System.out.println("Incorrect input");
        }
        return cart;
    }
    
    
    public static String checkAvailable(int productNumber,ArrayList<ProductShelf> productShelfs)
    {
        String available = "available";
        for(ProductShelf productShelf:productShelfs)
        {
            if (productShelf.getProduct().getProductID()==productNumber)
                
            {
                if(productShelf.getRequirement().equals("no"))
                {
                    productShelf.setRequirement("yes");
                }
                
                available = productShelf.getStatus();
                
            }
        }
        FileOperation.writeShelfFile(productShelfs);
        return available;
    }
    
    
    public static void setCartList()
    {
        
    }
    
    public static void showCartList(Cart cart)
    {
        System.out.println("--------Your cart--------");
        double totalPrice = 0;
        for(int i = 0;i < cart.getCartList().size();i++)
        {
            System.out.println((i+1) + " " + cart.getCartList().get(i).getProductName() + " " + cart.getNumberList().get(i) + " "
                    + cart.getCartList().get(i).getSaleMethod() + " " + cart.getCartList().get(i).getPrice()*cart.getNumberList().get(i));
//          cart.getCartList().get(i);
            totalPrice += cart.getCartList().get(i).getPrice()*cart.getNumberList().get(i);
        }
        
//      for(Product product:cart.getCartList())
//      {
////            product.displayProductInfo();
//          totalPrice += product.getPrice();
//      }
        System.out.println("Total price: " + totalPrice);
        
    }
    
    public static void removeCartProduct(Cart cart)
    {
        System.out.println("Please select which product you want to remove:");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt())
        {
            System.out.println("Please enter a number");
            input.next();
        }
        int cartProductNo = input.nextInt() - 1;
        System.out.println("Please input how much quantity you want to remove:");
        Scanner input2 = new Scanner(System.in);
        while (!input2.hasNextInt())
        {
            System.out.println("Please enter a number");
            input2.next();
        }
        int CartProductQuantity = input2.nextInt();
        try{
            int newQuantity = cart.getNumberList().get(cartProductNo) - CartProductQuantity;
            if (newQuantity <= 0)
            {
                cart.getCartList().remove(cartProductNo);
                cart.getNumberList().remove(cartProductNo);
            }
            else
            {
                cart.getNumberList().set(cartProductNo, newQuantity);   
            }
        } catch (Exception e)
        {
            System.out.println("Incorrect input");
        }
    }
    
    public static void checkOut(Cart cart)
    {
        System.out.println("Please input your emailAddress:");
        Scanner input = new Scanner(System.in);
        String emailAddress = input.nextLine();
        while (emailAddress.trim().isEmpty() || !emailAddress.trim().
        matches("^([a-zA-Z0-9]+)[@]([a-zA-Z0-9]+)[.]([a-zA-Z])$")) 
        {
            System.out.println("Email address must not be empty with correct format");
            emailAddress = input.nextLine();
        }
        System.out.println("Please input your phoneNumber:");
        Scanner input2 = new Scanner(System.in);
        String phoneNumber = input.nextLine();
        while (phoneNumber.trim().isEmpty() || phoneNumber.trim().matches(".*[a-zA-Z].*"))
        {
            System.out.println("Phone number must not be empty and no letter");
            phoneNumber = input2.nextLine();
        }
        System.out.println("Please input your deliveryAddress:");
        Scanner input3 = new Scanner(System.in);
        String address = input.nextLine();
        while (address.trim().isEmpty())
        {
            System.out.println("Address must not be empty");
            address = input3.nextLine();
        }
        System.out.println("Please input your cardNumber:");
        Scanner input4 = new Scanner(System.in);
        String cardNumber = input.nextLine();
        while (cardNumber.trim().isEmpty() || cardNumber.trim().length() != 12 
        ||cardNumber.trim().matches(".*[a-zA-Z].*"))
        {
            System.out.println("Card number must not be empty, no letter, contain 12 numbers");
            cardNumber = input4.nextLine();
        }
        System.out.println("Please input your cvv Code:");
        Scanner input5 = new Scanner(System.in);
        String cvvCode = input5.nextLine();
        while (cvvCode.trim().isEmpty() || cardNumber.trim().length() != 3
        || cvvCode.trim().matches(".*[a-zA-Z].*"))
        {
            System.out.println("CVV code must not be empty, no letter, contain 3 number");
            cvvCode = input5.nextLine();
        }
        System.out.println("Please input your Valid Start Date(eg. 11/17)");
        Scanner input6 = new Scanner(System.in);
        String validDateStart = input6.nextLine();
        while (validDateStart.trim().isEmpty() || !validDateStart.trim().matches("^[0-9]{1,2}[/][0-9]{1,2}$"))
        {
            System.out.println("Date must not be empty and no letter");
            validDateStart = input6.nextLine();
        }
        System.out.println("Please input your Valid End Date(eg. 11/20)");
        Scanner input7 = new Scanner(System.in);
        String valiDateEnd = input7.nextLine();
        while (valiDateEnd.trim().isEmpty() || !valiDateEnd.trim().matches("^[0-9]{1,2}[/][0-9]{1,2}$"))
        {
            System.out.println("Date must not be empty and no letter");
            valiDateEnd = input7.nextLine();
        }
    
        String paymentInfomation = emailAddress + "," + phoneNumber + "," + address + "," + cardNumber + "," + cvvCode + "," + validDateStart + "," + valiDateEnd;
        if(checkPaymentInfo(paymentInfomation))
        {
            
            payment = new Payment(AccountController.customer.getName(),emailAddress,phoneNumber,address,cardNumber,cvvCode,validDateStart,valiDateEnd);
            order = new Order(cart,new Date(),"pending",payment);
            saveOrder(order);
        }
        
        
    }
    
    public static boolean checkPaymentInfo(String paymentInfo)
    {
        return true;
    }
    

    
    public static void saveOrder(Order order)
    {
        FileOperation.createFile("OrderInfo.txt");
        File file = new File("./OrderInfo.txt");
        String customerName = order.getPayment().getRecipentName();
//      String customerName = order.getCart().getCustomer().getName();
        String deliverAddress = order.getPayment().getDeliveryAddress();
        String status = order.getOrderCondition();
        
        
        int totalPrice = 0;
        String productInfo = "";
        for (int i = 0;i < order.getCart().getCartList().size(); i++)
        {
            order.getCart().getNumberList().get(i);
            productInfo += order.getCart().getNumberList().get(i) + " " + order.getCart().getCartList().get(i).getSaleMethod() + " of " + order.getCart().getCartList().get(i).getProductName() + " ";
            totalPrice += order.getCart().getNumberList().get(i) * order.getCart().getCartList().get(i).getPrice();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        
        try {
            FileWriter out = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(out);
            bw.write(customerName + " " + productInfo + " " + totalPrice + " " + deliverAddress + " " + status + " " + df.format(order.getOrderTime()));
            bw.newLine();
            bw.flush();
            bw.close();
            System.out.println("The AccountInfo is writen successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
}
