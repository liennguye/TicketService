<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Update Customer</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/customer/${page}"
		method="POST" commandName="customer">

		<form:hidden path="id" />
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Customer Name</label>
					<div>
						<form:input path="name" class="form-control" name="name"
							data-parsley-required="true" data-parsley-trigger="change"
							placeholder="Customer Name" />
					</div>
				</div>

				<div class="form-group">
					<label>Customer Address</label>
					<div>
						<form:input path="address" class="form-control" name="address"
							data-parsley-type="address" data-parsley-required="true"
							data-parsley-trigger="change"
							placeholder="805 N Main street, Fairfield, IA, 52556" />
					</div>
				</div>
				<div class="form-group">
					<label>Customer Email</label>
					<div>
						<form:input path="email" class="form-control" name="email"
							data-parsley-type="email" data-parsley-required="true"
							data-parsley-trigger="change" placeholder="hello@mum.edu" />
					</div>
				</div>

				<div class="form-group">
					<label>Login name</label>
					<div>
						<form:input disabled="true" path="userInfo.username" class="form-control" name="userInfo.username"
							data-parsley-required="true"
							data-parsley-trigger="change" placeholder="yourusername" />
					</div>
				</div>
				<!-- Role = RegisteredViewer?????? -->
				
				<form:hidden path="userInfo.role" value="${RegisteredViewer}"/>
				
				<div class="form-group text-center">
					<label></label>
					<div>
						<input type="submit" value="Save"
							class="btn btn-primary btn-block btn-lg btn-parsley" />
					</div>
				</div>

			</div>
		</div>
	</form:form>
</body>
</html>