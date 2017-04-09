/**
 * Boffo Register GUI
 * @author Logan Stanfield and Kevin Keomalaythong
 */

package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import events.BoffoEvent;
import events.BoffoMessenger;

public final class BoffoRegisterGUI {

    private final Stage BoffoStage;

    public BoffoRegisterGUI(Stage s) {
        this.BoffoStage = s;
        this.loadLoginPanel();
    }

    //TODO: Stubbed in method for loading Admin panel
    public void loadAdminPanel() {

    }

    //TODO: Stubbed in method for loading Inventory panel
    public void loadInventoryPanel() {
        //switch to inventory scene
        System.out.println("Loading Inventory Panel");
        BoffoStage.setTitle("Inventory");
        Scene InvScene = buildInventoryPanel();
        BoffoStage.setScene(InvScene);
       BoffoStage.show();//make scene visible
    }
    public void loadLoginPanel() {
        System.out.println("Loading Login Panel");
        BoffoStage.setTitle("BoffoRegister Login");
        Scene loginScene = this.buildLoginScene();
        this.BoffoStage.setScene(loginScene);
        //Sets up the primary stage.
        this.BoffoStage.show();
    }
        

    public void loadMainPanel() {
        System.out.println("Loading Main Panel");
        BoffoStage.setTitle("Boffo Register Main Menu");
        Scene mainScene = this.buildMainScene();

        //Set up the primary stage.
        BoffoStage.setScene(mainScene);
        this.BoffoStage.show();
    }

    public void loadTransactionPanel() {
        System.out.println("Loading Transaction Panel");
        BoffoStage.setTitle("Transaction");
        Scene transactionScene = buildTransactionPanel();
        BoffoStage.setScene(transactionScene);
        BoffoStage.show();
    }

    //TODO: Stubbed in method for building the admin scene
    public void /*Scene*/ buildAdminPanel() {

    }

    public void launchTransaction(){
        loadMainPanel();
    }
    public void launchInventory(){
        loadMainPanel();//same as above bc i added inventory 
        //button to buildMainScene() which launch inventory scene if press
    }

    //Login screen with username & password text fields, plus a sign-in button.
    public Scene buildLoginScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 325, 275);

        //Add a title with specified font and text to the scene.
        Text sceneTitle = new Text("Welcome to BoffoRegister");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button signInBtn = new Button("Sign In");
        HBox signInHB = new HBox(10);
        signInHB.setAlignment(Pos.BOTTOM_RIGHT);
        signInHB.getChildren().add(signInBtn);
        grid.add(signInHB, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        //Fire an event upon pressing the Sign In button.
        signInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                loadMainPanel();
//                BoffoEvent evt = new BoffoEvent(e.getSource(),
//                        BoffoMessenger.ADD_TRANSACTION);
            } 
        }); 

        return scene;
    }

    //TODO: Stubbed in method for building the transaction scene
    public Scene buildInventoryPanel() {
        //creat buttons for each methods in inventory class
        Button addI = new Button("Add inventory");
         Button removeI = new Button("Remove inventory");
         Button searchI = new Button("Search inventory");
        Button exitI = new Button("exit");
        //creat box and add buttons to box
        VBox box = this.addVBox("Inventory Options");
        box.getChildren().add(addI);
        box.getChildren().add(removeI);
         box.getChildren().add(searchI); 
        box.getChildren().add(exitI);
         //add box to scene and set size
        Scene InvScene = new Scene(box, 800, 600);
        //if exit, return to main scene
        exitI.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadMainPanel();
            }
        });
        return InvScene;//final result is presented
    }

     public Scene buildMainScene() {
        Button btnTransaction = new Button();
        Button inventoryBtn= new Button("Inventory");//add inventory button
        btnTransaction.setText("Transaction");
        VBox vbox = this.addVBox("Select Operation");
        vbox.getChildren().add(btnTransaction);
        vbox.getChildren().add(inventoryBtn);//add inventory button to main scene
        // Create the scene and return.
        Scene scene = new Scene(vbox, 800, 600);

        btnTransaction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadTransactionPanel();
            }

        });
        //if inventory button press launch inventory scene
        inventoryBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) { 
                loadInventoryPanel();
            }

        });

        return scene;
    }

    /*
     * TODO: Display ticket items in a TableView or list
     * This method helps build the transaction panel. Creates several buttons
     *    including an exit button to return to main panel
     */
    public Scene buildTransactionPanel() {

        Button addItem1Btn = new Button("Add item 1");
        Button addItem2Btn = new Button("Add item 2");
        Button exitBtn = new Button("Exit");

        VBox transactionOptionsVB = this.addVBox("Select Operation");
        transactionOptionsVB.getChildren().add(addItem1Btn);
        transactionOptionsVB.getChildren().add(addItem2Btn);
        transactionOptionsVB.getChildren().add(exitBtn);

        Scene transactionScene = new Scene(transactionOptionsVB, 800, 600);

        addItem1Btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {/*...*/}

        });

        addItem2Btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {/*...*/}

        });

        //Fire an event upon pressing the Exit button.
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //loadMainPanel();
                BoffoEvent exitEvt = new BoffoEvent(e.getSource(),
                        BoffoMessenger.EXIT_PANEL);
            }

        });

        return transactionScene;
    }

    private VBox addVBox(String header) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        Text title = new Text(header);
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        vbox.getChildren().add(title);
        return vbox;
    }

    //TODO: Stubbed in method to check if entered credentials are valid
    private boolean isValidUser() {
        return true;
    }
}
