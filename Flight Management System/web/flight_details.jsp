<%@page import="phoenix.model.Flight"%>
<%@page import="java.util.List"%>
<%@page import="phoenix.daos.FlightDataAccess"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Flight Details</title>
		
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	</head>
	<body>
	<% if(session.getAttribute("email") == null){ %>
	<%@include file="main_header.jsp" %>
	<%}else{ %>
	<%@include file="user_header.jsp" %>
	<%} %>
		
		
		<section style="background-color: #eee;opacity: 0.8;min-height: 100vh" >
                    
		  <div class="container pt-5">
		  	<h2 class="container pt-5">Flight Details</h2>
		  <%
				FlightDataAccess flightDao = new FlightDataAccess();
				List<Flight> flightList = flightDao.getAllFlightRecords();
				int i=0;
				while(i<flightList.size()){
			%>
                        <% if(i%3==0){ %>
		    <div class="row justify-content-middle p-2">
			<%} %>
			
		      <div class="col-lg-4 col-md-5">
		     
		        <div class="card"  style="border-radius: 10px; background-color:#d7f0f4">
		          <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light text-center "
		            data-mdb-ripple-color=dark>
		            <img src="https://images.squarespace-cdn.com/content/v1/60cca131d4c21706e70165de/1626725745316-DTTUV6CBTZOPSJUQLP7O/icon+b.png"
		              style="border-top-left-radius: 10px; border-top-right-radius: 10px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px"  class="img-fluid"
		              alt="Laptop" />
		            <a href="#!">
		              <div class="mask"></div>
		            </a>
		          </div>
		          <div class="card-body pb-2">
		            <div class="d-flex justify-content-between ripple-surface-light ripple">
		              <div>
		                <h4><a href="#!" style="color:#150E56; text-decoration: none"><%=flightList.get(i).getFlightNumber() %></a></h4>
		                <p style="color:#150E56"><%=flightList.get(i).getDate() %></p>
		              </div>
		            </div>
		          </div>
		          <hr class="my-0"/>
		          <div class="card-body pb-0">
		            <div class="d-flex justify-content-between text-dark">
		              <p><%=flightList.get(i).getDepartLocation() %></p>
		              <p class="text-dark"><%=flightList.get(i).getArrivalLocation() %></p>
		            </div>
		            <div class="d-flex justify-content-between text-dark">
		              <p>Departure <br><%=flightList.get(i).getDepartTime() %></p>
                           
		             <p class="text-dark">Arrival<br><%=flightList.get(i).getArrivalTime() %></p>
		            </div>
		            <p style="color:rgb(21, 14, 86);font-weight: bold;font-size:130%;">USD : <%=flightList.get(i).getTicketPrice() %></p>
		            <p class="small text-muted">Number Of Seats : <%=flightList.get(i).getNumberOfSeats() %></p>
		            
		          </div>
		          <hr class="my-0" />
		          <div class="card-body">
		            <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
		              
		              <a href="book_seat.jsp?id=<%=flightList.get(i).getId() %>"><button type="button" class="btn btn-outline-primary">Book Seat</button></a>
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