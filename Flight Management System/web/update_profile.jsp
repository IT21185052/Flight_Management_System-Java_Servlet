<%@page import="phoenix.daos.UserDataAccess"%>
<%@page import="phoenix.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Profile</title>
		<link rel="stylesheet" href="./Styles/main.css">
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
	<% String role=(String)session.getAttribute("role"); %>
	<%if(role.equals("User")){ %>
		<%@include file="user_header.jsp" %>
	<%}else{ %>
		<%@include file="staff_header.jsp" %>
	<%} %>
	

	<div class="container rounded bg-white mt-5 mb-5" style="opacity: 0.9">
	    <div class="row">
	    	<%
                        User user = new User();
                        user.setEmail((String)session.getAttribute("email"));
                        UserDataAccess userDao = new UserDataAccess();
                        user = userDao.getUserRecord(user);
                        if(user!=null){
                %>
	        <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://static.vecteezy.com/system/resources/previews/002/096/360/non_2x/account-settings-edit-profile-icon-eps-vector.jpg"><span class="orm-outline flex-fill mb-0"><h3>Update Profile</h3>User Type : <%=user.getName() %> <br><%=user.getEmail() %></span><span> </span></div>
	        </div>
	        
	        
	        
	        <div class="col-md-5 border-right">
                    <div class="p-3 py-5" style="box-shadow: 20px 20px 50px 15px grey;">
	                <div class="d-flex justify-content-between align-items-center mb-3">
	                    <h4 class="text-right">Profile Settings</h4>
	                </div>
	                <form action="UpdateProfile" method="post">
	                <div class="row mt-3">
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">User Type</label><input class="form-control" type="text" name="name" value="<%=user.getName() %>"></div>
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">Email</label><input class="form-control" type="email" name="email" value="<%=user.getEmail() %>"></div>
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">Password</label><input class="form-control" type="text" name="password" value="<%=user.getPassword() %>"></div>
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">Address</label><input class="form-control" name="address" value="<%=user.getAddress() %>"></div>
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">Date Of Birth</label><input class="form-control" type="date" name="dob" value="<%=user.getDob() %>"></div>
	                    <div class="form-outline flex-fill mb-0"><label class="form-label" for="form3Example1c">Role</label>
	                    	<select class="form-control" name="role">
	                    		<%if(role.equals("User")){ %>
								<option value="User">User</option>
								<%} else if(role.equals("Level 1")){ %>
								<option value="Level 1">Staff Level 1</option>
								<%}else{ %>
								<option value="Level 2">Staff Level 2</option>
								<%} %>
							</select>
	                    </div>
	                    
	                    <input type="number" name="id" value="<%=user.getId() %>" hidden>

	                </div>

	                <div class="mt-5 text-center"><input class="btn btn-outline-primary" type="submit" name="update" value="Save Profile"></div>
	                </form>
	            </div>
	        </div>
			<%} %>
	    </div>
	</div>

	<%@include file="footer.jsp" %>
	</body>
</html>
