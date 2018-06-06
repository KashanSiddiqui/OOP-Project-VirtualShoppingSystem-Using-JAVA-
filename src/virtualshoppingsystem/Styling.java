package virtualshoppingsystem;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public final class Styling {
  
    public static void clearConsole() throws AWTException {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
            System.out.println("");
        }       
        catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    static public void enterKey(){
    System.out.println("Press \"ENTER\" to Continue...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    }
    public static void runCode() throws AWTException{
    Robot pressbot=new Robot();
    pressbot.keyPress(117);
    pressbot.keyRelease(117);
    }
    
    
    
}
