package database;
import java.sql.*;
import java.lang.Integer;
import java.util.Date;
public class Sql {
    private final String DB_URL = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6502557";
    private final String USER = "sql6502557";
    private final String PASS = "iqCY1wSClz";
    public Connection conn;
    public Statement stmt;

    public Sql() {
        try {
            conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int newUser(String username, String password) {
        int passhash = password.hashCode();
        try {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + ";");
            while (rs.next()) {
                int rowCount = Integer.parseInt(rs.getString("COUNT(*)"));
                if (rowCount != 0) {
                    return -1;
                }
            }
            rs = stmt.executeQuery("SELECT MAX(Serial) FROM Login_Details;");
            int serial = 1;
            while (rs.next()) {
                serial += rs.getInt("Max(Serial)");
            }
            stmt.executeUpdate("INSERT INTO Login_Details (Serial, UserName, Password) " + "VALUES ( " + serial + ", '" + username + "', " + passhash + " );");
            return serial;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int auth(String username, String password){
        int passhash = password.hashCode();
        try{
            ResultSet rs = stmt.executeQuery("SELECT COUNT(SERIAL) FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + ";");
            while(rs.next()) {
                int rowCount = Integer.parseInt(rs.getString("COUNT(SERIAL)"));
                if (rowCount != 0) {
                    rs = stmt.executeQuery("SELECT Serial FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + ";");
                    while (rs.next()) {
                        return rs.getInt("Serial");
                    }
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int newSimulation(int trafficFlow, int accidents, float efficiency, float avg, int userSerial){
        Date date = new Date();
        try{
            ResultSet rs = stmt.executeQuery("SELECT MAX(EntrySerial) FROM sim_record;");
            int entrySerial = 1;
            while (rs.next()) {
                entrySerial += rs.getInt("Max(EntrySerial)");
            }
            return stmt.executeUpdate("INSERT INTO sim_record VALUES (" + entrySerial +","+ trafficFlow + "," + accidents + "," + efficiency + "," + avg + "," + date.toString() +","+ userSerial + ");");
        } catch(SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public int LoadSimulation(int userSerial){
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM sim_record WHERE UserSerial =" + userSerial + ";");
            return 1;
        } catch(SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
}