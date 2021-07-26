<%@page import="com.te.labwebapp.beans.PatientLab"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<PatientLab> infoBeans = (List) request.getAttribute("infos");
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
<title>Samples List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous" />

<!-- font awesome  -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous" />
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
		if (infoBeans != null) {
	%>
	<fieldset>
		<table  border="1" style="width:100%">
			<tr>
				<th style="text-align: center">Patient ID</th>
				<th style="text-align: center">Name</th>
				<th style="text-align: center">Email</th>
				<th style="text-align: center">SampleDate</th>
				<th style="text-align: center">Sample ID</th>
				<th style="text-align: center">Thyroid Profile</th>
				<th style="text-align: center">Glucometery Profile</th>
			</tr>
			<%
				for (PatientLab infoBean : infoBeans) {
			%>
			<tr>
				<td style="text-align: center"><%=infoBean.getPatient_id()%></td>
				<td style="text-align: center"><%=infoBean.getPatient_name()%></td>
				<td style="text-align: center"><%=infoBean.getPatient_email()%></td>
				<td style="text-align: center"><%=infoBean.getSampleDate()%></td>
				<td style="text-align: center"><%=infoBean.getSample_id()%></td>
				<td style="text-align: center"><button type="button" class="btn btn-warning"> <a href="./addThyroid">Add Report</a> </button><button type="button" class="btn btn-danger"><a href="./viewThyroid">View Report</a></button></td>
				<td style="text-align: center"><button type="button" class="btn btn-warning"> <a href="./addGlucometery">Add Report</a> </button><button type="button" class="btn btn-danger"><a href="./viewGlucometery">View Report</a></button></td>
			</tr>
			<%
				}
			%>
		</table>

	</fieldset>
	<%
		}
	%>
</body>
</html>