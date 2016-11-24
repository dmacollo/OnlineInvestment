<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="col-xs-3">
  		<img src="http://mumstudents.org/~985239/resource/images/applicantinfo.png" alt="Applicant Info"/>
  	</div>
  	<div class="col-xs-3">
		<img src="http://mumstudents.org/~985239/resource/images/agreement.png" alt="Agreement"/>
  	</div>
  	<div class="col-xs-3">
		<img src="http://mumstudents.org/~985239/resource/images/documentupload.png" alt="Requirements" />  
  	</div>
  	<div class="col-xs-3">
		<img src="http://mumstudents.org/~985239/resource/images/payment.png" alt="Payment" class="img-thumbnail"/>  
  	</div>

</div>
<h2>Initial Investment</h2>
<table>
	<tr>
		<td>Membership Fee</td>
		<td>USD      100.00</td>
	<tr>
	<tr>
		<td>Capital Share</td>
		<td>USD 3,000.00</td>
	</tr>

	<tr>
		<td colspan="2">============================</td>
	</tr>
	<tr>
		<td>Total</td>
		<td>USD 3,100.00</td>
	</tr>
</table>
<h2>Payment Type</h2>

<form action="<spring:url value="/membership/payment/${activeMember.id}"/>" method="post">
	<input type="radio" name="paymentType" value="Credit Card" checked> Credit Card<br/>
	<table>
		<tr>
			<td>Name On Card</td>
			<td><input name="nameOnCard" type="text"></td>
		</tr>
		<tr>
			<td>Card Number</td>
			<td><input name="cardNumber" type="text"></td>
		</tr>
		<tr>
			<td>Data Of Expiry(mm/yyyy)</td>
			<td><input name="dateOfExpiry" type="text"></td>
		</tr>
		<tr>
			<td>Transaction Amount</td>
			<td><input name="amount" type="number"></td>
		</tr>
		
	</table>
	<input type="hidden" name="transactionType" value="Credit Card"/>
	<input type="hidden" name="transactionDescription" value="Initial Payment."/>
	<input type="submit" class="btn btn-primary btn-md" value="Submit" />
</form>