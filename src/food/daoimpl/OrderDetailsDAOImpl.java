package food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import food.connection.DbConnection;
import food.dao.OrderDetailsDAO;
import food.models.OrderDetailsBean;

public class OrderDetailsDAOImpl implements OrderDetailsDAO{
	static Connection con=DbConnection.getConnection();

	@Override
	public Integer addOrderDetails(OrderDetailsBean orderDetailsBean) {
		// TODO Auto-generated method stub
		Integer add=0;
		try{
			PreparedStatement stmt=con.prepareStatement("insert into order_details(order_id,food_id,quantity,price,created_by,created_date,modified_by,modified_date,active)"
					+ "values(?,?,?,?,?,now(),?,now(),1)");
			stmt.setInt(1, orderDetailsBean.getOrderBean().getOrderId());
			stmt.setInt(2, orderDetailsBean.getFoodBean().getFoodId());
			stmt.setInt(3, orderDetailsBean.getQuantity());
			stmt.setInt(4, orderDetailsBean.getPrice());
			stmt.setInt(5, orderDetailsBean.getCreatedBy());
			stmt.setInt(6, orderDetailsBean.getModifiedBy());
			add=stmt.executeUpdate();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return add;
	}

}
