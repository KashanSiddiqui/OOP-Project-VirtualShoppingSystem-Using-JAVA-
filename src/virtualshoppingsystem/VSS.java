package virtualshoppingsystem;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;

public class VSS {

    static boolean x = false;
    static boolean k = false;
    static boolean z = false;
    static int ObjectCounter = 0;

    public static void run() throws IOException, AWTException {
        //while (x==false) {
        //Styling.enterKey();

        System.out.println("\t\t\t=======WELCOME========");
        System.out.println("\t\t\tVirtual Shopping Store");
        System.out.println("\t\t\t======================");
        Styling.enterKey();
        userChoice();
        // }    
    }

    static Scanner sc = new Scanner(System.in);

    public static void userChoice() throws IOException, AWTException {
        System.out.println("Choose One:");
        System.out.println("1)Already have an account");
        System.out.println("2)Signup");
        System.out.println("Enter 1 OR 2:");
        int choice = sc.nextInt();
        if (choice == 1) {

            System.out.println("To login as User enter 1");
            System.out.println("To login as Admin enter 2");
            int logchoice = sc.nextInt();
            //Styling.clearConsole();
            switch (logchoice) {
                case 1:
                    //User.userLogin();
                    break;
                case 2:
                    //adminLogin();
                    break;
            }
        } else {
            //User.userSignup();
            //User.userOption();
        }

    }

    public static void adminLogin(String name, String pass) throws IOException, AWTException {
        while (k == false) {
//            System.out.println("Enter AdminName: ");            
//            String name = sc.next();
//            System.out.println("Enter Password: ");
//            String pass= sc.next();
            //Styling.clearConsole();
            Admin adminLogin = new Admin(name, pass);
            k = adminLogin.logIn(name, pass);
            if (k == false) {
                System.out.println("Wrong AdminName or Password" + "\n" + "TRY AGAIN");
                System.out.println("\n");
            } else if (k == true) {
                System.out.println("");
                System.out.print("Welcome To Virtual Shopping Store :) " + name);

                
                   // z = adminOptions();
                

            }
            
        }
    }
    
    public static boolean adminLoginCheck(String name, String pass) throws IOException, AWTException {
        
            Admin adminLogin = new Admin(name, pass);
            k = adminLogin.logIn(name, pass);
            if (k == false) {
                
                System.out.println("Wrong AdminName or Password" + "\n" + "TRY AGAIN");
                System.out.println("\n");
                k=false;
                
            } else if (k == true) {
                System.out.println("");
                System.out.print("Welcome To Virtual Shopping Store :) " + name);
                k=true;

            }
            return k;
        
    }

    static private boolean adminOptions() throws IOException, AWTException {
        boolean y = false;
        System.out.println("What Operations You Want To Perform");
        System.out.println("Select One");
        System.out.println("1)See Users Data");
        System.out.println("2)See Admins data");
        System.out.println("3)Add Another Admin");
        System.out.println("4)Delete User");
        System.out.println("5)See Item List");
        System.out.println("6)Add Item");
        System.out.println("7)Delete Item");
        System.out.println("8)Increase Stock");
        System.out.println("9)Decrease Stock");
        System.out.println("10)Users Shopping History");
        System.out.println("11)Clear Shopping History");
        System.out.println("12)LogOut");
        int Select = sc.nextInt();
        System.out.println("\n");
        switch (Select) {
            case 1:
                Admin adminoption1 = new Admin();
                adminoption1.userData();
                break;
            case 2:
                Admin adminoption2 = new Admin();
                adminoption2.adminData();
                break;
            case 3:
                System.out.println("Enter AdminName: ");
                String Adminname = sc.next();
                System.out.println("Enter Password: ");
                String Adminpass = sc.next();
                Admin adminoption3 = new Admin(Adminname, Adminpass);
                System.out.println("\n");
                adminoption3.addAdmin(Adminname, Adminpass);
                break;
            case 4:
                System.out.println("Enter UserName: ");
                String Username = sc.next();
                System.out.println("Enter UserPassword: ");
                String Userpass = sc.next();
                Admin adminoption4 = new Admin(Username, Userpass);
                System.out.println("\n");
                adminoption4.deleteUser(Username, Userpass);
                break;
            case 5:
                Cart list = new Cart();
                list.showItemList();
                break;
            case 6:
                System.out.println("Enter ItemName: ");
                String ItemName = sc.next();
                System.out.println("Enter ItemCost: ");
                String ItemCost = sc.next();
                System.out.println("Enter Item Stock: ");
                String itemStock = sc.next();
                Admin adminoption5 = new Admin();
                System.out.println("\n");
                adminoption5.addItem(ItemName, ItemCost, itemStock);
                break;
            case 7:
                System.out.println("Enter ItemName: ");
                String DeleteItemName = sc.next();
                Admin adminoption6 = new Admin();
                System.out.println("\n");
                adminoption6.deleteItem(DeleteItemName);
                break;
            case 8:
                System.out.println("Enter ItemName:");
                String Item = sc.next();
                System.out.println("Enter Quantity:");
                int quantityIncrease = sc.nextInt();
                Stock add = new Stock();
                add.increaseStock(Item, quantityIncrease);
                System.out.println("\n");
                break;
            case 9:
                System.out.println("Enter ItemName:");
                String item = sc.next();
                System.out.println("Enter Quantity:");
                int quantityDecrease = sc.nextInt();
                Stock reduce = new Stock();
                reduce.reduceStock(item, quantityDecrease);
                System.out.println("\n");
                break;
            case 10:
                Admin adminoption7 = new Admin();
                adminoption7.showShoppingHistory();
                break;
            case 11:
                Admin adminoption8 = new Admin();
                adminoption8.clearHistory();
                break;
            case 12:
                y = true;
                System.out.println("Thanks For Coming");

                break;
        }

        return y;

    }

}
