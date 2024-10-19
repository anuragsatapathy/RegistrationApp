import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadOperation {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = JDBCUtil.getConnection();

			// String sql = "SELECT id,name,city FROM persernalinfo1 WHERE id=?";
			String sql = "SELECT * FROM Registration";

			// Create statement
			pstmt = connection.prepareStatement(sql);

			//pstmt.setInt(1, 6);

			// Process the result
			ResultSet rs = pstmt.executeQuery();
			/*
			 * if(rs.next()) { System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
			 * + rs.getString(3)); }
			 */

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getDate(4));
			}

			rs.close();
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


