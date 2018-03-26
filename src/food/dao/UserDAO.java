package food.dao;

import java.util.List;

import food.models.UserBean;

public interface UserDAO {
	public Integer addUser(UserBean userBean);
	public Integer deleteUser(Integer userId);
	public Integer updateUser(UserBean userBean);
	public List<UserBean> getAllUsers();
	public List<UserBean> getAllHouseWifes();
	public UserBean getUserById(Integer userId);
	public boolean checkUser(String name, String password);
	public Integer getUserIdByName(String userName); 
}
