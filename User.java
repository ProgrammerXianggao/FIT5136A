
/**
 * Write a description of class User here.
 *
 * @author (Team 41)
 * @version (4/10/2018)
 */
public class User
{
    private int id;
    private String name;
    private String authority;
    private String password;

    /**
     * Constructor for objects of class User
     */
    public User()
    {
        id = 1;
        name = "User";
        authority = "Customer";
        password = "Password";
    }
    
    public User(int userID, String userName, String userAuthority, String userPassword)
    {
        id = userID;
        name = userName;
        authority = userAuthority;
        password = userPassword;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setID(int userID)
    {
        id = userID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String userName)
    {
        name = userName;
    }
    
    public String getAuthority()
    {
        return authority;
    }
    
    public void setAuthority(String userAuthority)
    {
        authority = userAuthority;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String userPassword)
    {
        password = userPassword;
    }
}
