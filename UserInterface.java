import java.util.*;
import java.util.Scanner;

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

    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        // initialise instance variables
        user = new User();
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
            System.out.println("123");
        }
        
    }
    

}
