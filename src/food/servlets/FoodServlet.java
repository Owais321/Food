package food.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import food.dao.FoodDAO;
import food.dao.UserDAO;
import food.dao.UserTypeDAO;
import food.daoimpl.FoodDAOImpl;
import food.daoimpl.UserDAOImpl;
import food.daoimpl.UserTypeDAOImpl;
import food.models.FoodBean;
import food.models.UserBean;
import food.models.UserTypeBean;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodBean foodBean=new FoodBean();
	FoodDAO foodDAO=new FoodDAOImpl();
	UserBean userBean=new UserBean();
	UserTypeBean userTypeBean=new UserTypeBean();
	UserDAO userDAO=new UserDAOImpl();
	UserTypeDAO userTypeDAO=new UserTypeDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
			File file ;
			   int maxFileSize = 5000 * 1024;
			   int maxMemSize = 5000 * 1024;
			   String filePath = "M:\\Java EE\\Food\\WebContent\\savory\\images\\";
			   String contentType = request.getContentType();
			   if ((contentType.indexOf("multipart/form-data") >= 0)) {
				   String paths="";
				   String name="";
				   String address="";
				   Integer price=0;
				   Integer quantity=0;
				   String des=""; 
			      DiskFileItemFactory factory = new DiskFileItemFactory();
			      factory.setSizeThreshold(maxMemSize);
			      factory.setRepository(new File("c:\\temp"));
			      ServletFileUpload upload = new ServletFileUpload(factory);
			      upload.setSizeMax( maxFileSize );
			  
			      try{ 
			         List fileItems = upload.parseRequest(request);
			         Iterator i = fileItems.iterator();
			         while ( i.hasNext () ) 
			         {
			            FileItem fi = (FileItem)i.next();
			           
			            if ( !fi.isFormField () )  {
			                String fieldName = fi.getFieldName();
			                String fileName = fi.getName();
			                boolean isInMemory = fi.isInMemory();
			                long sizeInBytes = fi.getSize();
			                file = new File( filePath + fileName) ;
			                fi.write( file ) ;
			                paths=fileName;
			                System.out.println("Uploaded Filename: " + filePath + fileName);
			            }else if(fi.isFormField()){
			            	if(fi.getFieldName().equals("foodname")){
			            		name=fi.getString();
			            	}
			            	if(fi.getFieldName().equals("address")){
			            		address=fi.getString();
			            	}
			            	if(fi.getFieldName().equals("price")){
			            		price=Integer.parseInt(fi.getString());
			            	}
			            	if(fi.getFieldName().equals("person")){
			            		quantity=Integer.parseInt(fi.getString());
			            	}
			            	if(fi.getFieldName().equals("description")){
			            		des=fi.getString();
			            	}
			            }
			         }
			      }catch(Exception e){
			    	  e.printStackTrace();
			      }
			foodBean.setName(name);
			foodBean.setAddress(address);
			foodBean.setDescription(des);
			foodBean.setQuantity(quantity);
			foodBean.setPath(paths);
			foodBean.setPrice(price);
			System.out.println(session.getAttribute("name").toString()); 
			String userName=session.getAttribute("name").toString();
			Integer userId=userDAO.getUserIdByName(userName);
			System.out.println("user id aa baba "+userId);
			foodBean.setCreatedBy(userId);
			foodBean.setModifiedBy(userId);
			userBean.setUserId(userId);
			foodBean.setUserBean(userBean);
			userBean=userDAO.getUserById(userBean.getUserId());
			userTypeBean.setUserTypeId(userBean.getUserTypeBean().getUserTypeId());
			foodBean.setUserTypeBean(userTypeBean);
			foodDAO.addFood(foodBean);
			response.sendRedirect("savory/index.jsp");
			}
		
		}
	}
