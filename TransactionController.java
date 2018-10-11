 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class TransactionController {

    private static ArrayList<String> orderInfo;
    public static void checkOrderInfo()
    {
        String item;
        boolean find = false;
        File file = new File("./OrderInfo.txt");
        int number = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((item = br.readLine()) != null)
            {
                number += 1;
                System.out.println(number + " " + item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void confirmOrder()
    {
        String item;
        orderInfo = new ArrayList<String>();
        
        File file = new File("./OrderInfo.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((item = br.readLine()) != null)
            {
                orderInfo.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Please input Order number you want to confirm!");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt())
                {
                    System.out.println("Please enter a number");
                    input.next();
                }
        int orderNumber = input.nextInt() - 1;
        try
        {
            String newInfo = orderInfo.get(orderNumber).replace("pending","success");
            orderInfo.set(orderNumber,newInfo);
        } catch (Exception e){
            System.out.println("Incorrect input");
        }
        
        try {
            FileWriter out = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(out);
            for(String order:orderInfo)
            {

                bw.write(order);
                bw.newLine();               
            }
            bw.flush();
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
