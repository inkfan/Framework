
import java.sql.*;

public class DBUtil {
    private static Connection conn;

    private static String driver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF8";

    private static String user = "root";

    private  static String psw = "";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url,user,psw);
    }
}
