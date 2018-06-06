package virtualshoppingsystem;

import java.awt.AWTException;
import java.io.IOException;
import static virtualshoppingsystem.VSS.*;

public class User {
    static boolean k = false;
    static int ObjectCounter = 0;
    
    public static void userLogin(String name, String pass) throws IOException, AWTException {
//            System.out.println("UserLogin Method in User Class ");
//            System.out.println(k);
        
            k=false;
        while (k == false) {
//            System.out.println("UserLogin Method in User Class while Loop");
//            System.out.println("Enter UserName: ");            
//            String name = sc.next();
//            System.out.println("Enter Password: ");
//            String pass= sc.next();
            //Styling.clearConsole();
            Accounts log = new Accounts(name, pass);
            k = log.logIn(name, pass);
//            System.out.println("\n");
//            if (k == false) {
//                System.out.println("Wrong UserName or Password" + "\n" + "Try Again");
//            } else ----
                if (k == true) {
                System.out.println("");
                System.out.println("Welcome To Virtual Shopping Store :)" + "\t" + name);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                loginRecord(name);
                //userOption();
            }

            ObjectCounter++;
        }
    }
    
    public static boolean userLoginCheck(String name, String pass) throws IOException, AWTException {
            Accounts log = new Accounts(name, pass);
            k = log.logIn(name, pass);
            System.out.println("\n");
            if (k == false){
                System.out.println("Wrong UserName or Password" + "\n" + "Try Again");
                return k;
            }
            return k=true;
        }

    public static void userSignup(String name, String pass) throws IOException, AWTException {
//        while (k == false) {
            k=false;
//            System.out.println("Enter UserName: ");
//            String name = sc.next();
//            System.out.println("Enter Password: ");
//            String pass= sc.next();
//            System.out.println("\n");
            //Styling.clearConsole();
            Accounts sign = new Accounts(name, pass);
            k = sign.signUp(name, pass);
            loginRecord(name);
            //System.out.println("\n");
        
    }
    
    public static boolean userSignupCheck(String name, String pass) throws IOException, AWTException {
            Accounts sign = new Accounts(name, pass);
            if(k = sign.signUp(name, pass)==false)
                return false;
            return true;
            
    }
    
    static boolean userOption() throws IOException {
        boolean p = true;
        while (p == true) {
            System.out.println("What Operations You Want To Perform");
            System.out.println("Select One");
            System.out.println("1)Show Item List");
            System.out.println("2)Add to Cart");
            System.out.println("3)Delete from Cart");
            System.out.println("4)Clear Cart");
            System.out.println("5)LogOut");
            int Select = sc.nextInt();
            switch (Select) {
                case 1:
                    Cart showItems = new Cart();
                    showItems.showItemList();
                    System.out.println("\n");
                    break;
                case 2:
                    Cart clientoption1 = new Cart();
                    System.out.println("Enter ItemName: ");
                    String myItemAdd = sc.next();
                    System.out.println("\n");
                    clientoption1.addToCart(myItemAdd);
                    break;
                case 3:
                    Cart clientoption2 = new Cart();
                    System.out.println("Enter ItemName: ");
                    String myItemDelete = sc.next();
                    System.out.println("\n");
                    clientoption2.deleteFromCart(myItemDelete);
                    break;
                case 4:
                    System.out.println("\n");
                    Cart clientoption3 = new Cart();
                    clientoption3.clearCart();
                    System.out.println("\n");
                    break;
                case 5:
                    Cart history = new Cart();
                    history.ShoppingHistory();
                    p = false;
                    System.out.println("Thanks For Coming");
                    break;
            }
        }
        return p;
    }

    public static void loginRecord(String name) throws IOException {
        //userSno++;
        
            FileWriter ShoppingHistory = new FileWriter("ShoppingHistory.txt");
        ShoppingHistory.writeToFile("*" + "User Name:");
        ShoppingHistory.writeToFile(name);
        

    }
}
