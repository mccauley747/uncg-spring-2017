/*
 *We extended BoffoDbObject becasue the implements command was not working.
 */
package administration;

import database.BoffoDbObject;
/*
 * @author jonathanholley jessicadenney
 */

public class administration extends BoffoDbObject {
//Create variables required for administration class.
    protected administration admin;
    protected String storeName;
    protected String receiptMessage;
    protected double storeHours;
    protected int phoneNumber;
    protected double taxRate;

//Sets variables to null values.
    public administration() {

        this.admin = null;
        this.storeName = "";
        this.receiptMessage = "";
        this.storeHours = 0.0;
        this.phoneNumber = 0;
        this.taxRate = 0.0;
    }

//Sets variable values to themselves.
    public administration(administration admin, String storeName, String receiptMessage, double storeHours, int phoneNumber, float taxRate) {

        this.admin = admin;
        this.storeName = storeName;
        this.receiptMessage = receiptMessage;
        this.storeHours = storeHours;
        this.phoneNumber = phoneNumber;
        this.taxRate = taxRate;
    }

//Placeholder to pull admin file from database or to pull form a table.
    public administration getAdministration() {
        return this.admin;
    }
//Command to set store name.
    public void setStoreName(String s) {
        this.admin.storeName = s;
    }
//Command to set receipt message.
    public void setReceiptMessage(String r) {
        this.admin.receiptMessage = r;
    }
//Command to set store hours.
    public void setStoreHours(double h) {
        this.admin.storeHours = h;
    }
//Command to set phone number.
    public void setPhoneNumber(int p) {
        this.admin.phoneNumber = p;
    }
//Command to set tax rate.
    public void setTaxRate(double t) {
        this.admin.taxRate = t;
    }
//Command to find store name from database/file.
    public administration findByStoreName(String n) {
        return null;
    }
//Command to find receipt message from database/file.
    public administration findByReceiptMessage(String m) {
        return null;
    }
//Command to find store hours from database/file.
    public administration findByStoreHours(String sh) {
        return null;
    }
//Command to find phone number from database/file.
    public administration findByPhoneNumber(int ph) {
        return null;
    }
 //Command to find tax rate from database/file.
    public administration findByTaxRate(double tr) {
        return null;
    }
}