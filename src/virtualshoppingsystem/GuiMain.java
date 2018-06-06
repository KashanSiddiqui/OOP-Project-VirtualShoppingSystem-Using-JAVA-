package virtualshoppingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Salman
 */
public class GuiMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        
        stage.setTitle("Virtual Shopping System");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("background.css").toExternalForm());
        stage.setScene(scene);
        stage.show();     
        
    }
        
    /**%
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
