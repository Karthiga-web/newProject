<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>CRUD Operators with Hibernate</title>
</head>
<body>

	<h3>Do you want to ADD a New Sweet to your Checklist of Sweets?!</h3>
	${msg }
	<form method="post" action="/newProject/sweets">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>Name of Sweet</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Price of Sweet(In Dollars$)</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
			<tr>
				<p>The Form appears again if you enter an incorrect price! So Please Enter a correct price!</p>
			</tr>
		</table>
	</form>

</body>
</html>
