package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class Query {

    protected static Statement statement;

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
}
