package database;

public class BoffoDatbaseAPI {

    private final String dbUrl = "jdbc://localhost:3306/SCHEMANAME";
    private ConnectionManager dbConnection;
    private ConnectionManager dbStatement;

    public BoffoDatbaseAPI() {
        dbConnection = new ConnectionManager();
    }

    public void dbLogin(String uName, String uPass) {
        dbConnection.connectToDB(dbUrl, "admin", "password");
    }

    public void dbLogout() {
        dbConnection.closeConnection();
    }

    public void createDbEntry() {

    }

    public void insertDbEntry(String lastname, String firstname, String email) {
//        try {
//            String sql = "insert into employees " + " (last_name, first_name, email)"
//                    + " values (lastname, firstname, email)";
//
//            dbStatement.executeUpdate(sql);
//
//            System.out.println("Insert complete.");
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
    }

    public void updateDbEntry() {

    }

    public void removeDbEntry() {

    }

    public void deleteDbEntry() {

    }
}
