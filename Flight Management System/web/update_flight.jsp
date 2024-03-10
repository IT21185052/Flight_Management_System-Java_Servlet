<%@page import="phoenix.daos.FlightDataAccess"%>
<%@page import="phoenix.model.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Flight Details</title>
		<link rel="stylesheet" href="./Styles/main.css">
		<link rel="stylesheet" href="./Styles/addFlight.css">
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
		<%@include file="check_staff.jsp" %>
		<%@include file="staff_header.jsp" %>
		
		<section >
                    <div class="container pt-2 vh-100">
		   <h1 class="container pt-5 mb-4">Flight Details</h1>
                   <div style="margin-left:5%">
		   <form action="UpdateFlight" method="post" class="contact-form row">
		   	<%
				Flight flight=new Flight();
				flight.setId(Integer.valueOf(request.getParameter("id")));				
				FlightDataAccess fDao = new FlightDataAccess();
				flight = fDao.getFlightRecord(flight);	
				if(flight!=null){			
			%>
		   
		      <div class="form-outline flex-fill mb-2 col-lg-6">
                          <h5><label class="form-label" for="form3Example1c">Flight Number</label></h5>
		         <input id="name" class="form-control" type="text" name="flightNumber" value="<%=flight.getFlightNumber()%>" required>
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6">
                          <h5><label class="form-label" for="email">Number Of Seats</label></h5>
		         <input id="email" class="form-control" type="number" name="numberOfSeats" value="<%=flight.getNumberOfSeats()%>" required>
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6 ">
                          <h5><label class="form-label" for="company">Depart Location</label></h5>
		         <input id="company" class="form-control" type="text" name="departLocation" value="<%=flight.getDepartLocation()%>" required>
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6 ">
                           <h5> <label class="form-label" for="phone">Arrival Location</label></h5>
		         <input id="phone" class="form-control" type="text" name="arrivalLocation" value="<%=flight.getArrivalLocation()%>" required>
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6 ">
                       <h5><label class="form-label" for="company">Depart Time</label></h5>
		         <input id="company" class="form-control" type="time" name="departTime" value="<%=flight.getDepartTime()%>" required>
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6 ">
                           <h5><label class="form-label" for="phone">Arrival Time</label></h5>
		         <input id="phone" class="form-control" type="time" name="arrivalTime" value="<%=flight.getArrivalTime()%>" required>
		      </div>
		      <div class="form-outline flex-fill mb-2 col-lg-6 ">
                          <h5><label class="form-label" for="company">Ticket Price</label></h5>
		         <input id="company" class="form-control" type="number" name="ticketPrice" value="<%=flight.getTicketPrice()%>" required>
		      </div>
		       <div class="form-outline flex-fill mb-2 col-lg-6 ">
                          <h5><label class="form-label" for="phone">Date</label></h5>
		         <input id="phone" class="form-control" type="date" name="date" value="<%=flight.getDate()%>" required>
		         <input type="text" name="role" value="<%=session.getAttribute("role") %>" hidden>
		      </div>
		      <div class="form-outline flex-fill mb-0 col-lg-6 mt-3">
		      	<input type="text" name="id" value="<%=flight.getId()%>" hidden>
		         <input type="submit"class="btn btn-outline-primary"  name="updateFlight" value="Update Flight">
                         <br><br>
		      </div>
		      <%} %>
		   </form>
                   </div>
                    </div>
		</section>
		<%@include file="footer.jsp" %>
	</body>
</html>