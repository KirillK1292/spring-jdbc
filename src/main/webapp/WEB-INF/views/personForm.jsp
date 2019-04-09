<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Person form</title>
	</head>
	<body>	
		<form:form action="${action}" modelAttribute="person" method="post" onsubmit="return checkFields(this)">
			<form:hidden path="id"/>
			<table>
				<tr> <td><form:label path="firstName">First name</form:label></td><td><form:input type="text" path="firstName"/></td> </tr>
				<tr> <td><form:label path="lastName">Last name</form:label></td><td><form:input type="text" path="lastName"/></td> </tr>
				<tr> 
					<td><form:label path="sex">Sex</form:label></td>
					 <td>
					 	<form:select path="sex">
					    	<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select>
					</td>
				</tr>
				<tr> <td><form:label path="birthdate">Birthdate</form:label></td><td><form:input type="text" path="birthdate" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"/></td> </tr>
				<tr> <td><form:label path="phone">Phone</form:label></td><td><form:input type="text" path="phone" placeholder="+375(XX)XXX-XX-XX" pattern="\+375\([0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}"/></td> </tr>
				<tr> <td><form:label path="email">Email</form:label></td><td><form:input type="email" path="email"/></td> </tr>
			</table>
			<input id="submit" type="submit" value="${button}">
		</form:form>
		<script type="text/javascript">
			function checkFields(form) {
				var fn = form.firstName.value;
				var ln = form.lastName.value;
				var date = form.birthdate.value;
				var phone = form.phone.value;
				if(fn == "" || ln == "" || date == "" || phone == "") {
					return false;
				}
			}
		</script>
	</body>
</html>