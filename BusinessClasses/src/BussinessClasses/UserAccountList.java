/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessClasses;

import static BussinessClasses.UserAccount.getInstance;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Egor
 */
public class UserAccountList {
    private final int SIZE=10;
    private final  UserAccount arrUserAccountList[];
    public UserAccountList()
    {
        arrUserAccountList=new UserAccount[SIZE]; 
    }
    public UserAccount search(String username)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(username.equals(arrUserAccountList[i].getUserName()))
                    return arrUserAccountList[i];
                  
            }
            
        }
        return null;
    }
    public boolean add(UserAccount POINTER)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]==null)
            {
                arrUserAccountList[i]=POINTER;
                return true;
            }
        }
        return false;
    }
    public boolean add(String username,String password,String email)
    {
        UserAccount usr = getInstance(username,password,email);
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]==null)
            {
                arrUserAccountList[i]=usr;
                return true;
            }
            
        }
        return false;
    }
    public boolean edit(String username,UserAccount POINTER)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                   arrUserAccountList[i].setUsername(POINTER.getUserName());
                   arrUserAccountList[i].setEmail(POINTER.getEmail());
                   arrUserAccountList[i].setPassword(POINTER.getPassword());
                   return true;
                }
            }    
        }
        return false;
    }
    public boolean edit(String username,String password,String email)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                    UserAccount usr = getInstance(username,password,email);
                    arrUserAccountList[i]=usr;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean remove (String username)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                    arrUserAccountList[i]=null;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean changeUsername(String username,String newUsername)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                   arrUserAccountList[i].setUsername(newUsername);
                   UserAccount usr = getInstance(arrUserAccountList[i].getUserName(),
                                                 arrUserAccountList[i].getPassword(),
                                                 arrUserAccountList[i].getEmail());
                   arrUserAccountList[i]=usr;
                   return true;
                 }
            }
        }
        return false;
        
    }
    public boolean changePassWord(String username,String newPassword)
    {
        for (int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                    arrUserAccountList[i].setPassword(newPassword);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean changeEmail(String username, String newEmail)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(arrUserAccountList[i]!=null)
            {
                if(arrUserAccountList[i].getUserName().equals(username))
                {
                    arrUserAccountList[i].setEmail(newEmail);
                    return true;
                }
            }
        }
        return false;
    }
    public void clear()
    {
        Arrays.fill(arrUserAccountList,null);
    }
    public boolean authenticate(String username,String password)
    {
       load();
       for(int i=0;i<SIZE;i++)
       {
        //   System.out.print(arrUserAccountList[i].getUserName());
           if(arrUserAccountList[i]!=null)
           {
               if(arrUserAccountList[i].authenticate(username, password))
               {
                   clear();
                   return true;
               }
           }
       }
       clear();
       return false;
              
    }
    public void load()
    {
        Database_Load();
    }
    public void save()
    {
        Database_Save();
    }
    protected void Database_Load()
    {
       
        UserAccount usr1 = getInstance("joe","111","jsmith@comp1.com");
        UserAccount usr2 = getInstance("angel","222","arodrigez@comp1.com");
        UserAccount usr3 = getInstance("sam","333","speterson@comp1.com");
        UserAccount usr4 = getInstance("mary","444","mjonson@comp1.com");
        UserAccount usr5 = getInstance("nancy","555","nrivera@comp1.com");
        arrUserAccountList[0]=usr1;
        arrUserAccountList[1]=usr2;
        arrUserAccountList[2]=usr3;
        arrUserAccountList[3]=usr4;
        arrUserAccountList[4]=usr5;
                                                
    }
    protected void Database_Save()
    {
        JOptionPane.showMessageDialog(null, "Not yet implemented");
    }
    
}
