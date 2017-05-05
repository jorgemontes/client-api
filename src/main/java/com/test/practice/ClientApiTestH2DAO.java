package com.test.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.DeleteDbFiles;

public class ClientApiTestH2DAO {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/client-api";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	private static final String QUERY_CREATE = "CREATE TABLE CLIENT(ID varchar(40) primary key, NAME varchar(40),AGE int,ADDRESS varchar(100))";
	private static final String QUERY_SELECT_UNIQUE = "SELECT ID, NAME, AGE, ADDRESS FROM CLIENT WHERE ID = ?";
	private static final String QUERY_SELECT_ALL = "SELECT ID, NAME, AGE, ADDRESS FROM CLIENT";

	public ClientApiTestH2DAO() throws SQLException {
		DeleteDbFiles.execute("~", "test", true);
		createTable();
		System.out.println("********************************************");
		System.out.println("*******DATA ON DATABASE                 ****");
		System.out.println("********************************************");
		selectAllData();
		System.out.println();
	}

	public static boolean clientExist(String id) throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement selectPreparedStatement = null;
		boolean result = false;
		try {
			connection.setAutoCommit(false);
			selectPreparedStatement = connection.prepareStatement(QUERY_SELECT_UNIQUE);
			selectPreparedStatement.setString(1, id);
			ResultSet rs = selectPreparedStatement.executeQuery();
			if (rs.next()) {
				result = true;
			}
			selectPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

	private static void selectAllData() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement selectPreparedStatement = null;
		try {
			connection.setAutoCommit(false);
			selectPreparedStatement = connection.prepareStatement(QUERY_SELECT_ALL);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("ID:" + rs.getString("ID") + " NAME:" + rs.getString("NAME") + " AGE:"
						+ rs.getInt("AGE") + " ADDRESS:" + rs.getString("ADDRESS"));
			}
			selectPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	private static void createTable() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;
		try {
			connection.setAutoCommit(false);
			createPreparedStatement = connection.prepareStatement(QUERY_CREATE);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}
