package food.dao;

import java.util.List;

import food.models.FoodBean;

public interface FoodDAO {
	public Integer addFood(FoodBean foodBean);
	public Integer updateFood(Integer foodId);
	public List<FoodBean> getAllFoods();
	public FoodBean getFoodById(Integer foodId);
	public List<FoodBean> getFoodBeanByUserId(Integer userId);
}
