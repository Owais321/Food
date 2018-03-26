package food.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con=null;
	public static Connection getConnection(){
		if(con==null){
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","roshan","roshan");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return con;
	}

}
