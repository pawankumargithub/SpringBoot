<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
  <style type="text/css">  
 .error{color:red}  
  </style>
  
  <noscript>
  <b>Enable java script</b>
  
  </noscript>
  
  
<body>
                  <h1 style="color: red;text-align: center;">Patient Registration</h1>
                  <script language="javascript" src="js/validation.js"></script>
                <form:form modelAttribute="patCmd" onsubmit="return validate(this)">
            
                <table bgcolor="gray" align="center">
                <tr>
                    <td>Name</td>
                    <td> <form:input path="patName" /></td>
                     <td> <form:errors path="patName" cssClass="error"/><span id="patNameErr"></span></td>
                </tr>
                 <tr>
                    <td>Age</td>
                    <td> <form:input path="patAge" /></td>
                     <td> <form:errors path="patAge" cssClass="error" /><span id="patAgeErr"></span></td>
                </tr>
                 <tr>
                    <td>Hospital</td>
                    <td> <form:input path="hospital" /></td>
                     <td> <form:errors path="hospital" cssClass="error"/><span id="patHospitalErr"></span></td>
                    
                </tr>
                 <tr>
                    <td>Location</td>
                    <td> <form:input path="location" /></td>
                      <td> <form:errors path="location" cssClass="error"/><span id="patLocationErr"></span></td>
                </tr>
                 <tr>
                    
                    <td> <input type="submit" value="register"></td>
                </tr>
                <form:hidden path="vflag"></form:hidden>
                </table>
                </form:form>
                
                <b style="color: blue;text-align: center;"> ${msg}</b>
                
               
</body>
</html>