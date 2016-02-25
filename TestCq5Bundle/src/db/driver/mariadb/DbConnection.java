package db.driver.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

	private static final String DEFAULT_DRIVER = "org.mariadb.jdbc.Driver";

	public static Connection getConnection(String url, String user, String password) throws Exception {
		Class.forName(DEFAULT_DRIVER);
		return DriverManager.getConnection(url, user, password);
	}

	public static void closeDb(Connection con) {
		if (con != null) {
			try {
				con.close();
				con = null;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void testConnection() {
		String url = "";
		String username = "";
		String password = "";
		final String sql = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbConnection.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				System.out.println("rst : "+ rst.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeStatement(pstmt);
			DbConnection.closeDb(con);
		}
	}
}
