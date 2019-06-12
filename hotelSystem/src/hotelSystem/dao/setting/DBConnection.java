package hotelSystem.dao.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class DBConnection {
	private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_demo_hotel?serverTimezone=UTC&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// 加载驱动
	static {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获得连接
	private static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获得Result结果
	public static Result selectResult(String sql, Object... objects) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (objects != null && objects.length > 0) {
				for (int i = 0; i < objects.length; i++) {
					preparedStatement.setObject((i + 1), objects[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			return ResultSupport.toResult(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			free(resultSet, connection, preparedStatement);
		}
		return null;
	}

	// 获得boolean结果
	public static boolean selectBoolean(String sql, Object... objects) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (objects != null && objects.length > 0) {
				for (int i = 0; i < objects.length; i++) {
					preparedStatement.setObject((i + 1), objects[i]);
				}
			}
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			free(null, connection, preparedStatement);
		}
		return false;
	}

	// 释放资源
	public static void free(ResultSet resultSet, Connection connection, PreparedStatement preparedStatement) {
		try {
			if (resultSet != null || connection != null || preparedStatement != null) {
				resultSet.close();
				connection.close();
				preparedStatement.close();
			}
		} catch (Exception e) {
		}
	}

}
