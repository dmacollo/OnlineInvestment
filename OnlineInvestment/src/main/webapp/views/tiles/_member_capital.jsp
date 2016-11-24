<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add Capital</h2>
<form:form modelAttribute="cardTransaction">
	<table>
		<tr>
			<td>Name On Card</td>
			<td><input name="nameOnCard" type="text" value="${cardTransaction.nameOnCard}"></td>
		</tr>
		<tr>
			<td>Card Number</td>
			<td><input name="cardNumber" type="text" value="${cardTransaction.cardNumber}"></td>
		</tr>
		<tr>
			<td>Data Of Expiry(mm/yyyy)</td>
			<td><input name="dateOfExpiry" type="text" value="${cardTransaction.dateOfExpiry}"></td>
		</tr>
		<tr>
			<td>Transaction Amount</td>
			<td><input name="amount" type="number" value="${cardTransaction.amount}"></td>
		</tr>

	</table>
	<input type="hidden" name="transactionType" value="Credit Card"/>
	<input type="hidden" name="transactionDescription" value="Additional Investment."/>	
	<input type="submit" class="btn btn-primary btn-md" value="Submit" />
</form:form>