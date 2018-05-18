package laskuri.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccessObject {
	protected static Connection getConnection() {
		Connection connection = null;

		String dbUsername = "a1704474";

		//String dbPassword = "*******";
		String url = "jdbc:mysql://localhost:3306/a1704474";
		// tietokannan nimi opiskelijanumero

		try {
			// Ladataan ajuri
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Avataan yhteys connection-nimiseen muuttujaan
			connection = DriverManager.getConnection(url, dbUsername, dbPassword);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	/**
	 * Sulkee Statementin ja Connectionin
	 * 
	 * @param SQL
	 *            -statement
	 * @param Tietokantayhteys
	 */
	protected static void close(Statement stmt, Connection connection) {
		// close(null, stmt, connection);
	}

	/**
	 * Sulkee ResultSetin, Statementin ja Connectionin
	 */

	protected static void close(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if (rs != null) { // Suljetaan rs (palautettu tulostaulu), mikali
								// olemassa
				rs.close();
			}
			if (stmt != null) { // Suljetaan stmt (SQL-statement), mikali
								// olemassa
				stmt.close();
			}
			if (conn != null) { // Suljetaan conn (yhteys), mikali olemassa
				conn.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
