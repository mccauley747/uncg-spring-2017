package bofforegister;

import events.BoffoEvent;
import gui.BoffoRegisterGUI;
import javafx.stage.Stage;
import events.BoffoListenerInterface;
import events.Routing;
import events.BoffoMessenger;
import transaction.Transaction;

/**
 *
 * @author joshuabr7 & joshlmilligan
 */
public class BoffoController implements BoffoListenerInterface{

    // protected LoginModule login = null;

    // protected AdministrationModule administration = null;

    // protected UserModule user = null;

    // protected InventoryModule inventory = null;

    protected Transaction transaction = null;

    // protected Printer printer = null;

    protected BoffoRegisterGUI gui = null;

    BoffoController(Stage primaryStage) {
        this.gui = new BoffoRegisterGUI(primaryStage);
    }

    /**
     * Changes the active module, changes the GUI panel, and calls out to
     * registerPanelListener change the current listener.
     * @param event
     */
    private void changePanel(BoffoEvent event) {

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

    @Override
    public void messageRecieved(BoffoEvent event) {
        switch (event.getMessage().getCode()) {
            case Routing.ADD_TRANSACTION:
                System.out.println("Boffo Controller responding to Transaction Panel Event...");
              //  this.transactionPanel();
                break;
            case Routing.EXIT_PANEL:
                System.out.println("Boffo Controller responding to Main Menu Panel Event...");
              //  this.mainPanel();
                break;
            default:
                System.out.println("Ignoring message because it is irrelevant to the Controller. "
                                        + "\nPassing along the following event message "
                                        + event.getMessage().getCode());


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
}