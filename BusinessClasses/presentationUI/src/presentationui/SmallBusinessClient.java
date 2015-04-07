/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationui;

import BussinessClasses.UserAccount;
import BussinessClasses.UserAccountList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Egor
 */
public class SmallBusinessClient {

   public  static UserAccountList arrUserAccountList = new UserAccountList();
        public static boolean Authentication(String userrName,String password)
    {
       if(arrUserAccountList.authenticate(userrName, password))
           return true;
       else
           return false;
               
    }
        private static int choice;
        public static void backEndScreen()
        {
            System.out.print("Welcome to the Back-end & Maintance Management Portal");
            System.out.print("\n\n1. User Account Management"
                                +"\n0.Exit & Save (return to Main Screen)"
                                +"\n\nPlease select a menu option(1, or 0)");
            Scanner choice = new Scanner (System.in);
            int ch=choice.nextInt();
            switch (ch)
            {
                case 1:
                  startCustomerManagement();
                    break;
                case 0:
                    mainScreen();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    break;
            }
            
        }
        public static int mainScreen()
        {
          
               System.out.print("\nWelcome to the Small Business Application");
               System.out.print("\n\n\t1. Back end Management Screen\n"
                                    +"\t2. Retail Point-Of-Sales Screen\n"
                                    +"\t3. Exit(return to Login screen)"
                                    +"\n\n Please select a menu option (1,2 or 0)");
               Scanner scan = new Scanner (System.in);
               int ch=scan.nextInt();
               switch(ch)
               {
                   case 1:
                       backEndScreen();
                       break;
                   case 2:
                       retail();
                       break;
                   case 3:
                       return 0;
                       
               }
               return ch;
        }
        //Retail Point of sales
        public static void retail()
        {
            System.out.print("Welcome to Retail Point-of-Sales Portal\n\n");
            Scanner scan = new Scanner (System.in);
            int choice;
            System.out.print("1. Register New Customer\n");
            System.out.print("0. Exit (return to Main Screen)");
            System.out.print("\n Please select a menu option(1 or 0)");
            choice=scan.nextInt();
            switch(choice)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "Under construction:(");
                    mainScreen();
                    break;
                case 2:
                    mainScreen();
                    break;
                default:
                    break;
                    
            }
        }
        
        
        //User account Screen START*/
        public static void searchUserAccount()
        {
            
            UserAccount userS;
            String user;
            System.out.print("Search User Account");
            System.out.print("\n\n\nPlease enter Username\n");
            Scanner scan = new Scanner (System.in);
            user=scan.next();
                       userS=arrUserAccountList.search(user);
           if(userS!=null)
           {
               System.out.print("UserId:     "+userS.getUserAccountId()
               +"\nUsername       "+userS.getUserName()
               +"\nPassword       "+userS.getPassword()
               +"\nEmail      "+userS.getEmail());
           }
              
           else
              System.err.print("Not fount");
       //    userAccountManagementScreen();
         
        }
        public static void userAdd()
        {
            System.out.print("Add New User Account\n\n");
            String user,password,email;
          
            Scanner scan  = new Scanner (System.in);
            System.out.print("\tPlease enter Username\n");
            user = scan.next();
            System.out.print("\tPlease enter Password\n");
            password=scan.next();
            System.out.print("\tPlease enter Email\n");
            email=scan.next();
            
            if(arrUserAccountList.add(user, password, email))
            {
                 
                System.out.print("User Account has been added succesfully");
               
            }
            else
                System.out.print("Error");
         //   userAccountManagementScreen();
        }
        public static void editUserAccount()
        {
            Scanner scan  = new Scanner (System.in);
            String username,password,email;
            System.out.print("Edit User Account\n");
            System.out.print("Enter enter current Username\n");
            username=scan.next();
            System.out.print("\nPlease enter New Password\n");
            password=scan.next();
            System.out.print("Please enter New email\n");
            email=scan.next();
            if(arrUserAccountList.edit(username, password, email))
                System.out.print("USer Account Edited Successfully");
            else
                System.err.print("Error");
            //userAccountManagementScreen();
        }
        public static void removeUserAccount()
        {
            System.out.print("Remove User Account\n\n");
            System.out.print("Please enter Username of record to delete ");
            Scanner scan  = new Scanner (System.in);
            String username=scan.next();
            if(arrUserAccountList.remove(username))
                System.out.print("\n Record has been succesfully removed");
            else
                System.err.print("Error");
           // userAccountManagementScreen();
        }
        public static void changeUserName()
        {
            System.out.print("Change Username\n\n");
            String username;
            Scanner scan  = new Scanner(System.in);
            System.out.print("Enter Username of account to change:\t");
            username=scan.next();
            System.out.print("\n\nPlease enter New Username\n");
            String newUsername;
            newUsername=scan.next();
            if(arrUserAccountList.changeUsername(username, newUsername))
                System.out.print("\n\nEdit Result:\nUsername Changed Successfully");
            else
                System.err.print("Error");
           // userAccountManagementScreen();
        }
        public static void changePassword()
        {
            System.out.print("Change Password\n\n");
            String username;
            Scanner scan = new Scanner (System.in);
            System.out.print("Enter Username of to change password:\t");
            username=scan.next();
            Scanner pass =new Scanner(System.in);
            System.out.print("\n\nPleaseenter a New Password\n");
            String newPassword;
            newPassword=pass.nextLine();
            if(arrUserAccountList.changePassWord(username, newPassword))
                System.out.print("\n\nEdit Result:\nPassword Changed Succesfully");
            else
                System.err.print("Errot");
            //userAccountManagementScreen();
        }
        /*User account Screen END*/
        public static int userAccountManagementScreen()
        {
            int ch;
            System.out.print("\nWelcome to the User Account Management Portal");
            System.out.print("\n\n"
                    + "\t1. Search for a User Account Record\n"
                    + "\t2. Add a User Account Record\n"
                    + "\t3. Edit a User Account Record\n"
                    + "\t4. Remove a User Account Record\n"
                    + "\t5. Change a Username\n"
                    + "\t6. Change a Password\n"
                    + "\t7. Change an Email\n"
                    + "\t0. Exit & Save(Save & return to Back-end Mgt Screen)");
            System.out.print("\n\nPlease select a menu option(1,2,3,4,5,6 or 0)");
            Scanner scan = new Scanner (System.in);
            ch=scan.nextInt();
            System.out.println();
      
           
          return ch;
           
        }
        public static void startCustomerManagement()
        {
            int opt;
            
          arrUserAccountList.load();
           opt=userAccountManagementScreen();
            while(opt!=-1)
            {
                 switch(opt)
            {
                
                case 1:
                    searchUserAccount();
                    break;
                case 2:
                    userAdd();
                    break;
                case 3:
                    editUserAccount();
                    break;
                case 4:
                    removeUserAccount();
                    break;
                case 5:
                    changeUserName();
                    break;
                case 6:
                    changePassword();
                    break;
                case 7:
                    break;
                case 0:
                  backEndScreen();
                   
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    break;
                           
            }
                 opt=userAccountManagementScreen();
                 
            }
           arrUserAccountList.clear();
        }
    public static void main (String []args)
    {
    
       Scanner scan = new Scanner (System.in);
       String user;
       String pass;
       System.out.print("Welcome to authenticaton portal");
       System.out.print("\n\tPlease enter username: ");
       user=scan.next();
       System.out.print("\n\tPlease enter password: ");
       pass=scan.next();
       
     while(!user.equals("-1")||!pass.equals("-1"))
       {
           if(Authentication(user,pass))
           {
               System.out.print("\nAccess granted");
              int ch;
              ch= mainScreen();
               
               while(ch!=0)
               {
               switch(ch)
               {
                   case 1: 
                       startCustomerManagement();
                       break;
               }
               ch=mainScreen();
               }
           }
           else
           System.out.print("Access denied! ");
           System.out.print("\nWelcome to authenticaton portal");
            System.out.print("\n\tPlease enter username: ");
            user=scan.next();
            System.out.print("\n\tPlease enter password: ");
            pass=scan.next();              
       }
    }
}

