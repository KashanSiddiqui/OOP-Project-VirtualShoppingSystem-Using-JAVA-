package virtualshoppingsystem;

import java.io.IOException;
import java.util.ArrayList;

public class Billing {
    
    static int Total=0;
    public static ArrayList <String> CostList=new ArrayList<String>();
    FileReader CostOfItems = new FileReader("ItemCost.txt");
    
    void showCostList() throws IOException{
        CostList=CostOfItems.readFile();
    }
   
    void addCost(int index) throws IOException{
        showCostList();
        String amount=CostList.get(index);
        int cost=Integer.parseInt(amount);
        Total=Total + cost;
    }
    
    void deleteCost(int index) throws IOException{
        showCostList();
        String amount=CostList.get(index);
        int cost=Integer.parseInt(amount);
        Total=Total - cost;
    }
    
    void clearCost(){        
        Total=0;
    }
    
    void showBill(){
        System.out.println("Your Bill:");
        System.out.println(Total);
    }
   
    static String TotaltoString(){
        String bill=""+Total;
        return bill;
    }
    

}

