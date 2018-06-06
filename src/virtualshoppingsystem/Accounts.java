package virtualshoppingsystem;

import java.io.IOException;

public class Accounts {
    String UserName;
    String Password;
    boolean j=false;
    
    // Null Constructor(Dont Remove)
    Accounts(){}
    
    public Accounts(String UserName, String Password) throws IOException{       
        this.UserName=UserName;
        this.Password=Password;
        
    }
 
    String[] UserNameArray;
    String[] UserPassArray;
    FileReader ClientUser = new FileReader("ClientUsername.txt");
    FileReader ClientPass = new FileReader("ClientPassword.txt");
    
    public boolean logIn(String UserName, String Password) throws IOException{
            
            UserNameArray = ClientUser.openFile();
            UserPassArray = ClientPass.openFile();
    
            for(int i=0;i<UserNameArray.length;i++){ 
                if(UserNameArray[i].equals(UserName)==true && UserPassArray[i].equals(Password)==true)
                {
                    j=true;
                } 
                }
            return j;
    }

    boolean check=true;
    public boolean signUp(String a,String b) throws IOException{
        UserNameArray = ClientUser.openFile();
        UserPassArray = ClientPass.openFile();
        int m=check(a);
        if(m==1){
//            System.out.println("UserName Exists");
//            System.out.println("Try Another One");
            check=false;
            }
        else{
            FileWriter username = new FileWriter("ClientUsername.txt");
            FileWriter password = new FileWriter("Clientpassword.txt");
            username.writeToFile(a);
            password.writeToFile(b);
            System.out.println("Welcome To Virtual Shopping Store :) "+ a);
            
            }
           
            
            return check;
        }
    
    int l=0;
    private int check(String a){
        for(int i=0;i<UserNameArray.length;i++){
            if(UserNameArray[i].equals(a)){
                l=1;
            }

        }
        return l;
    }   
}