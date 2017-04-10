package bofforegister;

/*
 * Last Updated: 04/09/2017
 *
 * This class is the controller for the BoffoRegister.
 * The controller 'controls' the BoffoRegisters actions.
 * Very little logic should be implemented within.  The
 * other modules and classes have their logic and this
 * controller class is meant to utilize the methods
 * and pass along events from other modules in order to
 * maintain proper functioning of the BoffoRegister.
 *
 * @author Joshua Brown & Josh Milligan
 */

import events.BoffoEvent;
import gui.BoffoRegisterGUI;
import javafx.stage.Stage;
import events.BoffoListenerInterface;
import java.util.ArrayList;
import java.util.List;
import printer.Printer;
import transaction.Transaction;

public class BoffoController implements BoffoListenerInterface, BoffoBaseModule{
    protected Transaction transaction = null;
    protected Printer printer = null;
    protected BoffoRegisterGUI gui = null;
    protected BoffoBaseModule activeModule = null;
    final protected List boffoListener = new ArrayList();
    //include a currentUser at all times to keep up with.

    BoffoController(Stage _primaryStage) {
        this.gui = new BoffoRegisterGUI(_primaryStage);
    }

    /**
     * Changes the active module, changes the GUI panel, and calls out to
     * registerPanelListener change the current listener.
     * @param _event
     */

     @Override
    public void messageReceived(BoffoEvent _event) {

        /**
        * Also using cascading if else statements to catch events
        * within a given range.
        * Using literal ints until the event system is nailed down.
        */
        if(_event.getMessage().getCode() == 0) {
            // check user login data
        }
        else if (_event.getMessage().getCode()== 1) {
            printReceipt();
        }
        else if(_event.getMessage().getCode() <= 10) {
            //
            this.changePanel(_event);
        }
        else if(_event.getMessage().getCode() <= 20) {
            //
            this.preformAction(_event);
        }
        // If the messageString does not fall within range, ignore it.
    }

    @Override
    public void addBRegisterListener(BoffoListenerInterface _listener) {
        boffoListener.add(_listener);
    }

    @Override
    public void removeBRegisterListener(BoffoListenerInterface _listener) {
        boffoListener.remove(_listener);
    }

    @Override
    public void fireEvent(BoffoEvent _event) {
        Object[] temp_list = this.boffoListener.toArray();
        for (Object temp_list1 : temp_list) {
            BoffoListenerInterface temp_obj = (BoffoListenerInterface) temp_list1;
            temp_obj.messageReceived(_event);
        }
    }

    private void changePanel(BoffoEvent _event) {
        //Think I want to change the parameter to changePanel(BoffoBaseModule module)
        switch(_event.getMessage().getCode()) {

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
                // If its not a panel change _event, but in range, ignore it.
                break;
        }
    }

    /**
     * Respond to events that require instructions to be sent.
     * @param _event
     */
    private void preformAction(BoffoEvent _event) {

        switch(_event.getMessage().getCode()) {
            default:
                // If its not a action _event, but in range, ignore it.
                break;
        }
    }

    private void printReceipt() {
        // printer.print(transactionModule);
    }

    private void registerListener(BoffoBaseModule _newModule) {
        this.activeModule =  _newModule;
        //addBRegisterListener the nextModule to the activeModule (add to GUI).
    }
}