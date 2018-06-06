package virtualshoppingsystem;

import java.io.IOException;
import java.util.ArrayList;
import static virtualshoppingsystem.Cart.ItemList;

public class Admin extends Accounts {
    Admin() throws IOException{
        FileReader admUserName = new FileReader("AdminName.txt");
        FileReader admUserPassword = new FileReader("AdminPassword.txt");
        this.UserNameArray=admUserName.openFile();
        this.UserPassArray=admUserPassword.openFile();
        }
    
    Admin(String UserName, String Password) throws IOException{
        FileReader admUserName = new FileReader("AdminName.txt");
        FileReader admUserPassword = new FileReader("AdminPassword.txt");
        this.UserNameArray=admUserName.openFile();
        this.UserPassArray=admUserPassword.openFile();
        this.UserName=UserName;
        this.Password=Password;
        }
    @Override
    public boolean logIn(String UserName, String Password) {
        for(int i=0;i<UserNameArray.length;i++){ 
            if(UserNameArray[i].equals(UserName)==true && UserPassArray[i].equals(Password)==true){
                j=true;
            }
        }
        return j;
        }
    
    
    public  boolean addAdminCheck(String name){
        boolean var=false;
        int m=check(name);
        if(m==1){
            var=true;
        }
        return var;
    }
    boolean check=true;
    public boolean addAdmin(String name,String pass) throws IOException{
        
        int m=check(name);
        if(m==1){
            System.out.println("UserName Exists");
            System.out.println("Try Another One");
            System.out.println("\n");
            check=false;                              
            }
        else{
            FileWriter username = new FileWriter("Adminname.txt");
            FileWriter password = new FileWriter("Adminpassword.txt");
            username.writeToFile(name);
            password.writeToFile(pass);
            }
        return check;
        }
    
    private int check(String name){
        for(int i=0;i<UserNameArray.length;i++){
            if(UserNameArray[i].equals(name)){
                l=1;                        
                }                    
        }
        return l;
    }  

    public void adminData(){
        System.out.println("List of Admins");
        showAdminData();
     }
    
    public void showAdminData(){
         int i;
         System.out.println("Admin Names " + "\t" +"Admin Passwords" );
         for(i=0;i<UserNameArray.length;i++)
         {             
             System.out.println(UserNameArray[i] + "\t\t" +  UserPassArray[i]);
         }
    }
    
    FileReader file3 = new FileReader("ClientUsername.txt");
    String[] userName = file3.openFile();
    FileReader file4 = new FileReader("ClientPassword.txt");
    String[] userPassword = file4.openFile();
    
    public void userData(){
        System.out.println("List of Users");
        showUserData();
     }
     public void showUserData(){
         int i;
         System.out.println("Users Names " + "\t" +"Users Passwords" );
         for(i=0;i<userName.length;i++)
         {
             System.out.println(userName[i] + "\t\t" + userPassword[i]);
         }         
      
         }
     public void deleteUser(String name,String password) throws IOException{
        boolean deleteUserCheck = search(name,password);
        if(deleteUserCheck==true){
            String []tempUserName=new String[userName.length-1];
            String []tempPassword=new String[userPassword.length-1];;
            int i; int j;
            for(i=0,j=0;i<tempUserName.length;i++){
                if(name.equals(userName[i])==true && password.equals(userPassword[i])==true)
                    j++;

                tempUserName[i]=userName[j];
                tempPassword[i]=userPassword[j];
                j++;
                }
//            for(i=0;i<tempUserName.length;i++){
//                System.out.println(tempUserName[i]+"\t"+tempPassword[i]);        
//                }
            FileWriter username = new FileWriter("ClientUsername.txt",false);
            FileWriter userpassword = new FileWriter("ClientPassword.txt",false);
            username.writeToFile(tempUserName);
            userpassword.writeToFile(tempPassword); 
        }
        else{
            System.out.println("UserName Password Mismatch !");
            }
        }
     
    public boolean deleteUserCheck(String name,String password) throws IOException{
        boolean deleteUserCheck = false;
              deleteUserCheck = search(name,password);
        if(deleteUserCheck==true){
            deleteUserCheck=true;
        }
        return deleteUserCheck;
            
        }
     
    boolean p=false;  
    private boolean search(String name, String password){    
    for(int i=0;i<userName.length;i++){
        if(userName[i].equals(name)==true && userPassword[i].equals(password)==true)
            p=true;
    }
        return p;
    }
    public void addItem(String name,String Cost,String Quantity) throws IOException{
        
        int m=checkItem(name);
        if(m==1){
            System.out.println("Item Already Exists");
            System.out.println("\n");                              
        }
        else{
            
            FileWriter ItemName = new FileWriter("ItemList.txt");
            FileWriter ItemCost = new FileWriter("ItemCost.txt");
            FileWriter stock = new FileWriter("Stock.txt");
            ItemName.writeToFile(name);
            ItemCost.writeToFile(Cost);
            stock.writeToFile(Quantity);
        }
 
    }
    
    public boolean addItemCheck(String name) throws IOException{
        boolean check=false;
        int m=checkItem(name);
        if(m==1){
            check=true;
        }
        return check;
        
    }
    
     private int checkItem(String name) throws IOException{
         FileReader ListOfItems = new FileReader("ItemList.txt");
         ItemList=ListOfItems.readFile();
              for(int i=0;i<ItemList.size();i++){
            if(ItemList.get(i).equals(name)==true){
                l=1;                        
                }                    
        }
        return l;
    }
     public void deleteItem(String Item) throws IOException{
         int m=checkItem(Item);
         if(m==1){
         FileReader ListOfItems = new FileReader("ItemList.txt");
         ItemList=ListOfItems.readFile();
         deleteCost(ItemList.indexOf(Item));
         deleteStock(ItemList.indexOf(Item));
         ItemList.remove(Item);
         FileWriter ItemsList = new FileWriter("ItemList.txt",false);
         ItemsList.writeToFile(ItemList);
         }
         else{
             System.out.println("Item not Found!\n");
         }
     }
     private void deleteCost(int i) throws IOException{
         FileReader CostOfItems = new FileReader("ItemCost.txt");
         ArrayList<String> CostList=CostOfItems.readFile();
         CostList.remove(i);
         FileWriter ItemsList = new FileWriter("ItemCost.txt",false);
         ItemsList.writeToFile(CostList);
     }
     private void deleteStock(int i) throws IOException{
         FileReader stockOfItems = new FileReader("Stock.txt");
         ArrayList<String> stockList=stockOfItems.readFile();
         stockList.remove(i);
         FileWriter ItemsList = new FileWriter("Stock.txt",false);
         ItemsList.writeToFile(stockList);
     }
     public void showShoppingHistory() throws IOException{
     ArrayList <String> history =new ArrayList<String>();
     FileReader shoppingHistory=new FileReader("ShoppingHistory.txt");
     history=shoppingHistory.readFile();
        if(history.size()==0){
           System.out.println("No History To Show\n");
        }
        else{
            System.out.println("\t*******");
            System.out.println("\tHISTORY");
            System.out.println("\t*******");
            for(String print:history){
            System.out.println(print);
            }
        }
     }
     public void clearHistory() throws IOException{
     ArrayList <String> clearHistory=new ArrayList<String>();
     FileWriter clearAll=new FileWriter("ShoppingHistory.txt",false);
     FileReader clear=new FileReader("ShoppingHistory.txt");
     clearHistory=clear.readFile();
     clearHistory.clear();
     clearAll.writeToFile(clearHistory);
         System.out.println("History Cleared!\n");
     }
    //         ArrayList <String> stockList=new ArrayList<>();
//         FileReader StockRead=new FileReader("Stock.txt");
//         FileWriter StockWrite=new FileWriter("Stock.txt",false);   
}
            
 
