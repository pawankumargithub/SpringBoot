<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <style>  
       .error{color:red}  
     </style>
	 
	  <form:form action="updateproduct" modelAttribute="product">
	  
	  <table bgcolor="cyan" align="center">
	  
	     <tr>
	        <td>ID:</td>
	       <td><form:input path="prodId" readonly="true"/></td>
	      
	     
	     </tr>
	      <tr>
	        <td>NAME:</td>
	       <td><form:input path="prodName"/></td>
	       <td><form:errors path="prodName" cssClass="error"/></td>
	     
	     </tr>
	      <tr>
	        <td>COST:</td>
	       <td><form:input path="prodCost"/></td>
	       <td><form:errors path="prodCost" cssClass="error"/></td>
	     
	    
	      <tr>
	        <td>VENDOR:</td>
	       <td><form:input path="vendor"/></td>
	        <td><form:errors path="vendor" cssClass="error"/></td>
	       <td><input type="submit" value="update"></td>
	      
	     
	     </tr>
	  
	  </table>
	  
	  
	  </form:form>>