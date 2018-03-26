package food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import food.connection.DbConnection;
import food.dao.OrderDAO;
import food.models.OrderBean;

public class OrderDAOImpl implements OrderDAO{
	static Connection con=DbConnection.getConnection();

	@Override
	public Integer addOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		Integer add=0;
		try{
			PreparedStatement stmt=con.prepareStatement("insert into make_order(user_id,food_id,quantity,price,order_date,created_by,created_date,modified_by,modified_date,active) values(?,?,?,?,now(),?,now(),?,now(),1)");
			stmt.setInt(1, orderBean.getUserBean().getUserId());
			stmt.setInt(2, orderBean.getFoodBean().getFoodId());
			stmt.setInt(3, orderBean.getQuantity());
			stmt.setInt(4, orderBean.getPrice());
			stmt.setInt(5, orderBean.getCreatedBy());
			stmt.setInt(6, orderBean.getModifiedBy());
			add=stmt.executeUpdate();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return add;
	}
	

}
