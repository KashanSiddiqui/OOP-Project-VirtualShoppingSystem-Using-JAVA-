package virtualshoppingsystem;

import java.io.IOException;
import java.util.ArrayList;
import static virtualshoppingsystem.Billing.Total;

public class Cart {

    int w=0;
    public static ArrayList <String> myCart=new ArrayList<String>();
    public static ArrayList <String> ItemList=new ArrayList<String>();
    FileReader ListOfItems = new FileReader("ItemList.txt");
    Billing UserBill=new Billing();
    Cart() throws IOException{
    ItemList=ListOfItems.readFile();
    }

    void showItemList() throws IOException{
        ItemList=ListOfItems.readFile();
        printItemList();
    }
    boolean addToCartCheck(String item) throws IOException{
        ItemList=ListOfItems.readFile();
        Stock list=new Stock();
        Boolean stock = true;
        int e=Integer.parseInt(list.stockList.get(ItemList.indexOf(item)));
        if(e==0){
            stock = false;
        }
        return stock;
                          
    }
    
    void addToCart(String item) throws IOException{
        ItemList=ListOfItems.readFile();
        Stock list=new Stock();
        
        if(ItemList.contains(item)==false){
            System.out.println("Sorry Item Not Found");
            System.out.println("\n");
        }
        
        
       else if(ItemList.contains(item)==true){
           int e=Integer.parseInt(list.stockList.get(ItemList.indexOf(item)));
           if(e>0){
           myCart.add(item);
            printArrayList();
            int index=ItemList.indexOf(item);
            UserBill.addCost(index);
            Stock red=new Stock();
            red.removeFromStock(index);
            UserBill.showBill();
            System.out.println("\n");
           }
           else if(e==0){
            System.out.println("Out Of Stock\n");
           } 
           
       }
       
    }
    

    
    void deleteFromCart(String item) throws IOException{        
        if(myCart.size()==0){
            System.out.println("Your Cart Is Empty \nYou Cant Remove Anything\n");
        }
        else if(myCart.contains(item)==true){
        myCart.remove(item);
        printArrayList();
        int index=ItemList.indexOf(item);
        UserBill.deleteCost(index);
        Stock add=new Stock();
        add.addToStock(index);
        UserBill.showBill();
        System.out.println("\n");
        }
        else{
            System.out.println("Item Not In Your Cart\n");
            printArrayList();
        }
    }

    
    
    void clearCart() throws IOException {
        Stock stock=new Stock();
        FileWriter writeStock=new FileWriter("Stock.txt",false);
        for(int loop=0;loop<myCart.size();loop++){
        int stk=Integer.parseInt(stock.stockList.get(ItemList.indexOf(myCart.get(loop))));
        stk=stk+1;
        stock.stockList.set(ItemList.indexOf(myCart.get(loop)), Integer.toString(stk));
        writeStock.writeToFile(stock.stockList);
        }
        
        myCart.clear();
        printArrayList();
        System.out.println("Cart Cleared !");
        UserBill.clearCost();
        UserBill.showBill();
        System.out.println("\n");
    }
    
    
    
    void printArrayList(){
        System.out.println("Your Cart:");
        for(String print:myCart){
            System.out.println(print);    
            }
    }    
    
     static void printItemList() throws IOException{
        System.out.println("Store Items: \t" + "Cost\t\t"+"Stock" );
        System.out.println("===========\t====\t\t=====");
        Billing b=new Billing();
        b.showCostList();
        Stock c=new Stock();
        
           for(int d=0;d<ItemList.size();d++){
            System.out.println(ItemList.get(d)+"\t\t"+b.CostList.get(d)+"\t\t"+c.stockList.get(d));
    
            }
   
    }
      public void ShoppingHistory() throws IOException{
            
            FileWriter history = new FileWriter("ShoppingHistory.txt");
            history.writeToFile("Items Purchased:");
            if(Billing.Total==0){
                history.writeToFile("-");
            }
            history.writeToFile(myCart);
            history.writeToFile("Total Bill:");
            history.writeToFile(Integer.toString(Total));
            history.writeToFile("\n");
          
    }

}