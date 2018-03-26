<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  	<%@page import="food.models.FoodBean"%> 
  	<%@page import="food.dao.FoodDAO"%>
	<%@page import="food.daoimpl.FoodDAOImpl"%> 
	<%@page import="food.models.UserBean"%>
	<%@page import="food.daoimpl.UserDAOImpl"%> 
	<%@page import="food.models.UserTypeBean"%>
	<%@page import="food.daoimpl.UserTypeDAOImpl"%> 
	<%@page import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/modal.css">
	<%@page import="food.models.UserBean"%>
	<%@page import="food.dao.UserDAO"%>
	<%@page import="food.daoimpl.UserDAOImpl"%> 
</head>
<body>
	<%
			if(session.getAttribute("name")==null){
  				response.sendRedirect("../savory/index.jsp?");
  			}
			else{
				UserDAO userDAO=new UserDAOImpl();
				Integer userId=userDAO.getUserIdByName(session.getAttribute("name").toString());
				UserBean userBean=userDAO.getUserById(userId);
				if(userBean.getUserTypeBean().getUserTypeId()==1){
					response.sendRedirect("../savory/index.jsp?");
				}
				
			}
  		%>
<div id="id02" class="modal">
  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="../MakeOrder" method="post">
    <div class="container">
    	<% 
    		Integer foodId=Integer.parseInt(request.getParameter("foodId"));
    		FoodDAO foodDAO=new FoodDAOImpl();
    		FoodBean foodBean=foodDAO.getFoodById(foodId);
    	%>
      <h1>What You Have To Buy</h1>
      <p>Please Add Disciption for your product .</p>
      <hr>
      <label for="email"><b>Food Name</b></label>
      <input type="hidden" name="id" value=<%=foodId %> hidden/>
      <input type="text" placeholder="Enter Foodname" name="foodname" value=<%=foodBean.getName() %> required>

      <label for="psw"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" value=<%=foodBean.getAddress()%> required>
      
      <label for="psw-repeat"><b>Description</b></label>
      <input type="text" placeholder="Description" name="description" value=<%=foodBean.getDescription() %> required>
      <label>

       <label for="psw-repeat"><b>Number of person</b></label>
      <input type="number" placeholder="Number of person" name="person" value=<%=foodBean.getQuantity() %> required>
      
       <label for="psw-repeat"><b>Price</b></label>
      <input type="number" placeholder="Enter Price" name="price" value=<%=foodBean.getPrice()%> required>
     
       
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>
      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelpost">Cancel</button>
        <button type="submit" class="confirmpost" name="makeorder">Make Order</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>