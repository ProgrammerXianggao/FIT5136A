 

import java.util.Date;
import java.util.Scanner;


public class ManageProductController {

//  private static UserInterface ui;
    private static PurchaseController pc;
    
    public ManageProductController()
    {
//      ui = new UserInterface();
    }
    
    public static void addProduct()
    {
        String productInfo;
        String[] productInfoList = new String[7];
        System.out.println("Please input product information");
        System.out.println("The format is id,productName,saleMethod,shelfLife,source,category,price");
        Scanner input = new Scanner(System.in);
        productInfo = input.nextLine();
        while (productInfo.trim().isEmpty())
        {
            System.out.println("Name must not be empty and must follow format");
            productInfo = input.nextLine();
        }
       
        try
        {
            productInfoList = productInfo.split(",");
            Product product = new Product(Integer.parseInt(productInfoList[0]),productInfoList[1],productInfoList[2],Integer.parseInt(productInfoList[3]),productInfoList[4],productInfoList[5],Double.parseDouble(productInfoList[6]));
            pc.productList.add(product);
            ProductShelf productShelf = new ProductShelf(product,new Date(),"available","no");
            pc.productShelfs.add(productShelf);
        } catch (Exception e)
        {
            System.out.println("Incorrect input");
        }
        FileOperation.writeProductFile(pc.productList);
        FileOperation.writeShelfFile(pc.productShelfs);
    }
    
    public static void deleteProduct()
    {
        System.out.println("Please input the number of product you want to delete");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt())
        {
            System.out.println("Please enter a number");
            input.next();
        }
        int productNumber = input.nextInt();
        boolean isFalse = false;
        try{
            for(int i = 0;i < pc.productList.size();i++)
            {
                if(pc.productList.get(i).getProductID() == productNumber)
                {
                    pc.productList.remove(i);
                    pc.productShelfs.remove(i);
                    isFalse = true;
                }
                
            }
        } catch (Exception e)
        {
            System.out.println("Error");
        }
        if (isFalse == true)
        {
            System.out.println("Product deleted");
        }
        else
        {
            System.out.println("Incorrect input");
        }
        FileOperation.writeProductFile(pc.productList);
        FileOperation.writeShelfFile(pc.productShelfs);
    }
    
    public static void editProduct()
    {
        System.out.println("Please input the number of product you want to edit");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt())
        {
            System.out.println("Please enter a number");
            input.next();
        }
        int productNumber = input.nextInt();
        int realProductNumber = 0;
        boolean isFalse = false;
        try{
            for (int i = 0;i < pc.productList.size();i ++)
            {
                if (pc.productList.get(i).getProductID() == productNumber)
                {
                    realProductNumber = i;
                    isFalse = true;
                }
                
            }
        } catch (Exception e)
        {
            System.out.println("Error");
        }
        if (isFalse == true)
        {
            System.out.println("The selected product is : " + pc.productList.get(realProductNumber).getProductName());
            System.out.println("Choose what you want to edit");
            System.out.println("1:product name 2:saleMethod 3:shelfLife 4:source 5:category 6:price 7:status");
            Scanner input2 = new Scanner(System.in);
            while (!input2.hasNextInt())
                    {
                        System.out.println("Please enter a number");
                        input2.next();
                    }
            int option = input2.nextInt();
            switch (option) {
            case 1:
                System.out.println("Please input new product name");
                Scanner input3 = new Scanner(System.in);
                String newProductName = input3.nextLine();
                while (newProductName.trim().isEmpty() || newProductName.trim().matches(".*[1-9].*"))
                            {
                                System.out.println("Name must not be empty and contain number");
                                newProductName = input3.nextLine();
                            }
                pc.productList.get(realProductNumber).setProductName(newProductName);
                break;
            case 2:
                System.out.println("Please input new saleMethod");
                Scanner input4 = new Scanner(System.in);
                String newSaleMethod = input4.nextLine();
                while (newSaleMethod.trim().isEmpty() || newSaleMethod.trim().matches(".*[1-9].*"))
                            {
                                System.out.println("Sale Method must not be empty and contain number");
                                newSaleMethod = input4.nextLine();
                            }
                pc.productList.get(realProductNumber).setSaleMethod(newSaleMethod);
                break;
            case 3:
                System.out.println("Please input new shelfLife");
                Scanner input5 = new Scanner(System.in);
                while (!input5.hasNextInt())
                            {
                                System.out.println("Please enter a number");
                                input5.next();
                            }
                int newShelfLife = input5.nextInt();
                pc.productList.get(realProductNumber).setShelfLife(newShelfLife);
                break;
            case 4:
                System.out.println("Please input new source");
                Scanner input6 = new Scanner(System.in);
                String newSource = input6.nextLine();
                while (newSource.trim().isEmpty() || newSource.trim().matches(".*[1-9].*"))
                            {
                                System.out.println("Source must not be empty and contain number");
                                newSource = input6.nextLine();
                            }
                pc.productList.get(realProductNumber).setSource(newSource);
                break;
            case 5:
                System.out.println("Please input new category");
                Scanner input7 = new Scanner(System.in);
                String newCategory = input7.nextLine();
                while (newCategory.trim().isEmpty() || newCategory.trim().matches(".*[1-9].*"))
                            {
                                System.out.println("Category must not be empty and contain number");
                                newCategory = input7.nextLine();
                            }
                pc.productList.get(realProductNumber).setCategory(newCategory);
                break;
            case 6:
                System.out.println("Please input new price");
                Scanner input8 = new Scanner(System.in);
                while (!input8.hasNextInt())
                            {
                                System.out.println("Please enter a number");
                                input8.next();
                            }
                int newPrice = input8.nextInt();
                pc.productList.get(realProductNumber).setPrice(newPrice);
                break;
            case 7:
            
                if (pc.productShelfs.get(realProductNumber).getStatus().equals("available"))
                {
                    pc.productShelfs.get(realProductNumber).setStatus("out of stack");
                }
                else {
                    pc.productShelfs.get(realProductNumber).setStatus("available");
                    pc.productShelfs.get(realProductNumber).setRequirement("no");
                }
                System.out.println("Change status successful!");
                break;
            default:
                break;
            }
            System.out.println("Modification is success!");
            FileOperation.writeProductFile(pc.productList);
            FileOperation.writeShelfFile(pc.productShelfs);
        }
        else
        {
            System.out.println("Incorrect input");
        }
        
//      ui.displayProduct();
//      ui.displayShelf();
    }
    
    
}
