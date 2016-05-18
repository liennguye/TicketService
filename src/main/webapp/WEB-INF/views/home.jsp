<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
.round-button {
	width: 33.33%;
}

.round-button-circle {
	width: 100%;
	height: 0;
	padding-bottom: 100%;
	border-radius: 50%;
	border: 10px solid #cfdcec;
	overflow: hidden;
	background: #4679BD;
	box-shadow: 0 0 3px gray;
}

.round-button-circle:hover {
	background: #30588e;
}

.round-button a {
	display: block;
	float: left;
	width: 100%;
	padding-top: 50%;
	padding-bottom: 50%;
	line-height: 1em;
	margin-top: -0.5em;
	text-align: center;
	color: #e2eaf3;
	font-family: Verdana;
	font-size: 1.2em;
	font-weight: bold;
	text-decoration: none;
}

.float-left {
	float: left;
}

.type2 {
	background: #ECA215;
}

.type2:hover {
	background: #EC9004;
}

.type3 {
	background: #EC4F04;
}

.type3:hover {
	background: #F53B03;
}

body {
	margin: 0 auto;
	padding: 0;
	background: #9d261d
}

h1, h2, h3 {
	color: #ffffff;
}

.container {
	position: relative;
	top: 10%;
	width: 1000px;
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Enterprise Architecture CS544 May 2016</h1>
		<h3>Movie Ticket Booking Online Service</h3>
		<div>
			<div class="round-button float-left">
				<div class="round-button-circle">
					<a href="register" class="round-button">Register</a>
				</div>
			</div>
			<div class="round-button float-left">
				<div class="round-button-circle type2">
					<a href="staff" class="round-button">Staff List</a>
				</div>
			</div>
			<div class="round-button float-left">
				<div class="round-button-circle type3">
					<a href="customer" class="round-button">Customer List</a>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
</body>
</html>
