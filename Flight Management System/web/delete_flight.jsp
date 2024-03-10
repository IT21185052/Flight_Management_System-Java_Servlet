<%@page import="phoenix.model.Flight"%>
<%@page import="phoenix.model.LevelOne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <%@include file="checkStaff.jsp"%>
        <%
                LevelOne levelOne = new LevelOne();
                Flight flight = new Flight();
                flight.setId(Integer.valueOf(request.getParameter("id")));
                int numRows = levelOne.deleteFlightDetails(flight);
                if(numRows>0){
                        response.sendRedirect("staff_dashboard.jsp");
                }

        %>

    </body>
</html>