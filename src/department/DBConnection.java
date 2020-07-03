package department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DBConnection {

	public static  Connection DBConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DepartmentStore;integratedSecurity=true");
		return con;
		
	}
}
