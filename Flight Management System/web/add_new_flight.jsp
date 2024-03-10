<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add New Flight</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
		<%@include file="check_staff.jsp" %>
		<%@include file="staff_header.jsp" %>
		
		<% String role=(String)session.getAttribute("role"); %>
		
		<section>
                    <div class="container pt-2 vh-100">
		   <h1 class="container pt-5 mb-4">Add Flight</h1>
                   <div style="margin-left:5%">
		   <form action="AddNewFlight" method="post" class="contact-form row">
                       
		      <div class="form-outline flex-fill mb-2 col-lg-6">
                           <h5><label class="form-label" for="form3Example1c">Flight Number</label></h5>
		         <input id="name" class="form-control" type="text" name="flightNumber" required>
                        
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6 ">
                           <h5><label class="form-label" for="form3Example1c">Number Of Seats</label></h5>
		         <input id="email" class="form-control" type="number" name="numberOfSeats" required>
		        
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6 ">
                          <h5><label class="form-label" for="form3Example1c">Depart Location</label></h5>
		         <input id="company" class="form-control" type="text" name="departLocation" required>
		         
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6">
                            <h5><label class="form-label" for="form3Example1c">Arrival Location</label></h5>
		         <input id="phone" class="form-control" type="text" name="arrivalLocation" required>
		        
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6">
                          <h5><label class="form-label" for="form3Example1c">Depart Time</label></h5>
		         <input id="company" class="form-control" type="time" name="departTime" required>
		         
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6">
                           <h5><label class="form-label" for="form3Example1c">Arrival Time</label></h5>
		         <input id="phone" class="form-control" type="time" name="arrivalTime" required>
		         
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6">
                          <h5><label class="form-label" for="form3Example1c">Ticket Price</label></h5>
		         <input id="company" class="form-control" type="number" name="ticketPrice" required>
		         
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6">
                           <h5><label class="form-label" for="form3Example1c">Date</label></h5>
		         <input id="phone" class="form-control" type="date" name="date" required>
		         
		         <input type="text" name="role" value="<%=session.getAttribute("role") %>" hidden>
		      </div>
		      <div class="form-field col-lg-12">
		         <input type="submit"class="btn btn-outline-primary"  name="addFlight" value="Add Flight">
		      </div>
		   </form>
                    </div>
                    </div>
		</section>
		
	<%@include file="footer.jsp" %>
	</body>
</html>
