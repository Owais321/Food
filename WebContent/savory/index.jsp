<!DOCTYPE HTML>
<!--
	Aesthetic by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<%@page import="food.dao.FoodDAO"%>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Savory &mdash; Free Website Template, Free HTML5 Template by GetTemplates.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by GetTemplates.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="GetTemplates.co" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<%@page import="food.models.FoodBean"%> 
	<%@page import="food.daoimpl.FoodDAOImpl"%> 
	<%@page import="food.models.UserBean"%>
	<%@page import="food.daoimpl.UserDAOImpl"%> 
	<%@page import="food.models.UserTypeBean"%>
	<%@page import="food.daoimpl.UserTypeDAOImpl"%> 
	<%@page import="java.text.SimpleDateFormat"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.util.List"%> 

	</head>
	<body>
	<% 
		FoodDAO foodDAO1=new FoodDAOImpl();
		List<FoodBean> foodBean1=foodDAO1.getAllFoods();
		try{
		for(FoodBean fb:foodBean1){
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
				String time1=timestamp.toString();
				String time2=fb.getTime().toString();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
				SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
		        Date date1 = format.parse(time1);
		        Date date2 = format1.parse(time2);
		        long milliseconds = date1.getTime() - date2.getTime();
		        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
		        if(hours>2){
		        	foodDAO1.updateFood(fb.getFoodId());
		        }
			
			} 
		}
		catch (Exception ex) {
            ex.printStackTrace();
        	}
	%>
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<!-- <div class="page-inner"> -->
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.html">Savory <em>.</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="#dishes">Menu</a></li>
						<li><a href="../Profile/index.jsp">Profle</a></li>
						<li class="has-dropdown">
							<a href="#">About Us</a>
						</li>
						<li class="btn-cta"><a href="#"><span onclick="checkUser();">Post</span></a></li>
						<li class="btn-cta"><a href="../Login.jsp"><span>Login/Sign Up</span></a></li>
						<li class="btn-cta"><a href="../Login.jsp"><span><form action="../UserServlet" method="get" style="display:inline;">
							<input type="submit" value="LogOut" style="background:rgb(75,67,58); border:0px; "/>
						</form></span></a></li>
						
						<script>
							function checkUser(){
								var a=false;
								<% System.out.println(session.getAttribute("name"));%>
								<% 
									if(session.getAttribute("name")!=null){
										%>
										a=true;
										document.getElementById('id01').style.display='block';
										<%
									}
									else{
										%>alert("Please Login First!!!");<%
									}
								%>
							}
						</script>
					</ul>	
				</div>
				<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="../FoodServlet" method="post" enctype="multipart/form-data">
    <div class="container">
      <h1>What You Have To Sell</h1>
      <p>Please Add Disciption for your product .</p>
      <hr>
      <label for="email"><b>Food Name</b></label>
      <input type="text" placeholder="Enter Foodname" name="foodname" required>

      <label for="psw"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" required>

      <label for="psw-repeat"><b>Price</b></label>
      <input type="number" placeholder="Enter Price" name="price" required>
      
       <label for="psw-repeat"><b>Number of person</b></label>
      <input type="number" placeholder="Number of person" name="person" required>
     
       <label for="psw-repeat"><b>Description</b></label>
      <input type="text" placeholder="Description" name="description" required>
      <label>
      <label for="psw-repeat"><b>Choose Image</b></label>
      <input type="file" name="pic" required>
      <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>
      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelpost">Cancel</button>
        <button type="submit" class="confirmpost" name="post">Post</button>
      </div>
    </div>
  </form>
</div>
<!-- modaaal for customer post -->
			</div>
			
		</div>
	</nav>
	<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span>
							<h1 class="cursive-font">All in good taste!</h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<h3 class="cursive-font">Table Reservation</h3>
											<form action="../UserServlet">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="activities">Persons</label>
														<select name="#" id="activities" class="form-control">
															<option value="">Persons</option>
															<option value="">1</option>
															<option value="">2</option>
															<option value="">3</option>
															<option value="">4</option>
															<option value="">5+</option>
														</select>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="date-start">Date</label>
														<input type="text" id="date" class="form-control">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="date-start">Time</label>
														<input type="text" id="time" class="form-control">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary btn-block" value="Reserve Now">
													</div>
												</div>
											</form>	
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	
	
	<div id="dishes" class="gtco-section">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2 class="cursive-font primary-color">Popular Dishes</h2>
					<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
				</div>
			</div>
			<div class="row">
				<% 
					FoodDAO foodDAO=new FoodDAOImpl();
					List<FoodBean> foodBean=foodDAO.getAllFoods();
					for(FoodBean fb:foodBean){
						%>
						<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="images/<%=fb.getPath()%>" class="fh5co-card-item image-popup">
						<figure>
							<div class="overlay"><i class="ti-plus"></i></div>
							<img src="images/<%=fb.getPath()%>" alt="Image" class="img-responsive">
						</figure>
						</a>
						<a href='MakeOrder.jsp?foodId=<%=fb.getFoodId() %>' class="fh5co-card-item" >
						<div id="<%=fb.getFoodId()%>" class="fh5co-text ">
							<h2 id="hname'"><%= fb.getName() %> </h2>
							<p><%= fb.getDescription() %></p>
							<p><span class="price cursive-font">RS : <%= fb.getPrice() %></span></p>
						</div>
						</a>	
				</div>
						<%
					}
				%>	
			</div>
		</div>
	</div>
	<!-- </div> -->
	
	</div>
	<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	
	<script src="js/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="js/main.js"></script>


	</body>
</html>

