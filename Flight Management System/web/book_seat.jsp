<%@page import="phoenix.model.Flight"%>
<%@page import="java.util.List"%>
<%@page import="phoenix.daos.FlightDataAccess"%>
<%@page import="phoenix.daos.TicketDataAccess"%>
<%@page import="phoenix.model.User"%>
<%@page import="phoenix.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Seat Booking</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	
</head>
<body>

	<%@include file="check_user.jsp" %>
	<%@include file="user_header.jsp" %>
		<section style="background-color: #eee;opacity: 0.85">
		  <div class="container py-5">
		  	<h2 class="container py-5">Book Seat</h2>
		  <%
		  	Flight flight = new Flight();			
			flight.setId(Integer.valueOf(request.getParameter("id")));			
			FlightDataAccess flightDao = new FlightDataAccess();
			flight = flightDao.getFlightRecord(flight);
			if(flight != null) {
				
				
			%>
		  	
		    <div class="row justify-content-center p-2">
			
			
		      <div class="col-lg-4 col-md-5">
		     
		        <div class="card" style="border-radius: 10px; background-color:#d7f0f4">
		          <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
		            data-mdb-ripple-color="dark">
		            <img src="images/flight.png"
		              style="border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px"  class="img-fluid"
		              alt="Laptop" />
		            <a href="#!">
		              <div class="mask"></div>
		            </a>
		          </div>
		          <div class="card-body pb-2">
		            <div class="d-flex justify-content-between ripple-surface-light ripple">
		              <div>
		                <h4><a href="#!" style="color:#150E56; text-decoration: none"><%=flight.getFlightNumber() %></a></h4>
		                <p style="color:#150E56"><%=flight.getDate() %></p>
		              </div>
		            </div>
		          </div>
		          <hr class="my-0" />
		          <div class="card-body pb-0">
		            <div class="d-flex justify-content-between text-dark">
		              <p><%=flight.getDepartLocation() %></p>
		              <p class="text-dark"><%=flight.getArrivalLocation() %></p>
		            </div>
		            <div class="d-flex justify-content-between text-dark">
		              <p>Departure <br><%=flight.getDepartTime() %></p>
                              
		              <p class="text-dark">Arrival<br><%=flight.getArrivalTime() %></p>
		            </div>
		            <p style="color:rgb(21, 14, 86);font-weight: bold;font-size:130%;"> USD: <%=flight.getTicketPrice() %></p>
		            <p class="small text-muted">Number Of Seats : <%=flight.getNumberOfSeats() %></p>
		            
		          </div>
		          
		          <hr class="my-0" />
		          <div class="card-body">
		            <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
		              <form action="BookTicket" method="post" style="width: 23rem;">
		              	
		              	<div class="form-outline mb-4">
		              		<label class="form-label" for="form2Example18">Number Of Seats</label>
			              <input type="number" id="form2Example18" class="form-control form-control-lg" name="numberOfSeats" />
			              
			              <input type="text" name="email" value="<%=session.getAttribute("email")%>" hidden>
						  <input type="text" class="form-control form-control-lg" name="id" value="<%=flight.getId() %>" hidden>
			            </div>
		              	<div class="pt-1 mb-4">
			            	<input class="btn btn-outline-primary" type="submit" name="generateTicket" value="Generate Ticket">
			        
			            </div>
		              </form>
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
