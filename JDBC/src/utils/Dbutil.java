package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbutil {
	private static final String url = "jdbc:mysql://localhost:3306/corp";
	private static final String user = "root";
	private static final String password = "112233";
	private static final String className = "com.mysql.jdbc.Driver";
	
	public Connection getCon() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public Statement getStat(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statement;
	}
	
	public PreparedStatement getPreStat(Connection connection, String sqlString) {
		PreparedStatement preStat = null;
		
		try {
			preStat = connection.prepareStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preStat;
	}
	
	public CallableStatement getCallStat(Connection connection, String sqlString) {
		CallableStatement callStat = null;
		
		try {
			callStat = connection.prepareCall(sqlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return callStat;
	}
	
	public void close(Connection connection, Statement statement) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
