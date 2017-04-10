package database;

import java.util.UUID;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoffoDbObject {

    protected static String table = " ";
    private String uuid;
    protected boolean active;
    protected BoffoDbObject temp;


    public BoffoDbObject(String _uuid){
        this.uuid = _uuid;
    }

    public BoffoDbObject(){
        uuid = UUID.randomUUID().toString();
    }

    public BoffoDbObject load(String field, String value){
        System.out.println("select "+ field +" from " + getTableName() + ";");

        return temp;
    }

    public BoffoDbObject save(){
        return temp;
    }

    public BoffoDbObject add(String field, String value){
        return temp;
    }

    public BoffoDbObject update(String field, String value){
        return temp;
    }

    public boolean delete(String field, String value){
        return active;
    }

    public static BoffoDbObject create(){

        return new BoffoDbObject(UUID.randomUUID().toString());
    }

    public BoffoDbObject insert(){
        System.out.println("insert into " + getTableName() + " values(" + ");");

        return temp;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /*
    * Determine the table to act on from the class that calls the method.
    */
    private String getTableName(){
        String tracedName;

        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();
        String callerClassName = elements[2].getClassName();
        tracedName = callerClassName;


        try {
            String tableName = "tableName";
            Class reflectionClass = Class.forName(tracedName);
            Field fieldName = reflectionClass.getDeclaredField(tableName);

            //Make sure the field is accessible.
            fieldName.setAccessible(true);

            Object obj = reflectionClass.newInstance();
            String tableString = (String)fieldName.get(obj);

            return tableString;
        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
        } catch (IllegalArgumentException | InstantiationException ex) {
            Logger.getLogger(BoffoDbObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BoffoDbObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}