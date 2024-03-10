<%@page import="phoenix.daos.TicketDataAccess"%>
<%@page import="phoenix.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
	</head>
	<body>
	<%
		Ticket ticket = new Ticket();
		ticket.setId(Integer.valueOf(request.getParameter("id")));
		TicketDataAccess ticketDao = new TicketDataAccess();	
		int numRows = ticketDao.deleteTicketRecord(ticket);		
		if(numRows > 0) {
                    response.sendRedirect("user_dashboard.jsp");
		}
	%>
	</body>
</html>
