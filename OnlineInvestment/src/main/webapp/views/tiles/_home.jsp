<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form action="<spring:url value="/membership/form"/>" method="get">
	<input type="submit" value="New Applicant"/>
</form>

<form action="<spring:url value="/member/profile/1"/>" method="get">
	<input type="submit" value="Profile"/>
</form>

<form action="<spring:url value="/member/capital/1"/>" method="get">
	<input type="submit" value="Capital"/>
</form>


<form action="<spring:url value="/user/add"/>" method="get">
	<input type="submit" value="User"/>
</form>

<form action="<spring:url value="/staff/add"/>" method="get">
	<input type="submit" value="Staff"/>
</form>
