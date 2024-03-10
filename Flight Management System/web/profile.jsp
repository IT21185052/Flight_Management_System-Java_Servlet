<%@page import="phoenix.daos.UserDataAccess"%>
<%@page import="phoenix.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Profile</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
	<% String role=(String)session.getAttribute("role"); %>
	<%if(role.equals("User")){ %>
		<%@include file="user_header.jsp" %>
	<%}else{ %>
		<%@include file="staff_header.jsp" %>
	<%} %>
	<section style="background-color: #eee;opacity: 0.9;">
	  <div class="container py-5">
	    <%
			User user = new User();
			user.setEmail((String)session.getAttribute("email"));
			UserDataAccess userDao = new UserDataAccess();
			user = userDao.getUserRecord(user);
			if(user!=null){
		%>
	
	    <div class="row justify-content-center">
	      <div class="col-lg-4">
	        <div class="card mb-4">
	          <div class="card-body text-center" style="box-shadow: 20px 20px 50px 15px grey;">
	            <img src="https://www.svgrepo.com/show/295402/user-profile.svg" alt="avatar"
	              class="rounded-circle img-fluid" style="width: 150px;">
	            <h5 class="my-3"><%=user.getName() %></h5>
	            <p class="text-muted mb-1"><%=user.getEmail() %></p>
	            
	          </div>
	        </div>
	        
	      <div class="col-lg-12"  style="box-shadow: 20px 20px 50px 15px grey;">
	        <div class="card mb-4">
	          <div class="card-body">
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Full Name</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getName() %></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Email</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getEmail() %></p>
	              </div>
	            </div>
	            <hr>
	            
	           
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Password</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getPassword() %></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Address</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getAddress() %></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Date Of Birth</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getDob() %></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Role</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getRole() %></p>
	              </div>
	            </div>
	            <hr>
	            <div class="row">
	              <div class="col-sm-3">
	                <p class="mb-0">Account Status</p>
	              </div>
	              <div class="col-sm-9">
	                <p class="text-muted mb-0"><%=user.getAccStatus() %></p>
	              </div>
	            </div>
	          </div>
	        </div>
	        <div class="card-body">
	            <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
	              
	              <a href="update_profile.jsp?id=<%=user.getId() %>"><button type="button" class="btn btn-outline-primary">Update Profile</button></a>
	            </div>
          	</div>
	        
	      </div>
	    </div>
	  </div>
	  <%} %>
	  </div>
	</section>

	<%@include file="footer.jsp" %>
	</body>
</html>