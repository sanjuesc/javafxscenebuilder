package ehu.isad.controller.db;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class DBKudSQLite {

	Connection conn = null;

	private void conOpen() throws IOException {

		Properties properties = null;
		InputStream in = null;

		try {
			in = this.getClass().getResourceAsStream("/setup.properties");
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

		try {

			//String url = "jdbc:sqlite::resource:eurobisioa.db";
			//Class.forName("org.sqlite.JDBC").getConstructor().newInstance();
			//conn = (Connection) DriverManager.getConnection(url);

			conn = DriverManager.getConnection("jdbc:sqlite:"+ properties.getProperty("dbpath"));
			conn.setCatalog(properties.getProperty("dbname"));
			System.out.println("Database connection established");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}



	private void conClose() {

		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("Database connection terminated");

	}

	private ResultSet query(Statement s, String query) {

		ResultSet rs = null;

		try {
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// singleton patroia
	private static DBKudSQLite instantzia = new DBKudSQLite();

	private DBKudSQLite() {
		try {
			this.conOpen();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static DBKudSQLite getInstantzia() {
		return instantzia;
	}

	public ResultSet execSQL(String query) {
		int count = 0;
		Statement s = null;
		ResultSet rs = null;

		try {
			s = (Statement) conn.createStatement();
			if (query.toLowerCase().indexOf("select") == 0) {
				// select agindu bat
				rs = this.query(s, query);

			} else {
				// update, delete, create agindu bat
				count = s.executeUpdate(query);
				System.out.println(count + " rows affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
}
