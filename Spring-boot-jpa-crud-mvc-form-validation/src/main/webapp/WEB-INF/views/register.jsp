<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <style>  
       .error{color:red}  
     </style>
<form:form modelAttribute="prodCmd">
 <form:errors path="*"/>
   <table bgcolor="cyan"  align="center">
   
       <tr>
        <td>NAME:</td>
         <td><form:input path="prodName"/></td>
         <td><form:errors path="prodName" cssClass="error"/></td>
       
       </tr>
         <tr>
         <td>COST:</td>
         <td><form:input path="prodCost"/></td>
        
       
       </tr>
        <tr>
         <td>VENDOR:</td>
         <td><form:input path="vendor"/></td>
         
         <td><input type="submit" value="save"></td>
        
       
       </tr>
        
   
   </table>

</form:form>>