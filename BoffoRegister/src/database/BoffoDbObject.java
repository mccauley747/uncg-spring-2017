package database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoffoDbObject {

    protected static String table = " ";
    private String uuid;
    protected boolean active;
    protected BoffoDbObject temp;

    public BoffoDbObject(String _uuid) {
        this.uuid = _uuid;
    }

    public BoffoDbObject() {
        uuid = UUID.randomUUID().toString();
    }

    public BoffoDbObject load(String field, String value) {
        System.out.println("select " + field + " from " + getTableName() + ";");

        return temp;
    }

    public BoffoDbObject save() {
        return temp;
    }

    public boolean update(String field, String value) {
        return true;
    }
    
    /**
     * A function that delete an id from a table.
     *@param id
     *@return true if the item is deleted and false if it fails the deletion.
     */
    public static boolean delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.dbConnection;
            preparedStatement = connection.prepareStatement("DELETE FROM " + getTableName()
                    + " WHERE id=?");
            preparedStatement.setInt(1, id);
            boolean b = preparedStatement.execute();
            if (b == true) {
                System.out.println("1 record deleted...");
                return b;
            }     
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            System.exit(1);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                System.exit(1);
            }
        }
        return false;
    }

    public boolean insert() {
        System.out.println("insert into " + getTableName() + " values(" + ");");

        return true;
    }

    public static BoffoDbObject create() {

        return new BoffoDbObject(UUID.randomUUID().toString());
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

    /**
     * Determine the table to act on from the class that calls the method.
     */
    public static String getTableName() {
        //Trace the directory that called the method.
        String tracedName;

        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();
        //get the last element(bottom of the stack), the first method that invoked the sequence
        String callerClassName = elements[2].getClassName();
        tracedName = callerClassName;

        //Use the Reflection class to access the class field value.
        try {
            String tableName = "tableName";
            Class reflectionClass = Class.forName(tracedName);
            Field fieldName = reflectionClass.getDeclaredField(tableName);

            //Make sure the field is accessible.
            fieldName.setAccessible(true);

            Object obj = reflectionClass.newInstance();
            String tableString = (String) fieldName.get(obj);

            return tableString;
        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BoffoDbObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
