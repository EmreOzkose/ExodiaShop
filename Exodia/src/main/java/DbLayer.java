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
    public void Command(DbLayer DB,String Commd) throws SQLException{
    // 2. Create a statement
    DB.myStmt = DB.myConn.createStatement();

    // 3. Execute SQL query
    DB.myRs = DB.myStmt.executeQuery(Commd);
 
    // 4. Process the result set
    while (DB.myRs.next()){
    System.out.println(DB.myRs.getString("Name") + ", " + DB.myRs.getString("Surname"));
    }       
    }
    
    public static void main(String[] args) throws SQLException {
    DbLayer deneme = new DbLayer();
    deneme.connect("root","aezakmi1997");
    deneme.Command(deneme,"select * from customer");
    
    }
    
}
