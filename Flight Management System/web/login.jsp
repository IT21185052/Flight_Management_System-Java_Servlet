<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="./Styles/login.css">
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
		
	</head>
	<body>
		<%@include file="main_header.jsp" %>

		
		<section class="vh-100">
			  <div class="container-fluid">
			    <div class="row">
			      <div class="col-sm-6 px-0 d-none d-sm-block">
			        <img src="https://c0.wallpaperflare.com/preview/853/729/88/aircraft-airplane-airplane-window-aviation.jpg" alt="Login image" class="w-100 vh-100" style="opacity: 0.6;object-fit: cover; object-position: left;box-sizing: 1px">
			      </div>
                                 <div class="col-sm-6 text-black">
                                  <div class="row vh-100 align-items-center">
                                  
                                  <!-- div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5" -->
                                  
			        <div class="d-flex justify-content-center">
                                    
                                    <div style="height: 75vh; width: 23rem; overflow-y: auto; overflow-x: visible">
			          <form action="login" method="post" style="width: 85%;">
			
			            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>
                                    <!--<div class="alert alert-danger">
                                    <strong>Warning!</strong>Wrong username or password.
                                    </div>-->
			            <div class="form-outline mb-4">
                                      
                                      <input type="email" id="form2Example18" placeholder="Email address" class="form-control form-control-lg" name="email"/>
			            </div>
			
			            <div class="form-outline mb-4">
                                        
                                        <input type="password" id="form2Example28" placeholder="Password" class="form-control form-control-lg" name="password"/>
			              
			            </div>
			
			            <div class="pt-1 mb-4">
			            	<input class="btn btn-outline-primary" type="submit" name="login" value="&nbsp;&nbsp;Login&nbsp;&nbsp;">
			              <!--<button class="btn btn-info btn-lg btn-block" type="button">Login</button>-->
			            </div>
			
			            <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Lost your password?</a></p>
			            <p>Don't have an account? <a href="registration.jsp" style="font-family: sans-serif; text-decoration: none">Register here</a></p>
			
			          </form>
                                    </div>
                                </div>
			        </div>
			
			      </div>
                            </div>
			  </div>
		</section>
		
		
		
		
		<%@include file="footer.jsp" %>
	</body>
</html>
