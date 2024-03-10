<%@page import="phoenix.daos.UserDataAccess"%>
<%@page import="phoenix.model.StaffMember"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activate Staff Member</title>
</head>
<body>
<%
    StaffMember staffMember = new StaffMember();
    staffMember.setId(Integer.valueOf(request.getParameter("id")));
    UserDataAccess userDao = new UserDataAccess();
    int numRows = userDao.activateStaffMember(staffMember);
    if(numRows > 0) {
        response.sendRedirect("admin_dashboard.jsp");
    }
%>
</body>
</html>