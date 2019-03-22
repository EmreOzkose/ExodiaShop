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
        if(myConn == null){
            //baglı degil diye give an error
            connect(Commd, Commd);
        }else{
            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery(Commd);

            // 4. Process the result set
            while (myRs.next()){
            System.out.println(myRs.getString("Name") + ", " + myRs.getString("Surname"));
            }
        }
    }
    public boolean Check(String UserName,String Password) throws SQLException{
        if(myConn == null){
            //baglı degil diye give an error
            //connect(Commd, Commd);
        }else{
            // 2. Create a statement
            myStmt = myConn.createStatement();
            System.out.println("select Password from customer where name ='"+UserName+"'");

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select Password from customer where name ='"+UserName+"'");
            //bozukkk
            if(Password.equals(myRs.getString("Password"))){
                return true;
            }
        }
        return false;
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
        //deneme.Command("select * from customer");
        deneme.Check("Mehmet Taha", "password123");
        deneme.Close();
    }
    
}
