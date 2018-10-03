
/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Order
{
    // instance variables - replace the example below with your own
    private int x;
    private Cart cart;
    private Date orderTime;
    
    /**https://www.cnblogs.com/remember-forget/p/6098462.html datetime
     * Constructor for objects of class Order
     */
    public Order()
    {
        // initialise instance variables
        orderTime = new Date();
        x = 0;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void displayTime ()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
    }
    
    public Date getTime()
    {
        return orderTime;
    }
}
