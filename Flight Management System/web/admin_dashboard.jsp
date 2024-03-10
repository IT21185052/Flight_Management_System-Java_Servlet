<%@page import="java.sql.ResultSet"%>
<%@page import="phoenix.model.User"%>
<%@page import="java.util.List"%>
<%@page import="phoenix.model.StaffMember"%>
<%@page import="phoenix.daos.UserDataAccess"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
		<%@include file="check_admin.jsp" %>
		<%@include file="admin_header.jsp" %>
		
		
                <section>
                    <div class="card-body">
	            <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
	            	
                        </div>
	          </div>
                        </section>
	        <section style="background-color: #ebf8fa;opacity: 0.85">      	
	            
			<hr class="m-5">
                        
		  <div class="container py-5">
                      <h2 >Staff Management</h2>
                        <a href="add_new_staff_member.jsp"><button type="button" class="btn btn-outline-primary mb-3 mt-2">Add New Staff Member</button></a>
		  	 <table class="table">
		  	  
			  <thead class="thead-dark">
			    <tr>
			      	<th scope="col">Staff ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Address</th>
					<th>Role</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
					UserDataAccess userDao = new UserDataAccess();
					List<StaffMember> staffList=userDao.getStaffMembers();
					int i=0;
					while(i < staffList.size()){
				%>
			    <tr>
			      
			     	<td scope="row"><%=staffList.get(i).getId() %></td>
					<td scope="row"><%=staffList.get(i).getName() %></td>
					<td scope="row"><%=staffList.get(i).getEmail() %></td>
					<td scope="row"><%=staffList.get(i).getPassword() %></td>
					<td scope="row"><%=staffList.get(i).getDob() %></td>
					<td scope="row"><%=staffList.get(i).getAddress() %></td>
					<td scope="row"><%=staffList.get(i).getRole() %></td>
					<td scope="row"><%=staffList.get(i).getAccStatus() %></td>
					<td scope="row">
					<% if(staffList.get(i).getAccStatus().equals("Activated")){ %>
						<a href="deactivate_staff_member.jsp?id=<%=staffList.get(i).getId() %>"><button type="button" class="btn btn-outline-primary">De-Activate</button></a>
					<%}else{ %>
                                        <a href="activate_staff_member.jsp?id=<%=staffList.get(i).getId() %>"><button type="button" class="btn btn-outline-success">&nbsp;&nbsp;&nbsp;Activate&nbsp;&nbsp;&nbsp;</button></a>
					<%} %>
						<a href="remove_staff_member.jsp?id=<%=staffList.get(i).getId() %>"><button type="button" class="btn btn-outline-danger">&nbsp;&nbsp;&nbsp;Remove&nbsp;&nbsp;&nbsp;</button></a>
					</td>
				</tr>
				<%i++;} %>
			   
			    
			  </tbody>
			</table>
		  </div>
		  <hr class="m-5">
		</section>
		
		
		<section style="background-color: #ebf8fa;opacity: 0.85">
		  <div class="container py-5">
		  	
	          <h2>User Management</h2>
		  	<table class="table">
		  	  
			  <thead class="thead-dark">
			    <tr>
			      	<th scope="col">User ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Address</th>
					<th>Role</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
                                    List<User> userList = userDao.getUsers();
                                    i = 0;
                                    while(i < userList.size()) {
				%>
			    <tr>
			      
			     	<td scope="row"><%=userList.get(i).getId() %></td>
					<td scope="row"><%=userList.get(i).getName() %></td>
					<td scope="row"><%=userList.get(i).getEmail() %></td>
					<td scope="row"><%=userList.get(i).getPassword() %></td>
					<td scope="row"><%=userList.get(i).getDob() %></td>
					<td scope="row"><%=userList.get(i).getAddress() %></td>
					<td scope="row"><%=userList.get(i).getRole() %></td>
					<td scope="row"><%=userList.get(i).getAccStatus() %></td>
					<td scope="row">
						<a href="remove_staff_member.jsp?id=<%=userList.get(i).getId() %>"><button type="button" class="btn btn-outline-danger">Remove</button></a>
					</td>
				</tr>
				<%i++;} %>
			   
			    
			  </tbody>
			</table>
		  </div>
		 <hr class="m-5">
		</section>
		
		
		<section style="background-color: #ebf8fa;opacity: 0.85">
		  <div class="container py-5">
		  	
	          <h2>Login Details</h2>
		  	<table class="table">
		  	  
			  <thead class="thead-dark">
			    <tr>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Date & Time</th>
					<th scope="col">IP Address</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
				
				  	ResultSet result = userDao.getAllLoginDetailsRecords();
					while(result.next()){
				%>
			    <tr>

					<td scope="row"><%=result.getString("email") %></td>
					<td scope="row"><%=result.getString("role") %></td>
					<td scope="row"><%=result.getString("time") %></td>
					<td scope="row"><%=result.getString("ip") %></td>
				</tr>
				<%i++;} %>
			   
			    
			  </tbody>
			</table>
		  </div>
		 <hr class="m-5">
		</section>
		
		<%@include file="footer.jsp" %>
	</body>
</html>