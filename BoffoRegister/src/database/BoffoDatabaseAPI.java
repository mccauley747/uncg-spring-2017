package database;

import java.sql.SQLException;

public class BoffoDatabaseAPI {

    private final String dbUrl = "jdbc://localhost:3306/SCHEMANAME";
    private ConnectionManager dbConnection;
    private Query dbQuery;

    public BoffoDatabaseAPI() {
        dbConnection = new ConnectionManager();

        try {
            dbQuery = new Query(dbConnection.getConnection());
        } catch (SQLException ex) {
            System.out.println("dbQueryError :" + ex);
        }
    }

    public boolean dbLogin(String uName, String uPass) {
        if(dbConnection.connectToDB(dbUrl, "admin", "password")){
            return true;
        } else {
            return false;
        }
    }

    public void dbLogout() {
        dbConnection.closeConnection();
    }
}
