package food.models;

import java.sql.Date;

public class OrderBean extends GeneralBean{
	private Integer orderId;
	private Date orderDate;
	private Integer quantity;
	private Integer price;
	private FoodBean foodBean;
	private UserBean userBean;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public FoodBean getFoodBean() {
		return foodBean;
	}
	public void setFoodBean(FoodBean foodBean) {
		this.foodBean = foodBean;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	

}
