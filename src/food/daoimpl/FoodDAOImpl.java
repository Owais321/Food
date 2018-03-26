package food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import food.connection.DbConnection;
import food.dao.FoodDAO;
import food.models.FoodBean;
import food.models.UserBean;
import food.models.UserTypeBean;

public class FoodDAOImpl implements FoodDAO{
	static Connection con=DbConnection.getConnection();

	@Override
	public Integer addFood(FoodBean foodBean) {
		// TODO Auto-generated method stub
		Integer add=0;
		try{
			PreparedStatement stmt=con.prepareStatement("insert into food(user_id,user_type_id,name,description,path,price,quantity,address,date,created_by,modified_by,created_date,modified_date,active,time) values"
					+ "(?,?,?,?,?,?,?,?,now(),?,?,now(),now(),1,?)");
			stmt.setInt(1, foodBean.getUserBean().getUserId());
			stmt.setInt(2, foodBean.getUserTypeBean().getUserTypeId());
			stmt.setString(3, foodBean.getName());
			stmt.setString(4, foodBean.getDescription());
			stmt.setString(5, foodBean.getPath());
			stmt.setInt(6, foodBean.getPrice());
			stmt.setInt(7, foodBean.getQuantity());
			stmt.setString(8, foodBean.getAddress());
			stmt.setInt(9, foodBean.getCreatedBy());
			stmt.setInt(10, foodBean.getModifiedBy());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			stmt.setTimestamp(11, timestamp);
			add=stmt.executeUpdate();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return add;
	}

	@Override
	public List<FoodBean> getAllFoods() {
		// TODO Auto-generated method stub
		ArrayList<FoodBean> list=new ArrayList<>();
	    try {
	            PreparedStatement stmt = con.prepareStatement("select * from food where active=1");
	            ResultSet rst = stmt.executeQuery();
	            while (rst.next()) {
	            	FoodBean foodBean=new FoodBean();
	            	UserBean userBean=new UserBean();
	            	UserTypeBean userTypeBean=new UserTypeBean();
	            	foodBean.setFoodId(rst.getInt("food_id"));
	            	foodBean.setName(rst.getString("name"));
	            	foodBean.setAddress(rst.getString("address"));
	            	foodBean.setDescription(rst.getString("description"));
	            	foodBean.setPath(rst.getString("path"));
	            	foodBean.setPrice(rst.getInt("price"));
	            	foodBean.setQuantity(rst.getInt("quantity"));
	            	foodBean.setDate(rst.getDate("date"));
	            	foodBean.setCreatedBy(rst.getInt("created_by"));
	            	foodBean.setModifiedBy(rst.getInt("modified_by"));
	            	foodBean.setCreatedDate(rst.getDate("created_date"));
	            	foodBean.setModifiedDate(rst.getDate("modified_date"));
	            	foodBean.setTime(rst.getTime("time"));
	            	userBean.setUserId(rst.getInt("user_id"));
	            	userTypeBean.setUserTypeId(rst.getInt("user_type_id"));
	            	foodBean.setUserBean(userBean);
	            	foodBean.setUserTypeBean(userTypeBean);
	                list.add(foodBean);
	            }

	      } catch (Exception ex) {
	            ex.printStackTrace();
	      }
	      return list;
	}

	@Override
	public FoodBean getFoodById(Integer foodId) {
		// TODO Auto-generated method stub
		FoodBean foodBean=new FoodBean();
    	UserBean userBean=new UserBean();
    	UserTypeBean userTypeBean=new UserTypeBean();
	    try {
	            PreparedStatement stmt = con.prepareStatement("select * from food where food_id=? and active=1");
	            stmt.setInt(1, foodId);
	            ResultSet rst = stmt.executeQuery();
	            while (rst.next()) {
	            	foodBean.setFoodId(rst.getInt("food_id"));
	            	foodBean.setName(rst.getString("name"));
	            	foodBean.setAddress(rst.getString("address"));
	            	foodBean.setDescription(rst.getString("description"));
	            	foodBean.setPath(rst.getString("path"));
	            	foodBean.setPrice(rst.getInt("price"));
	            	foodBean.setQuantity(rst.getInt("quantity"));
	            	foodBean.setDate(rst.getDate("date"));
	            	foodBean.setCreatedBy(rst.getInt("created_by"));
	            	foodBean.setModifiedBy(rst.getInt("modified_by"));
	            	foodBean.setCreatedDate(rst.getDate("created_date"));
	            	foodBean.setModifiedDate(rst.getDate("modified_date"));
	            	userBean.setUserId(rst.getInt("user_id"));
	            	userTypeBean.setUserTypeId(rst.getInt("user_type_id"));
	            	foodBean.setUserBean(userBean);
	            	foodBean.setUserTypeBean(userTypeBean);
	            }

	      } catch (Exception ex) {
	            ex.printStackTrace();
	      }
	      return foodBean;
	}

	@Override
	public List<FoodBean> getFoodBeanByUserId(Integer userId) {
		// TODO Auto-generated method stub
		ArrayList<FoodBean> list=new ArrayList<>();
	    try {
	            PreparedStatement stmt = con.prepareStatement("select * from food where user_id=? and active=1");
	            stmt.setInt(1, userId);
	            ResultSet rst = stmt.executeQuery();
	            while (rst.next()) {
	            	FoodBean foodBean=new FoodBean();
	            	UserBean userBean=new UserBean();
	            	UserTypeBean userTypeBean=new UserTypeBean();
	            	foodBean.setFoodId(rst.getInt("food_id"));
	            	foodBean.setName(rst.getString("name"));
	            	foodBean.setAddress(rst.getString("address"));
	            	foodBean.setDescription(rst.getString("description"));
	            	foodBean.setPath(rst.getString("path"));
	            	foodBean.setPrice(rst.getInt("price"));
	            	foodBean.setQuantity(rst.getInt("quantity"));
	            	foodBean.setDate(rst.getDate("date"));
	            	foodBean.setCreatedBy(rst.getInt("created_by"));
	            	foodBean.setModifiedBy(rst.getInt("modified_by"));
	            	foodBean.setCreatedDate(rst.getDate("created_date"));
	            	foodBean.setModifiedDate(rst.getDate("modified_date"));
	            	userBean.setUserId(rst.getInt("user_id"));
	            	userTypeBean.setUserTypeId(rst.getInt("user_type_id"));
	            	foodBean.setUserBean(userBean);
	            	foodBean.setUserTypeBean(userTypeBean);
	                list.add(foodBean);
	            }

	      } catch (Exception ex) {
	            ex.printStackTrace();
	      }
	      return list;
		
	}

	@Override
	public Integer updateFood(Integer foodId) {
		// TODO Auto-generated method stub
		Integer update=0;
		try{
			PreparedStatement stmt=con.prepareStatement("update food set active=0 where food_id=?");
			stmt.setInt(1, foodId);
			update=stmt.executeUpdate();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return update;
	}

}
