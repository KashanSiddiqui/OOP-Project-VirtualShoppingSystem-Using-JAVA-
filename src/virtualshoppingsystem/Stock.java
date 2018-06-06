package virtualshoppingsystem;

import java.io.IOException;
import java.util.ArrayList;
import static virtualshoppingsystem.Cart.ItemList;

public class Stock {
   public ArrayList <String> stockList=new ArrayList<String>();
    FileReader stockRead = new FileReader("Stock.txt");
    FileWriter stockWrite = new FileWriter("Stock.txt",false);
    Stock() throws IOException{
        stockList=stockRead.readFile();
   }    
    void showStockList() throws IOException{
        stockList=stockRead.readFile();
    }
   void addToStock(int index) throws IOException{
     
   int increase= Integer.parseInt(stockList.get(index));
   increase=increase+1;
   String write= Integer.toString(increase);
   stockList.set(index, write);
   stockWrite.writeToFile(stockList);
   
   }
   void removeFromStock(int index) throws IOException{
      
   int increase= Integer.parseInt(stockList.get(index));
   increase=increase-1;
   String write= Integer.toString(increase);
   stockList.set(index, write);
   stockWrite.writeToFile(stockList);
   
   }
    void increaseStock(String itemName,int num) throws IOException{
        FileReader ListOfItems=new FileReader("ItemList.txt");
        ItemList=ListOfItems.readFile();
        showStockList();  
        if(ItemList.contains(itemName)==true){
     int index=ItemList.indexOf(itemName);
     stockList=stockRead.readFile();
     int stock=Integer.parseInt(stockList.get(index));
     stock=stock+num;
     stockList.set(index, Integer.toString(stock));
     stockWrite.writeToFile(stockList);
         }
         else{
             System.out.println("No such Item Found!");
         }
     }
     void reduceStock(String itemName,int num) throws IOException{
        FileReader ListOfItems=new FileReader("ItemList.txt");
        ItemList=ListOfItems.readFile();
        showStockList();
        boolean itemCheck=ItemList.contains(itemName);
        
        
        if(itemCheck==true){
        int limit=ItemList.indexOf(itemName);
        int stockResult=Integer.parseInt(stockList.get(limit));
        boolean result=compare(stockResult,num);
        if(result==true){
        int index=ItemList.indexOf(itemName);
        stockList=stockRead.readFile();
        int stock=Integer.parseInt(stockList.get(index));
        stock=stock-num;
        stockList.set(index, Integer.toString(stock));
        stockWrite.writeToFile(stockList);}
        else if(result==false){
            System.out.println("Stock is Less Than Your Quantity!\n");
        }
        }
        else if(itemCheck==false){
            System.out.println("Item Not In Stock!\n");
        }
        
        
       
     }
    private boolean compare(int stock,int num){
    boolean exist;
        if(stock>=num){
        exist=true;
        }
        else{
            exist=false;
        }
      return exist;
    }
}
