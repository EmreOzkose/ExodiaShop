
import java.sql.*;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mehmet Taha USTA
 */
public class DbLayer {
    
    public static void main(String[] args) throws SQLException {

            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;

            String user = "root";
            String pass = "aezakmi1997";

            try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exodiadb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", user, pass);

                // 2. Create a statement
                myStmt = myConn.createStatement();

                // 3. Execute SQL query
                myRs = myStmt.executeQuery("select * from customer");

                // 4. Process the result set
                while (myRs.next()) {
                    System.out.println(myRs.getString("Name") + ", " + myRs.getString("Surname"));
                }

            } catch (Exception exc) {
                exc.printStackTrace();
            } finally {
                if (myRs != null) {
                    myRs.close();
                }

                if (myStmt != null) {
                    myStmt.close();
                }

                if (myConn != null) {
                    myConn.close();
                }
            }
        }
    
}
