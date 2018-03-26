package food.models;

public class UserBean extends GeneralBean{
	private Integer userId;
	private String userName;
	private String password;
	private String address;
	private String contact;
	private UserTypeBean userTypeBean;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public UserTypeBean getUserTypeBean() {
		return userTypeBean;
	}
	public void setUserTypeBean(UserTypeBean userTypeBean) {
		this.userTypeBean = userTypeBean;
	}

}
