<%@page import="com.te.labwebapp.beans.Thyroid"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

Thyroid t = (Thyroid) request.getAttribute("id");
%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");
%>
<%@ include file="AdminHomeNavBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Thyroid Report</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
</head>
<body>
<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%>
	</h1>
	<%
		}
	%>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green;"><%=msg%>
	</h1>
	<%
		}
	%>

	<fieldset>
		<form action="./searchThyroid">
			<table style="margin:auto;">
				<tr>
					<td>Enter patient id</td>
					<td>:</td>
					<td><input type="number" name="pid" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search report"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
	if (t != null) {
	%>
		<table border="1" style="margin:auto;">
	<tbody>
		<tr>
			<th>Test Name</th>
			<th>Result</th>
		</tr>
		<tr>
			<td>TRI IODO Thyronine</td>
			<td><%=t.getT1()%>g/dl</td>
		</tr>
		<tr>
			<td>Tyroxine</td>
			<td><%=t.getT2()%>g/dl</td>
		</tr>
		<tr>
			<td>Thyroid Stimulating Harmone</td>
			<td><%=t.getT3() %>g/dl</td>
		</tr>
	</tbody>
</table>
		
		


	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2>
		<%=errMsg%></h2>
	<%
	}
	%>

</body>
</html>