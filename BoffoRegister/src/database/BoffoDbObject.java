package database;

import java.util.UUID;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class BoffoDbObject {
    
    protected static String tableName = "";
    private String uuid;
    protected boolean isActive;
    protected BoffoDbObject temp;
    protected String tracedName;
    
    public BoffoDbObject(String _uuid){
        this.uuid = _uuid;
    }
    
    public BoffoDbObject(){
        
    }
    
    public BoffoDbObject load(String field, String value){
       
          System.out.println("The class that called the load method: " + 
                                    traceModule());
          System.out.println("The String inside tableName: " + getTableName());
          
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
        try {
            String sql = "delete from " + getTableName() + " where " + field + "='" + value + "'";
            int rowsAffected = Query.statement.executeUpdate(sql);
            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Delete complete.");
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }  
        return isActive;
    }
    
    public static BoffoDbObject create(){     
        return new BoffoDbObject(UUID.randomUUID().toString());
    }
    
    public BoffoDbObject insert(String field, String value){
//        System.out.println("The class that called the load method: "
//                + traceModule());
//        System.out.println("The String inside tableName: " + getTableName());
//        
//    PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?)");  
//    stmt.setInt(1,101);//1 specifies the first parameter in the query  
//    stmt.setString(2,"Ratan");  
=======

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

    
    private String traceModule(){


    /*
    * Determine the table to act on from the class that calls the method.
    */
    private String getTableName(){
        String tracedName;


        Throwable t = new Throwable();
        StackTraceElement[] elements = t.getStackTrace();
        String callerClassName = elements[2].getClassName();
        tracedName = callerClassName;

        return callerClassName;
    }
    
    private String getTableName(){

        try {
            String tableName = "tableName";
            Class reflectionClass = Class.forName(tracedName);
            Field fieldName = reflectionClass.getDeclaredField(tableName);
            
            //Make sure the field is accessible.
            fieldName.setAccessible(true);
            
            Object obj = reflectionClass.newInstance();
            String tableString = (String)fieldName.get(obj);
            
            //Save the name of the table;
            return tableString;
        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BoffoDbObject.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
}

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

