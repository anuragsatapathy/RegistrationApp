
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String name = "root";
		String password = "123456789";
		return DriverManager.getConnection(url, name, password);
	}
	
	public static void closeConnection(PreparedStatement pstmt, Connection connection) throws SQLException {
		pstmt.close();
		connection.close();
	}
}


