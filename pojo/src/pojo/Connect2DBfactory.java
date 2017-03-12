package pojo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect2DBfactory {
	public static Connection getDBconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/blogsystem";
			String user = "root";
			String password = "netjava";
			connection = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;

	}

}
