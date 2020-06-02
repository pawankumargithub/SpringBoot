<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red;text-align: center;">Find Book By Id</h1>

<form:form action="getonebook" modelAttribute="cmd">

	<table align="center">
		<tr>
			<td>Enter Id:</td>
			<td><form:input path="bookId" /></td>
		</tr>
		<tr>

			<td><input type="submit" value="find book"></td>
		</tr>
	</table>



</form:form>
