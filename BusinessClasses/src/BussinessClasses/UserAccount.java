package BussinessClasses;




import java.util.UUID;
import javax.swing.JOptionPane;
public class UserAccount {
    private UUID userAccountId;
    private String username;
    private String password;
    private String email;
  private  UserAccount()
    {
        this.userAccountId=UUID.randomUUID();
        this.username=" ";
        this.password=" ";
        this.email=" ";
    }
 private   UserAccount(String usr,String pass,String em)
    {
        this.userAccountId=UUID.randomUUID();
        setUsername(usr);
        setPassword(pass);
        setEmail(em);
    }
 
    public String getUserAccountId()
    {
        return userAccountId.toString();
    }
    public String getUserName ()
    {
        return username;
        
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    
    public void setUsername(String usr)
    {
        this.username=usr;
    }
    public void setPassword(String m_Password)
    {
        this.password=m_Password;
    }
    public void setEmail(String m_Email)
    {
        this.email=m_Email;
    }
    public static UserAccount getInstance()
    {
       
       UserAccount usr =  new UserAccount();
       return usr;
    }
    public static UserAccount getInstance(String U,String P,String E)
    {
        UserAccount usr = new UserAccount(U,P,E);
        return usr;
    }
    public boolean authenticate(String U,String P)
    {
        return ((U.equals(getUserName()))&&(P.equals(getPassword()))) ? true : false;
    }
    public void load(String key)
    {
       Database_Load(key);
    }
    public void insert()
    {
          Database_Insert();
    }
    public void update()
    {
           Database_Update();
    }
    public void delete()
    {
          Database_Delete();
    }
    protected void Database_Load(String key)
    {
           JOptionPane.showMessageDialog(null, "Target for future implementation");
    }
    protected void Database_Insert()
    {
           JOptionPane.showMessageDialog(null, "Target for future implementation");
    }
    protected void Database_Update()
    {
           JOptionPane.showMessageDialog(null, "Target for future implementation");
    }
    protected void Database_Delete()
    {
           JOptionPane.showMessageDialog(null, "Target for future implementation");
    }
}
