package test.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	static DataSource ds;
	
	static {
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch (NamingException ne){
			System.out.println(ne.getMessage());	
		}
	}
	
	public static Connection getConn() throws SQLException{
		Connection con = ds.getConnection();
		return con;
		
	}

}
