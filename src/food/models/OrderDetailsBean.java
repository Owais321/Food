package food.models;

public class OrderDetailsBean extends GeneralBean{
	
	private Integer orderDetailsId;
	private Integer quantity;
	private Integer price;
	private OrderBean orderBean;
	private FoodBean foodBean;
	
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
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
	public OrderBean getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}
	public FoodBean getFoodBean() {
		return foodBean;
	}
	public void setFoodBean(FoodBean foodBean) {
		this.foodBean = foodBean;
	}
	
	
	

}
