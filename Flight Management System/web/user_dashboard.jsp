<%@page import="phoenix.model.Flight"%>
<%@page import="java.util.List"%>
<%@page import="phoenix.daos.FlightDataAccess"%>
<%@page import="phoenix.model.User"%>
<%@page import="phoenix.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard</title>
		<link rel="stylesheet" href="./Styles/main.css">
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
	<%@include file="check_user.jsp" %>
	<%@include file="user_header.jsp" %>
		
		
		<section style="background-color: #eee;opacity: 0.85 ;min-height:100vh">
		  <div class="container py-5">
		  	<h2 class="container pt-5">My reservations</h2>
		  <%
			  	Ticket ticket = new Ticket();
				ticket.setEmail((String)session.getAttribute("email"));
				User user = new User();
				List<Ticket> ticketList = user.viewTicketsByEmail(ticket);
				
				int i=0;
				while(i<ticketList.size()){
		  			Flight flight = new Flight();
		  			flight.setId(ticketList.get(i).getFlightId());
					FlightDataAccess flightDao = new FlightDataAccess();
					flight = flightDao.getFlightRecord(flight);
				
				
			%>
                        <% if(i%3==0){ %>
		    <div class="row justify-content-between p-2">
			<%} %>
			
		      <div class="col-lg-4 col-md-5">
		     
		        <div class="card" style="border-radius: 10px; background-color:#d7f0f4">
		          <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
		            data-mdb-ripple-color=dark>
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
		              <p><%=flight.getDepartLocation() %></a></p>
		              <p class="text-dark"><%=flight.getArrivalLocation() %></p>
		            </div>
		            <div class="d-flex justify-content-between text-dark">
		              <p>Departure <br><%=flight.getDepartTime() %></a></p>
                              
		              <p class="text-dark">Arrival<br><%=flight.getArrivalTime() %></p>
		            </div>
		            <p class="color:rgb(21, 14, 86);font-weight: bold;font-size:130%;"> USD : <%=flight.getTicketPrice() %></p>
		            <p class="small text-muted">Number Of Seats : <%=flight.getNumberOfSeats() %></p>
		            
		          </div>
		          <hr class="my-0" />
		          <p>Booking Details</p>
		          <div class="card-body pb-0">
		            <div class="d-flex justify-content-between">
		              <p>Ticket Id</a></p>
		              <p class="text-dark"><%=ticketList.get(i).getId() %></p>
		            </div>
		            <div class="d-flex justify-content-between">
		              <p>Booked Seat Count : </a></p>
		              <p class="text-dark"><%=ticketList.get(i).getNumberOfSeats() %></p>
		            </div>
		            <p class="small text-muted">Payment Status : <%=ticketList.get(i).getPaymentStatus() %></p>
		          </div>
		          
		          <hr class="my-0" />
		          <div class="card-body">
		            <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
		              
		              <a href="update_reservation.jsp?id=<%=ticketList.get(i).getId() %>"><button type="button" class="btn btn-outline-primary">Update Details</button></a>
		              <a href="delete_reservation.jsp?id=<%=ticketList.get(i).getId() %>"><button type="button" class="btn btn-outline-primary">Delete Details</button></a>
		            </div>
		          </div>
		        </div>
		      </div>
		    <% if(i%3==0 && i!=0){ %>
		    </div>
		    <%}i++;} %>
		  </div>
		</section>
		
		<%@include file="footer.jsp" %>
	</body>
</html>