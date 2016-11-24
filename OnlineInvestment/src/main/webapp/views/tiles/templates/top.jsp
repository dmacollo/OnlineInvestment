<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar">
  <div class="container-fluid page-header">
    <div class="navbar-header">
      <a class="navbar-brand" href="<spring:url value="/home"/>"><img src="http://mumstudents.org/~985239/resource/images/logo.png"/></a>
    </div>
    <c:if test="${activeMember.id>0}">
     <ul class="nav navbar-nav">
      <li class="active"><a href="<spring:url value="/home"/>">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Member
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<spring:url value="/member/edit/${activeMember.id}"/>">Edit Info</a></li>
        </ul>
        
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Invest
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<spring:url value="/member/transaction/${activeMember.id}"/>">Add Capital</a></li>
        </ul>
      </li>
    </ul>
    </c:if>
     <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
      <li>
      	<security:authorize access="isAnonymous()">
	      	<a href="<spring:url value="/login"/>">
	      		<span class="glyphicon glyphicon-log-in"></span> Login
	      	</a>
      	</security:authorize>
		<security:authorize access="isAuthenticated()">
			<a href="<spring:url value="/logout"/>">
			Logout(<security:authentication property="principal.username"/>)</a>
		</security:authorize>

      </li>
    </ul>
  </div>
</nav>