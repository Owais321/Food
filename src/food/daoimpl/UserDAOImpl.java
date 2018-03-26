package food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import food.connection.DbConnection;
import food.dao.UserDAO;
import food.models.UserBean;
import food.models.UserTypeBean;

public class UserDAOImpl implements UserDAO{
	static Connection con=DbConnection.getConnection();
	@Override
	public Integer addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		Integer row=0;
		try{
			PreparedStatement stmt=con.prepareStatement("insert into users(name,user_type_id,password,address,contact,created_by,created_date,modified_by,modified_date,active) values (?,?,?,?,?,?,now(),?,now(),?)");
			stmt.setString(1, userBean.getUserName());
			stmt.setInt(2, userBean.getUserTypeBean().getUserTypeId());
			stmt.setString(3, userBean.getPassword());
			stmt.setString(4, userBean.getAddress());
			stmt.setString(5,userBean.getContact());
			stmt.setInt(6, userBean.getCreatedBy());
			stmt.setInt(7, userBean.getModifiedBy());
			stmt.setInt(8, userBean.getActive());
			row=stmt.executeUpdate();	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		Integer row=0;
		try{
			PreparedStatement stmt=con.prepareStatement("delete from users where user_id=?");
			stmt.setInt(1, userId);
			row=stmt.executeUpdate();	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		Integer row=0;
		try{
			PreparedStatement stmt=con.prepareStatement("update users set created_by=?,created_date=now(),modified_by=?,modified_date=now(),active=1 where user_id=?");
			stmt.setInt(1, userBean.getCreatedBy());
			stmt.setInt(2, userBean.getModifiedBy());
			stmt.setInt(3, userBean.getUserId());
			row=stmt.executeUpdate();	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean getUserById(Integer userId) {
		// TODO Auto-generated method stub
		UserBean userBean=new UserBean();
		UserTypeBean userTypeBean=new UserTypeBean();
		try{
			PreparedStatement stmt=con.prepareStatement("select * from users where user_id=? and active =1");
			stmt.setInt(1, userId);
			ResultSet rst=stmt.executeQuery();
			while(rst.next()){
				userTypeBean.setUserTypeId(rst.getInt("user_type_id"));
				userBean.setUserName(rst.getString("name"));
				userBean.setPassword(rst.getString("password"));
				userBean.setAddress(rst.getString("address"));
				userBean.setContact(rst.getString("contact"));
				userBean.setCreatedBy(rst.getInt("created_by"));
				userBean.setCreatedDate(rst.getDate("created_date"));
				userBean.setModifiedBy(rst.getInt("modified_by"));
				userBean.setModifiedDate(rst.getDate("modified_date"));
				userBean.setUserTypeBean(userTypeBean);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return userBean;
	}

	@Override
	public boolean checkUser(String name, String password) {
		// TODO Auto-generated method stub
		boolean found=false;
		try{
			PreparedStatement stmt=con.prepareStatement("select name,password from users where name=? and password=? and active=1");
			stmt.setString(1, name);
			stmt.setString(2, password);
			ResultSet rst=stmt.executeQuery();
			while(rst.next()){
				if(rst.getString("name").equals(name) && rst.getString("password").equals(password)){
					found=true;
					break;
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return found;
	}

	@Override
	public Integer getUserIdByName(String userName) {
		// TODO Auto-generated method stub
		Integer id=0;
		try{
			PreparedStatement statement=con.prepareStatement("select user_id from users where name=? and active=1");
			statement.setString(1, userName);
			ResultSet rst=statement.executeQuery();
			while(rst.next()){
				id=rst.getInt("user_id");
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return id;
		
	}

	@Override
	public List<UserBean> getAllHouseWifes() {
		// TODO Auto-generated method stub
		ArrayList<UserBean> list=new ArrayList<>();
		try{
			PreparedStatement stmt=con.prepareStatement("select * from users where user_type_id=1 and active =0");
			ResultSet rst=stmt.executeQuery();
			while(rst.next()){
				UserBean userBean=new UserBean();
				UserTypeBean userTypeBean=new UserTypeBean();
				userTypeBean.setUserTypeId(rst.getInt("user_type_id"));
				userBean.setUserId(rst.getInt("user_id"));
				userBean.setUserName(rst.getString("name"));
				userBean.setPassword(rst.getString("password"));
				userBean.setAddress(rst.getString("address"));
				userBean.setContact(rst.getString("contact"));
				userBean.setCreatedBy(rst.getInt("created_by"));
				userBean.setCreatedDate(rst.getDate("created_date"));
				userBean.setModifiedBy(rst.getInt("modified_by"));
				userBean.setModifiedDate(rst.getDate("modified_date"));
				userBean.setUserTypeBean(userTypeBean);
				list.add(userBean);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

}
