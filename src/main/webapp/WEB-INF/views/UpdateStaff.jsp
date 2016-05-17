<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Staff</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/staff/updateStaff" method="post">
		<h1>Update Staff</h1>
		<br> Staff Name    <input type="text" name="staffName" value = > 
		<br> Staff Address <input type="text" name="staffAddress">
		<br> Staff Email   <input type="text" name="staffEmail">
		<br> <input type="submit" value="Save">
</form>
</body>
</html>