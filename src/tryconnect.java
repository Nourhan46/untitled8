import com.sun.jdi.PathSearchingVirtualMachine;

import java.sql.*;
public class tryconnect {
    public static void main() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Books_DB;encrypt=true;trustServerCertificate=true;";
        String user = "nour";
        String password = "010908";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
       // st.executeUpdate("insert  into titles (ISBN,Title,EditionNumber) Values(123456,'mmm',2422)");
        ResultSet rs = st.executeQuery("select * from titles");



    }
}
