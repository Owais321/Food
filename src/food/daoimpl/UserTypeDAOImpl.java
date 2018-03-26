package food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import food.connection.DbConnection;
import food.dao.UserTypeDAO;

public class UserTypeDAOImpl implements UserTypeDAO{
	static Connection con=DbConnection.getConnection();

	@Override
	public Integer getUserTypeIdByName(String name) {
		// TODO Auto-generated method stub
		Integer id=0;
		try{
			PreparedStatement stmt=con.prepareStatement("select user_type_id from user_type where name=? and active=1");
			stmt.setString(1, name);
			ResultSet rst=stmt.executeQuery();
			while(rst.next()){
				id=rst.getInt("user_type_id");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return id;
	}

}
