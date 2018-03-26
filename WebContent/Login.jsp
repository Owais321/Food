<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="logincss/style1.css">

  
</head>

<body>
  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form action="UserServlet" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
               Name<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="uname" />
            </div>
        
            <div class="field-wrap">
              <label>
                Password<span class="req" >*</span>
              </label>
              <input type="password"required autocomplete="off" name="upass"/>
            </div>
            </div>
            <div class="top-row">
            <div class="field-wrap">
              <label>
               Contact<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="contact"/>
            </div>
            
            <div class="field-wrap">
            <select required="required" name="combo">
            	<option value="">Sign Up as</option>
            	<option value="House Wife">House Wife</option>
            	<option value="Customer">Customer</option>
            </select>
          </div>
          </div>
          
          
          <div class="field-wrap">
            <label>
              Address<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" name="address"/>
          </div>
          
          <button type="submit" class="button button-block" name="signup">Get Started</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          
          <form action="UserServlet" method="post">
          
            <div class="field-wrap">
            <label>
              Name<span class="req">*</span>
            </label>
            <input type="text"required autocomplete="off" name="name"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="pass"/>
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <button class="button button-block" name="login">Log In</button>
          
          </form>
          	<%  
          		if(request.getParameter("login")!=null){
    				String login=request.getParameter("login");
    				if(login.equals("success")){
    					response.sendRedirect("savory/index.jsp");
    				}else{
    					%><script>alert("Login UnSuccessfuly");</script><%
    				}	
    			}		
		 %>
        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="loginjs/index1.js"></script>
</body>

</html>
