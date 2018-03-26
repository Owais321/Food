package food.models;

import java.sql.Date;
import java.sql.Time;

public class FoodBean extends GeneralBean {
	private Integer foodId;
	private String name;
	private String address;
	private Integer price;
	private Integer quantity;
	private String description;
	private String path;
	private Date date;
	private Time time;
	private UserBean userBean;
	private UserTypeBean userTypeBean;
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time2) {
		this.time = time2;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public UserTypeBean getUserTypeBean() {
		return userTypeBean;
	}
	public void setUserTypeBean(UserTypeBean userTypeBean) {
		this.userTypeBean = userTypeBean;
	}

}
