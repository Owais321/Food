package food.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.dao.FoodDAO;
import food.dao.OrderDAO;
import food.dao.OrderDetailsDAO;
import food.dao.UserDAO;
import food.dao.UserTypeDAO;
import food.daoimpl.FoodDAOImpl;
import food.daoimpl.OrderDAOImpl;
import food.daoimpl.OrderDetailsDAOImpl;
import food.daoimpl.UserDAOImpl;
import food.daoimpl.UserTypeDAOImpl;
import food.models.FoodBean;
import food.models.OrderBean;
import food.models.OrderDetailsBean;
import food.models.UserBean;
import food.models.UserTypeBean;

/**
 * Servlet implementation class MakeOrder
 */
@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderBean orderBean=new OrderBean();
	OrderDAO orderDAO=new OrderDAOImpl();
	OrderDetailsBean orderDetailsBean=new OrderDetailsBean();
	OrderDetailsDAO orderDetailsDAO=new OrderDetailsDAOImpl();
	UserBean userBean=new UserBean();
	UserDAO userDAO=new UserDAOImpl();
	UserTypeBean userTypeBean=new UserTypeBean();
	UserTypeDAO userTypeDAO=new UserTypeDAOImpl();
	FoodBean foodBean=new FoodBean();
	FoodDAO foodDAO=new FoodDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("food id "+(request.getParameter("foodId")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("food id "+(request.getParameter("id")));
		HttpSession session=request.getSession();
		Integer userId=userDAO.getUserIdByName(session.getAttribute("name").toString());
		userBean.setUserId(userId);
		orderBean.setUserBean(userBean);
		foodBean.setFoodId(Integer.parseInt(request.getParameter("id")));
		orderBean.setFoodBean(foodBean);
		orderBean.setQuantity(Integer.parseInt(request.getParameter("person")));
		orderBean.setPrice(Integer.parseInt(request.getParameter("price")));
		orderBean.setCreatedBy(userId);
		orderBean.setModifiedBy(userId);
		orderDAO.addOrder(orderBean);
		response.sendRedirect("savory/index.jsp");

	}

}
