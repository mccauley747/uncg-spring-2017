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
import events.Routing;

public final class BoffoRegisterGUI {

    private final Stage BoffoStage;

    private VBox addVBox(String header) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        Text title = new Text(header);
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        vbox.getChildren().add(title);
        return vbox;
    }

    //TODO: Stubbed in method for building the admin scene
    public void /*Scene*/ buildAdminPanel() {/*...*/}

    //TODO: Stubbed in method for loading Admin panel
    public void loadAdminPanel() {/*...*/}

    //TODO: Stubbed in method for building the transaction scene
    public void /*Scene*/ buildInventoryPanel() {/*...*/}

    //TODO: Stubbed in method for loading Inventory panel
    public void loadInventoryPanel() {/*...*/}

    /*
     * TODO: Display ticket items in a TableView or list
     * This method helps build the transaction panel. Creates several buttons
     *    including an exit button to return to main panel
     */
    public Scene buildTransactionPanel() {
        Button btnAddItem1 = new Button("Add item 1");
        Button btnAddItem2 = new Button("Add item 2");
        Button btnExit = new Button("Exit");

        VBox transactionOptions = this.addVBox("Select Operation");
        transactionOptions.setAlignment(Pos.CENTER);
        transactionOptions.getChildren().add(btnAddItem1);
        transactionOptions.getChildren().add(btnAddItem2);
        transactionOptions.getChildren().add(btnExit);

        btnAddItem1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {/*...*/}

        });

        btnAddItem2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {/*...*/}

        });

        //Fire an event upon pressing the Exit button.
        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadMainPanel();
//                BoffoEvent exitEvt = new BoffoEvent(e.getSource(),
//                        Routing.EXIT_PANEL);
            }

        });

        Scene sceneTransaction = new Scene(transactionOptions, 400, 400);
        return sceneTransaction;
    }

    public void loadTransactionPanel() {
        System.out.println("Loading Transaction Panel");
        BoffoStage.setTitle("Transaction");
        Scene transactionScene = buildTransactionPanel();
        BoffoStage.setScene(transactionScene);
        BoffoStage.show();
    }

    //TODO: Stubbed in method to check if entered credentials are valid
    /**
     * @param username The username obtained from the login panel.
     * @param password The password obtained from the login panel.
     * @return Boolean
     */
    private boolean isValidUser(String username, String password) {
        //Compare String objects to those in the database.
        //If credentials exist then return true.
        //If credentials do not exist then prompt user to reenter credentials.
        return true;
    }

    public Scene buildMainScene() {
        Button btnTransaction = new Button("Transaction");
        Button btnInventory = new Button("Inventory");
        Button btnAdministration = new Button("Administration");
        Button btnExit = new Button("Exit");

        VBox vbox = this.addVBox("Select Operation");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(btnTransaction);
        vbox.getChildren().add(btnInventory);
        vbox.getChildren().add(btnAdministration);
        vbox.getChildren().add(btnExit);

        //Fire an event to go to the Transaction panel.
        btnTransaction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadTransactionPanel();
//                BoffoEvent evtTransaction = new BoffoEvent(e.getSource(),
//                        Routing.TRANSACTION_PANEL);
            }

        });

        //Fire an event to go to the Inventory panel.
        btnInventory.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadInventoryPanel();
                //BoffoEvent object declaration for Inventory goes here.
            }

        });

        //Fire an event to go to the Administration panel.
        btnAdministration.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e) {
                loadAdminPanel();
                //BoffoEvent object declaration for Administration goes here.
            }

        });

        //Fire an event to go back to the Main panel.
        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadLoginPanel();
		//BoffoEvent object declaration for Exit goes here.
            }

        });

        // Create the scene and return.
        Scene scene = new Scene(vbox, 325, 275);

        return scene;
    }

    public void loadMainPanel() {
        System.out.println("Loading Main Panel");
        BoffoStage.setTitle("Boffo Register Main Menu");
        Scene sceneMain = this.buildMainScene();

        //Set up the main stage.
        BoffoStage.setScene(sceneMain);
        this.BoffoStage.show();
    }

    //Login screen with username & password text fields, plus a sign-in button.
    public Scene buildLoginScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 800, 600);

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

    public void loadLoginPanel() {
        System.out.println("Loading Login Panel");
        BoffoStage.setTitle("BoffoRegister Login");
        Scene sceneLogin = this.buildLoginScene();
        this.BoffoStage.setScene(sceneLogin);

        //Set up the login stage.
        this.BoffoStage.show();
    }

    public BoffoRegisterGUI(Stage s) {
        this.BoffoStage = s;
        this.loadLoginPanel();
    }
}
