import java.sql.*;

/**
 *
 * @author Mehmet Taha USTA
 */
public class DbLayer {
    private Connection myConn = null;
    private Statement myStmt = null;
    private ResultSet myRs = null;
    
    public void connect(String user,String pass) throws SQLException{
        try {
        // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exodiadb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", user, pass);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void Command(String Commd) throws SQLException{
        // 2. Create a statement
        myStmt = myConn.createStatement();

        // 3. Execute SQL query
        myRs = myStmt.executeQuery(Commd);

        // 4. Process the result set
        while (myRs.next()){
        System.out.println(myRs.getString("Name") + ", " + myRs.getString("Surname"));
        }       
    }
    public void Close() throws SQLException{
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
    
    public static void main(String[] args) throws SQLException {
    DbLayer deneme = new DbLayer();
    deneme.connect("root","aezakmi1997");
    /*bura düzenlenmesi gerekiyor ic kodlar dahil*/
    deneme.Command("select * from customer");
    deneme.Close();
    }
    
}
