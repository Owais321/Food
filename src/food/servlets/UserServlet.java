package food.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import food.dao.UserDAO;
import food.dao.UserTypeDAO;
import food.daoimpl.UserDAOImpl;
import food.daoimpl.UserTypeDAOImpl;
import food.models.UserBean;
import food.models.UserTypeBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBean userBean=new UserBean();
	UserDAO userDAO=new UserDAOImpl();
	UserTypeBean userTypeBean=new UserTypeBean();
	UserTypeDAO userTypeDAO=new UserTypeDAOImpl();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("userId")!=null){
			Integer userId=Integer.parseInt(request.getParameter("userId"));
			userBean.setCreatedBy(userId);
			userBean.setModifiedBy(userId);
			userBean.setUserId(userId);
			userDAO.updateUser(userBean);
			response.sendRedirect("admin/admin.jsp");
		}
		else if(request.getParameter("deleteId")!=null){
			Integer userId=Integer.parseInt(request.getParameter("deleteId"));
			userDAO.deleteUser(userId);
			response.sendRedirect("admin/admin.jsp");
		}
		else{
			HttpSession session=request.getSession();
			if(session.getAttribute("name")!=null){
				session.invalidate();
				response.sendRedirect("savory/index.jsp");
			}
			else{
				response.sendRedirect("savory/index.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(request.getParameter("signup")!=null){
			userBean.setUserName(request.getParameter("uname"));
			userBean.setPassword(request.getParameter("upass"));
			userBean.setContact(request.getParameter("contact"));
			userBean.setAddress(request.getParameter("address"));
			userBean.setCreatedBy(0);
			userBean.setModifiedBy(0);
			userTypeBean.setUserTypeId(userTypeDAO.getUserTypeIdByName(request.getParameter("combo")));
			userBean.setUserTypeBean(userTypeBean);
			if(userTypeBean.getUserTypeId()==1){
				userBean.setActive(0);
			}
			else{
				userBean.setActive(1);
			}
			userDAO.addUser(userBean);
			response.sendRedirect("Login.jsp");
			System.out.println("Success");
		}
		if(request.getParameter("login")!=null){
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			boolean found=userDAO.checkUser(name,password);
			if(found){
				session.setAttribute("name", name);
				response.sendRedirect("Login.jsp?login=success");
			}
			else{
				response.sendRedirect("Login.jsp?login=error");
			}
		}
		
		
		
	}

}
