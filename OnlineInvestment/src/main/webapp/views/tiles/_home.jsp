<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<security:authorize access="hasRole('ROLE_USER')">
	<h1>Member Info</h1>
 	Full Name : ${activeMember.lastName}, ${activeMember.firstName} ${activeMember.middleName}<br />
 	Gender : ${activeMember.gender}<br />
 	Address :<br />
	<br />
 	${activeMember.address.street}<br />
 	${activeMember.address.city},${activeMember.address.state} ${activeMember.address.zip}<br />
 	${activeMember.address.country}<br />
 	Contact : ${activeMember.contact}<br />
	<br />
<!-- 	<h1>Capital Info</h1> -->

	<h2>Transactions</h2>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Tran Type</th>
					<th>Amount</th>
					<th>Date</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transaction" items="${activeMember.investmentTransactions}">
				<tr>
					<td>${transaction.transactionType}</td>
					<td>${transaction.transactionAmount}</td>
					<td>${transaction.transactionDate}</td>
					<td>${transaction.transactionDescription}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</security:authorize>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<div class="container">
		<div class="col-xs-3">
			<a href="<spring:url value="/user/add"/>"><img
				src="http://mumstudents.org/~985239/resource/images/users.png"
				alt="Users" /></a>
		</div>
		<div class="col-xs-3">
			<a href="<spring:url value="/member/list"/>"><img
				src="http://mumstudents.org/~985239/resource/images/members.png"
				alt="Members" /></a>
		</div>
		<div class="col-xs-3">
			<a href="<spring:url value="/staff/add"/>"><img
				src="http://mumstudents.org/~985239/resource/images/staff.png"
				alt="Staff" /></a>
		</div>
	</div>
</security:authorize>

