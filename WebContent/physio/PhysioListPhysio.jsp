<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>physioList</title>
</head>
<body>
<%@include file="/header.jsp" %>
	<form action="list_u" method="post">
		<input type="submit" value="Save">
	</form>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Physio</h2></caption>
            <tr>
               
                <th>Physio NIC</th>
                <th>Physio Name</th>
                <th>Name</th>
                <th>Certificate ID</th>
                <th>Address</th>
                <th>Experience</th>
                <th>Place Name</th>
                <th>Contact No</th>
                <th>Status</th>

            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.NIC}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.certificate_ID}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><c:out value="${user.exp}" /></td>
                    <td><c:out value="${user.place_Name}" /></td>
                    <td><c:out value="${user.contact_No}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    
                    <td>
                        <a href="edit_u?NIC=<c:out value='${user.NIC}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="profile_u?NIC=<c:out value='${user.NIC}' />">View Profile</a>                   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
    <%@include file="/footer.jsp" %> 
</body>
</html>