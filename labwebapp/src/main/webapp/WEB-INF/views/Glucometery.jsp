<!DOCTYPE html>
<html lang="en">
<%
	String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");
%>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Glucometery Report</title>
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
<%@ include file="AdminHomeNavBar.jsp"%>
    <div class="container">
        <form action="addGlucometeryForm" class="form-group" method="post" >
            <h2 style="text-align: center; font-weight: bold; font-family: sans-serif; margin: 20px; color: black;POSITION: relative;
            top: 75px;">
                Enter Glucometery Report</h2>
            <div class="row jumbotron">
                
                <div class="col-md-12" style="margin-top: 15px;">
                    
                    <input type="number" name="g1"  class="form-control" placeholder="Fasting Blood Sugar *" required="required" >dl/cmm
                </div>
                <div class="col-md-12" style="margin-top: 15px;">
                    
                    <input type="number" name="g2"  class="form-control" placeholder="Post Prandial Blood Sugar *" >dl/cmm
                </div>
                <div class="col-md-12" style="margin-top: 15px;">
                    
                    <input type="number" name="g3"  class="form-control" placeholder="Glycosylated Haemoglobin *"> dl/cmm
                </div>
                
                <div class="col-md-12" style="margin-top: 15px;">
                    
                    <input type="number" name="g4"  class="form-control" placeholder="calcium *"> dl/cmm
                </div>
                
                 <div class="col-md-12" style="margin-top: 15px;">
                    
                    <input type="number" name="pid"  class="form-control" placeholder="Patient ID *">
                </div>

                <div class="col-12">
                    <button class="btn btn-primary mx-auto d-block mt-5" type="submit">submit</button>
                </div>
               
        </form>
    </div>
   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>