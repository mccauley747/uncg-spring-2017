package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class Query {

<<<<<<< HEAD
    protected static Statement statement;
=======
    private final Statement statement;
>>>>>>> master

    /*
    * Initialize with the current connection
    */
    public Query(Connection dbConnection) throws SQLException{
        statement = dbConnection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException{
        return statement.executeQuery(query);
    }

    public ResultSetMetaData getMetaData(ResultSet rs) throws SQLException{
        return rs.getMetaData();
    }

    /*
    * Overload that passes only a table name and field to the select from table below.
    */
    public String selectFromTable(String tName, String tField) throws SQLException{
        return this.selectFromTable(tName, tField, null, null, null);
    }

    /*
    * For use by dbAPI class allowing for select statements to be easily executed.
    */
    public String selectFromTable(String tName, String tField, String tFilterField, String operator, String tFilter) throws SQLException{
        System.out.println("Executing: SELECT " + tField + " FROM " + tName + " WHERE " + tFilterField + " " + operator + " '" + tFilter + "'");

        ResultSet rs;
        ResultSetMetaData rsmd;

        if(tFilterField != null || operator != null || tFilter != null){
            rs = this.executeQuery("SELECT " + tField + " FROM " + tName + " WHERE " + tFilterField+ " " + operator + " '" + tFilter + "'");
            rsmd = this.getMetaData(rs);

            while(rs.next()){
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println("");
            }

        } else {
            rs = this.executeQuery("SELECT " + tField + " FROM " + tName);
            rsmd = this.getMetaData(rs);

            while(rs.next()){
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println("");
            }
        }

        return null;
    }

    /*
    * This will print the table name, column names, and all rows in the table.
    */
    public void printTable(String tName) throws SQLException{
        System.out.println("Executing SELECT * FROM " + tName);

        ResultSet rs = statement.executeQuery("SELECT * FROM " + tName);
        ResultSetMetaData rsmd = this.getMetaData(rs);

        System.out.println("Table Name: " + tName + "\n");

        System.out.println("Columns: ");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnTypeName(i) + ": " + rsmd.getColumnName(i) +  ", ");
        }
        System.out.println("\n");

        System.out.println("Values: ");
        while(rs.next()){
            for(int i = 1; i <= rsmd.getColumnCount(); i++){
                System.out.print(rs.getString(i) + ", ");
            }
            System.out.println("");
        }
    }
}
