package virtualshoppingsystem;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static virtualshoppingsystem.Cart.myCart;

/**
 * FXML Controller class
 *
 * @author Salman
 */
public class FXMLController implements Initializable {

    @FXML
    RadioButton rdoUser;
    @FXML
    RadioButton rdoAdmin;
    @FXML
    ToggleGroup group = new ToggleGroup();
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField user1;
    @FXML
    private PasswordField pass1;
    @FXML
    private TextField user2;
    @FXML
    private PasswordField pass2;
    @FXML
    private TextField user3;
    @FXML
    private PasswordField pass3;
    @FXML
    Label wrongUser;
    @FXML
    Label userExists;
    @FXML
    Label adminAdded;
    @FXML
    Label deleteUser;
    @FXML
    TextArea txtArea;
    @FXML
    TextArea txtArea1;
    @FXML
    TextArea historyTxtArea;
    @FXML
    ListView<String> itemsListView;
    @FXML
    ListView<String> costListView;
    @FXML
    ListView<String> stockListView;
    @FXML
    ListView<String> cartListView;
    @FXML
    TextArea billTxtArea;
    @FXML
    private Button closeButton;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemCost;
    @FXML
    private TextField itemStock;
    @FXML
    TextField itemName1;
    @FXML
    TextField itemStock1;
    @FXML
    Label addItemLabel;
    @FXML
    Label stockStatus;
    
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void startAction(ActionEvent event) throws IOException {
        sceneChanger("LoginOrSignup.fxml",event);
        
    }

    public void backToHomeAction(ActionEvent event) throws IOException {
        startAction(event);
    }
    
    public void backToAdminOptions(ActionEvent event) throws IOException{
        sceneChanger("AdminOptions.fxml",event);
    }

    public void login(ActionEvent event) throws IOException {
        sceneChanger("Login.fxml",event);
    }

    public void signUp(ActionEvent event) throws IOException {
        sceneChanger("SignUp.fxml",event);
    }

    public void submitLogInAction(ActionEvent event) throws IOException, AWTException {

        if (rdoUser.isSelected() == true) {
            if(user.getText().isEmpty() == true || pass.getText().isEmpty() == true){
                wrongUser.setText("UserName or Password is Empty");
            }
            else if (User.userLoginCheck(user.getText(), pass.getText()) == false) {
                wrongUser.setText("Wrong UserName or Password !");
            } 
            else {
                sceneChanger("UserOptions.fxml",event);

                User.userLogin(user.getText(), pass.getText());

            }
        } 
        else if (VSS.adminLoginCheck(user.getText(), pass.getText()) == false) {
            wrongUser.setText("Wrong AdminName or Password !");
        } 
        else {
             sceneChanger("AdminOptions.fxml",event);

            VSS.adminLogin(user.getText(), pass.getText());
        }

    }

    public void submitSignUpAction(ActionEvent event) throws IOException, AWTException {

        if (user1.getText().isEmpty() == true || pass1.getText().isEmpty() == true) {
            userExists.setText("UserName or Password is Empty");
            userExists.setTextFill(Color.web("#e81515"));
        } else if (User.userSignupCheck(user1.getText(), pass1.getText()) == false) {
            userExists.setText("User Exists");
            userExists.setTextFill(Color.web("#e81515"));
        } else {
            userExists.setTextFill(Color.web("#0fcd0b"));
            userExists.setText("SignUp Successful");
            User.userSignup(user1.getText(), pass1.getText());
        }
    }

    public void logInSignUpAction(ActionEvent event) throws IOException, AWTException {
        if (user1.getText().isEmpty() == true || pass1.getText().isEmpty() == true) {
            userExists.setText("UserName or Password is Empty");
        } else {
            sceneChanger("UserOptions.fxml",event);
      
            User.userLogin(user1.getText(), pass1.getText());
        }
    }

    public void usersDataAction(ActionEvent event) throws IOException {
        sceneChanger("UsersData.fxml", event);
    }
    
    public void addAnotherAdminAdmOpt(ActionEvent event) throws IOException{
        sceneChanger("AddAnotherAdmin.fxml",event);
        
    }
    
    public void stockOpt(ActionEvent event) throws IOException{
        sceneChanger("StockOptions.fxml",event);
    }
    
    public void AdminsDataOption(ActionEvent event) throws IOException{
        sceneChanger("AdminsData.fxml",event);
    }
    
    public void viewAdminData(ActionEvent event) throws IOException{
        txtArea1.clear();

        FileReader file2 = new FileReader("AdminName.txt");
        String[] admName = file2.openFile();
        FileReader file1 = new FileReader("AdminPassword.txt");
        String[] admPass = file1.openFile();

        txtArea1.appendText("Admin Names " + "\t  " + "Admin Passwords" + "\n");

        for (int i = 0; i < admName.length; i++) {
            txtArea1.appendText(admName[i] + "\t\t" + admPass[i] + "\n");
        }
    }

    public void viewUserData(ActionEvent event) throws IOException {
        txtArea.clear();

        FileReader file3 = new FileReader("ClientUsername.txt");
        String[] userName = file3.openFile();
        FileReader file4 = new FileReader("ClientPassword.txt");
        String[] userPass = file4.openFile();

        txtArea.appendText("Users Names " + "\t  " + "Users Passwords" + "\n");

        for (int i = 0; i < userName.length; i++) {
            txtArea.appendText(userName[i] + "\t\t" + userPass[i] + "\n");
        }
    }
    
    public void addAdmin(ActionEvent event) throws IOException{
        if (user2.getText().isEmpty() == true || pass2.getText().isEmpty() == true){
            adminAdded.setText("UserName or Password is Empty");
        }
        else{
                Admin adminoption = new Admin(user2.getText(), pass2.getText());
                adminoption.addAdmin(user2.getText(), pass2.getText());
                adminAdded.setText("Admin Added !");
        }
    }
    
    public void deleteUserAdmOpt(ActionEvent event) throws IOException{
        sceneChanger("DeleteUser.fxml",event);
    }
    
    public void deleteUser(ActionEvent event) throws IOException{
        Admin adminoption = new Admin();
        if (user3.getText().isEmpty() == true || pass3.getText().isEmpty() == true){
            deleteUser.setText("UserName or Password is Blank");
        }
        
        else if (adminoption.deleteUserCheck(user3.getText(), pass3.getText())==false){
            deleteUser.setText("UserName Password Mismatch");
        }
         else{
            adminoption.deleteUser(user3.getText(), pass3.getText());
            deleteUser.setTextFill(Color.web("#0fcd0b"));
            deleteUser.setText("User Deleted !");
                }
    }
    
    public void showItemsListAdmOpt(ActionEvent event) throws IOException{
        showItemsListUserOpt(event);
        
    }
    
    public void deleteItem(ActionEvent event) throws IOException{
        Admin adminoption = new Admin();
        if(itemsListView.getSelectionModel().isEmpty()){
            System.out.println("No Item Selected");
        }
        adminoption.deleteItem(itemsListView.getSelectionModel().getSelectedItem());
        showItemsListUserOpt(event);
    }
     
    public void otherOptionsAction(ActionEvent event) throws IOException{
        sceneChanger("OtherOptions.fxml",event);
    }
    
    public void addItemAction(ActionEvent event) throws IOException {
        Admin adminoption = new Admin();
        if (itemName.getText().isEmpty() == true || itemCost.getText().isEmpty() == true || itemStock.getText().isEmpty() == true) {
            addItemLabel.setText("Input(s) is/are Empty");
        } 
        else if (adminoption.addItemCheck(itemName.getText()) == true) {
            addItemLabel.setText("Item Already Exists");
        } 
        else {
            adminoption.addItem(itemName.getText(), itemCost.getText(), itemStock.getText());
            addItemLabel.setTextFill(Color.web("#0fcd0b"));
            addItemLabel.setText("Item Added");
            
        }
    }
    
    public void increaseStock(ActionEvent event) throws IOException{
        if(itemName1.getText().isEmpty()==true || itemStock1.getText().isEmpty()==true){
            stockStatus.setText("Field(s) is empty");
        }
        else if(Cart.ItemList.contains(itemName1.getText())==false){
            stockStatus.setText("No such item found");
        }
        else{
        Stock stck = new Stock();
        int quantity = Integer.parseInt(itemStock1.getText());
        stck.increaseStock(itemName1.getText(), quantity);
        stockStatus.setTextFill(Color.web("#0fcd0b"));
        stockStatus.setText("Stock Increased");
        }
    }
    
    public void decreaseStock(ActionEvent event) throws IOException{
        if(itemName1.getText().isEmpty()==true || itemStock1.getText().isEmpty()==true){
            stockStatus.setText("Field(s) is empty");
        }
        else if(Cart.ItemList.contains(itemName1.getText())==false){
            stockStatus.setText("No such item found");
        }
        else{
        Stock stck = new Stock();
        int quantity = Integer.parseInt(itemStock1.getText());
        stck.reduceStock(itemName1.getText(), quantity);
        stockStatus.setText("Stock Decreased");
        }
    }
    
    public void UserHistoryAdmOpt(ActionEvent event) throws IOException{
        sceneChanger("UserShoppingHistory.fxml",event);
    }
    
    public void viewUserHistory(ActionEvent event) throws IOException{
        historyTxtArea.clear();

        ArrayList <String> history =new ArrayList<String>();
        FileReader shoppingHistory=new FileReader("ShoppingHistory.txt");
        history=shoppingHistory.readFile();
        if(history.size()==0){
            historyTxtArea.setText("No History Found");
        }
        else{
        historyTxtArea.appendText("=================User History==================\n");
        
        for(String print:history){
            historyTxtArea.appendText(print + "\n");
            }
        }

    } 
    
    public void clearHistory(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Do you really want to delete User History?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Admin adminopt = new Admin();
            adminopt.clearHistory();

            viewUserHistory(event);
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
    
    public void logOutAdmOpt(ActionEvent event) throws IOException{
        backToHomeAction(event);
    }
    
    public void showItemsListUserOpt(ActionEvent event) throws IOException {
        ArrayList<String> ItemsList = new ArrayList<String>();
        FileReader ListOfItems = new FileReader("ItemList.txt");
        ItemsList = ListOfItems.readFile();

        itemsListView.getItems().clear();
        itemsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        itemsListView.getItems().addAll(ItemsList);

        ArrayList<String> CostList = new ArrayList<String>();
        FileReader CostOfItems = new FileReader("ItemCost.txt");
        CostList = CostOfItems.readFile();

        costListView.getItems().clear();
        costListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        costListView.getItems().addAll(CostList);

        ArrayList<String> stockList = new ArrayList<String>();
        FileReader stockRead = new FileReader("Stock.txt");
        stockList = stockRead.readFile();
        
        stockListView.getItems().clear();
        stockListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        stockListView.getItems().addAll(stockList);
        
        // Bind the ListView scroll property
        Node n1 = itemsListView.lookup(".scroll-bar");
        if (n1 instanceof ScrollBar) {
            final ScrollBar bar1 = (ScrollBar) n1;
            Node n2 = costListView.lookup(".scroll-bar");
            if (n2 instanceof ScrollBar) {
                final ScrollBar bar2 = (ScrollBar) n2;
                bar1.valueProperty().bindBidirectional(bar2.valueProperty());
                Node n3 = stockListView.lookup(".scroll-bar");
                if(n3 instanceof ScrollBar){
                    final ScrollBar bar3 = (ScrollBar) n3;
                    bar2.valueProperty().bindBidirectional(bar3.valueProperty());
                }
            }
        }
    }

    public void addToCartUsrOpt(ActionEvent event) throws IOException {
        Cart clientoption1 = new Cart();
         if(itemsListView.getSelectionModel().isEmpty()){
             Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item from Item List");

            alert.showAndWait();
            
        }
         else if(clientoption1.addToCartCheck(itemsListView.getSelectionModel().getSelectedItem())==false){
             Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("The selected item is out of stock");

            alert.showAndWait();
         }
         else{
        clientoption1.addToCart(itemsListView.getSelectionModel().getSelectedItem());
        showItemsListUserOpt(event);

        cartListView.getItems().clear();
        cartListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cartListView.getItems().addAll(myCart);

        billTxtArea.clear();
        billTxtArea.appendText(Billing.TotaltoString());
         }
    }

    public void deleteFromCartUserOpt(ActionEvent event) throws IOException {
        if(cartListView.getSelectionModel().isEmpty()==true){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item from cart");
            
            alert.showAndWait();
            
        }
        else
        {
        Cart clientoption = new Cart();
        clientoption.deleteFromCart(cartListView.getSelectionModel().getSelectedItem());

        showItemsListUserOpt(event);

        billTxtArea.clear();
        billTxtArea.appendText(Billing.TotaltoString());

        cartListView.getItems().clear();
        cartListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cartListView.getItems().addAll(myCart);
        }
    }

    public void clearCartUserOpt(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Do you really want to clear cart ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           Cart clientoption = new Cart();
        clientoption.clearCart();
        //showItemsListUserOpt(event);

        billTxtArea.clear();
        billTxtArea.appendText(Billing.TotaltoString());

        cartListView.getItems().clear();
        cartListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cartListView.getItems().addAll(myCart);
        
        showItemsListUserOpt(event);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
    }

    public void logOutUserOpt(ActionEvent event) throws IOException {
        Cart history = new Cart();
        history.ShoppingHistory();
        Alert alert = new Alert(AlertType.INFORMATION);
        
        if(Billing.Total==0){
            
            backToHomeAction(event);
            alert.setHeaderText(null);
            alert.setContentText("Thanks for Coming");
            alert.showAndWait();
        }
        else{
            alert.setHeaderText("Thank You for Shopping !");
            alert.setGraphic(new ImageView(this.getClass().getResource("checkout.png").toString()));
            TextArea invoice = new TextArea();
            invoice.setEditable(false);
            //invoice.setWrapText(true);
            invoice.appendText("Your Cart: \n");
            for(String print:myCart)
                invoice.appendText(print+"\n");
            invoice.appendText("Your Bill: \n");
            invoice.appendText(Billing.TotaltoString());

            invoice.setMaxWidth(Double.MAX_VALUE);
            invoice.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(invoice, Priority.ALWAYS);
            GridPane.setHgrow(invoice, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(invoice, 0, 1);

            // Set expandable Exception into the dialog pane.
            //alert.getDialogPane().setExpandableContent(expContent);
            alert.getDialogPane().setContent(expContent);
            alert.showAndWait();
            //Clear Cart So next time User can buy with refreshed cart
            Cart clientoption = new Cart();
            clientoption.clearCart();
            backToHomeAction(event);
           
        }
    }
    
    public void closeButtonAction(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void sceneChanger(String fxmlname, ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource(fxmlname));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
