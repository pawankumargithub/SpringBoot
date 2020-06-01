<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form modelAttribute="cmd" action="update">

	<table align="center" bgcolor="cyan">


		<tr>

			<td>Id:</td>
			<td><form:input path="bookId" readonly="true" /></td>


		</tr>
		<tr>

			<td>Name:</td>
			<td><form:input path="bookName" /></td>


		</tr>
		<tr>

			<td>Price:</td>
			<td><form:input path="bookPrice" /></td>


		</tr>
		<tr>

			<td>Author:</td>
			<td><form:input path="bookAuthor" /></td>


		</tr>
		<tr>

			
			<td><input type="submit" value="update"></td>


		</tr>





	</table>

</form:form>
