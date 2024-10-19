import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOperation {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			connection = JDBCUtil.getConnection();

			// String sql = "Update persernalinfo1 set city='Chennai' where id=5";
			String sql = "Update Registration set name=? where id=?";

			// Create statement
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, "Anurag");
			pstmt.setInt(2, 3);

			// non-select

			int rows = pstmt.executeUpdate();

			// Process the result
			if (rows == 0) {
				System.out.println("Update not successful " + rows);
			} else {
				System.out.println("Update is successful " + rows);
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
