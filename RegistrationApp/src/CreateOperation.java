import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateOperation {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = JDBCUtil.getConnection();

			String sql = "INSERT INTO demo.Registration(ID,Name,Email,Date_of_Birth) " + "values(?,?,?,?)";

			// Create statement
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, 4);
			pstmt.setString(2, "Rohan");
			pstmt.setString(3, "rohan@gmail.com");
			pstmt.setDate(4, Date.valueOf("2003-06-14"));
			

			int rows = pstmt.executeUpdate();

			// Process the result
			if (rows == 0) {
				System.out.println("Insert not successful " + rows);
			} else {
				System.out.println("Insert is successful " + rows);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// Close Connection.
			try {
				JDBCUtil.closeConnection(pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}


