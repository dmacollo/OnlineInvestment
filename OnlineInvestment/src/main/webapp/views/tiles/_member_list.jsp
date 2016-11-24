<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1>Member List</h1>
				
		<table class="table">
		<tr>
			<td> First Name </td>
			<td> Last Name </td>
			<td> Country </td>
			<td> State </td>
			<td> City </td>
			<td> Street </td>
			<td> ZipCode </td>
			<td> Contact </td>
			<td>&nbsp;</td>
			<!-- <td>Image</td> -->
			<td><%-- <img src="data:image/png;base64,${imageBase64}" height = "100px" width = "100px" /> --%></td>
			
		</tr>
		<c:forEach  var="memberNew" items="${memberlist}" >
		<tr>
			
			<td> ${memberNew.firstName}</td>
			
			<td>${memberNew.lastName} </td>
			
			<td>${memberNew.address.country} </td>
			
			<td>${memberNew.address.state} </td>
			
			<td>${memberNew.address.city} </td>
					
			<td>${memberNew.address.street} </td>
				
			<td>${memberNew.address.zip}</td>
			
			<td>${memberNew.contact}</td>
			 <%-- <td> <a href="<spring:url value="/member/edit/${memberNew.id}"/>">Edit</a></td> --%>
		</tr>
		</c:forEach>
			
	</table>

