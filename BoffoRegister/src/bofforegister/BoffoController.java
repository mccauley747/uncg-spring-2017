package bofforegister;

import events.BoffoEvent;
import gui.BoffoRegisterGUI;
import javafx.stage.Stage;
import events.BoffoListenerInterface;
import events.Routing;
import events.BoffoMessenger;
import java.util.ArrayList;
import printer.Printer;
import transaction.Transaction;

/**
 *
 * @author joshuabr7 & joshlmilligan
 */
public class BoffoController implements BoffoListenerInterface{
    protected Transaction transaction = null;

    //protected Administration administration = null;

    //protected User user = null;

    protected Printer printer = null;
    protected BoffoRegisterGUI gui = null;
    protected BoffoBaseModule activemodule = null;

    BoffoController(Stage primaryStage) {
        this.gui = new BoffoRegisterGUI(primaryStage);
    }

    /**
     * Changes the active module, changes the GUI panel, and calls out to
     * registerPanelListener change the current listener.
     * @param event
     */
    private void changePanel(BoffoEvent event) {
        //Think I want to change the parameter to changePanel(BoffoBaseModule module)
        switch(event.getMessage().getCode()) {

            case 2:
                // Change to the main GUI panel.

                break;

            case 3:
                // Change to the login GUI panel.

                /*if(login == null) {
                    login = new LoginModule();
                }
                this.gui.loadLoginPanel();*/


                break;

            case 4:
                // Change to the admin GUI panel.

                /*if(admin == null) {
                    admin = new AdministrationModule();
                }
                this.gui.loadAdminPanel();*/

                break;

            case 5:
                // Change to the user GUI panel.

                /*if(user == null) {
                    user = new UserModule();
                }
                this.gui.loadUserPanel();*/

                break;

            case 6:
                // Change to the Inventory GUI panel.

                /*if(inventory == null) {
                    inventory = new InventoryModule();
                }
                this.gui.loadInventoryPanel();*/

                break;

            case 7:
                // Change to the Transaction GUI panel.

                /*if(transaction == null) {
                    transaction = new TransactionModule();
                }
                this.gui.loadTransactionPanel();*/

                break;

            default:
                // If its not a panel change event, but in range, ignore it.
                break;
        }
    }

    /**
     * Respond to events that require instructions to be sent.
     * @param event
     */
    private void preformAction(BoffoEvent event) {

        switch(event.getMessage().getCode()) {
            default:
                // If its not a action event, but in range, ignore it.
                break;
        }
    }

    private void printReceipt() {
        // printer.print(transactionModule);
    }

    private void registerListener(BoffoBaseModule newModule) {
        activemodule =  newModule;
        //addBRegisterListener the nextModule to the activemodule (add to GUI).
    }

    @Override
    public void messageReceived(BoffoEvent event) {

        /**
        * Also using cascading if else statements to catch events
        * within a given range.
        * Using literal ints until the event system is nailed down.
        */
        if(event.getMessage().getCode() == 0) {
            // check user login data
        }
        else if (event.getMessage().getCode()== 1) {
            printReceipt();
        }
        else if(event.getMessage().getCode() <= 10) {
            //
            this.changePanel(event);
        }
        else if(event.getMessage().getCode() <= 20) {
            //
            this.preformAction(event);
        }
        // If the messageString does not fall within range, ignore it.
    }
}