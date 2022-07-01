package database;
import java.sql.*;
import java.lang.Integer;
import java.util.Date;
public class Sql {
    private final String DB_URL = "jdbc:mysql://localhost/trafficsim";
    private final String USER = "root";
    private final String PASS = "oopproject";
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
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + " ;");
            while (rs.next()) {
                int rowCount = Integer.parseInt(rs.getString("COUNT(*)"));
                if (rowCount != 0) {
                    return 2;
                }
            }
            stmt.executeUpdate("INSERT INTO Login_Details (Serial, UserName, Password) " + "VALUES ( " + 000 + ", '" + username + "', " + passhash + " );");
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
    public int authetication(String username, String password){
        int passhash = password.hashCode();
        try{
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + ");");
            while(rs.next()) {
                int rowCount = Integer.parseInt(rs.getString("COUNT(*)"));
                if (rowCount != 0) {
                    rs = stmt.executeQuery("SELECT Serial FROM Login_Details WHERE UserName = '" + username + "' AND Password = " + passhash + ");");
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
    public int newSimulation(int entrySerial,int trafficFlow, int accidents, float efficiency, float avg, int userSerial){
        Date date = new Date();
        try{
            ResultSet rs = stmt.executeQuery("SELECT Serial FROM Login_Details");
            while(rs.next())
            return stmt.executeUpdate("INSERT INTO sim_record VALUES (" + entrySerial +","+ trafficFlow + "," + accidents + "," + efficiency + "," + avg + "," + date.toString() +","+ userSerial + ");");
        } catch(SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
    public static void main(String[] args){
        Sql db = new Sql();
        System.out.println(db.newUser("Arz","bbg"));
    }
}